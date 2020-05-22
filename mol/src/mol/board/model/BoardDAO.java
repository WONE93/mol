package mol.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import mol.common.ConnectionManager;


public class BoardDAO {
	// 등록
	Connection conn = null;
	PreparedStatement psmt = null;
	
	public void boardInsert(BoardVO board) {
	
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into board (seq , id, title , recommend ,reason, regdt )"
					+ " values ( seq_mol.nextval, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);   

			// 3. 실행
			psmt.setString(1, board.getId());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getRecommend());
			psmt.setString(4, board.getReason());
			

			psmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}
	
	// 전체조회
	public ArrayList<BoardVO> getBoardList(int start, int end, String id) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // 1.어레이리스트에 담기


		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1 "; 
			if(id != null && ! id.isEmpty() ) {
				strWhere += " and id like '%' ||? '%' " ;	
		}

			// 2. 쿼리 준비
			String sql = "select B.* from ( select A.* ,rownum RN from ( "
						+" select board.*, member.name from board join member on(board.id = member.id) " 
						+ strWhere + " order by seq desc"
						+" ) A ) B where RN between ? and ? ";
			psmt = conn.prepareStatement(sql);
			
			int post = 1;
			if(id != null && ! id.isEmpty() ) {
				psmt.setString(post++, id);
			}
			psmt.setInt(post++, start);
			psmt.setInt(post++, end); //1페이지 2페이지 나누기 처리		
			ResultSet rs = psmt.executeQuery();
			// 3. statement 실행
//			psmt.setString(1, id); // 첫번재 물음표 값이 id다  // 3. 단건에서의 ? 빠졌으니 set도 필요없음
	
			while (rs.next()) {
				BoardVO vo = new BoardVO(); // 4. 위치 while 안으로
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));// 결과값에 담기
				vo.setId(rs.getString("id"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo); // 5.리스트에 담기
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return list;
	}

	// 단건조회
	public BoardVO getBoard(String seq) {
		BoardVO vo = new BoardVO();

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select * from board where seq=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, seq); // 첫번재 물음표 값이 id다
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));// 결과값에 담기
				vo.setRecommend(rs.getString("recommend"));
				vo.setReason(rs.getString("reason"));
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return vo;
	}
	
//	//like count
//	public int getLike(BoardVO board) {
//		int r = 0;
//		ResultSet rs = null;
//		try {
//			
//		  //1. DB연결
//			conn = ConnectionManager.getConnnect();
//			
//		  //2. sql 구문 준비
//			String sql = "update board set love= nvl(love,0)+1 where seq = ?";
//			
//			psmt = conn.prepareStatement(sql);
//			
//			//실행
////			psmt.setInt(1, Integer.parseInt(seq));
//			psmt.setString(1, board.getLove());
//			psmt.setString(2, board.getSeq());
//			
//			r = psmt.executeUpdate();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			// 5. 연결해제
//			ConnectionManager.close(conn);
//		}
//		return r;
//	}
	
	// 수정
		public int boardUpdate(BoardVO board) {
		
			Connection conn = null;
			PreparedStatement psmt = null;

			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();

				// 2. sql구문 준비
				String sql = "update board set title=?, recommend=?, reason=?" + " where seq=?";

				psmt = conn.prepareStatement(sql);

				// 3. 실행
				psmt.setString(1, board.getTitle());
				psmt.setString(2, board.getRecommend());
				psmt.setString(3, board.getReason());
				psmt.setString(4, board.getSeq());

				psmt.executeUpdate();

		

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 5. 연결해제
				ConnectionManager.close(conn);
			}

			return -1;
		}
		
		//페이징전체건수
		public int getCount(String id) {
			int cnt = 0;
			try {
				
				conn = ConnectionManager.getConnnect();
				
				String strWhere = " where 1 = 1 ";
				if(id != null && ! id.isEmpty() ) {
					strWhere += " and id like '%' || ? || '%' " ;
				}
				
				String sql = "select count(*) from board" + strWhere;
				psmt = conn.prepareStatement(sql);
				
				int post = 1;
				if(id != null && ! id.isEmpty() ) {
					psmt.setString(post++, id);
				}
				
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					cnt = rs.getInt(1); 
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(conn);
			}
			return cnt;
			
		}
		
		   //삭제
		   public void deleteBoard(String seq) {
		      
		      try {
		         // 1. DB 연결
		         conn = ConnectionManager.getConnnect();

		         // 2. sql구문 준비
		         String sql = "delete from board where seq= ? ";

		  
		         psmt = conn.prepareStatement(sql);

		         // 3. 실행
		         psmt.setString(1, seq);

		         psmt.executeUpdate();

		         // 4. 결과처리

		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         // 5. 연결해제
		         ConnectionManager.close(conn);
		      }

		   }
		   
		

}
