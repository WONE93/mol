package mol.comments.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import mol.common.ConnectionManager;

public class CommentsDAO {
	// 등록
	Connection conn = null;
	PreparedStatement psmt = null;
	
	public void commentsInsert(CommentsVO comments) {
	
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into comments (cseq ,bseq ,id, comments ,  regdt )"
					+ " values ( seq_mol.nextval,?, ?, ?, sysdate) ";
				

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, comments.getBseq());
			psmt.setString(2, comments.getId());
			psmt.setString(3, comments.getComments());
		
		

			psmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
	}
	
	// 전체조회
	public ArrayList<CommentsVO> getComments(String bseq) {
		ArrayList<CommentsVO> list = new ArrayList<CommentsVO>(); // 1.어레이리스트에 담기


		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select id, comments, cseq, bseq from comments where bseq = ? order by cseq desc ";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, bseq); // 첫번재 물음표 값이 id다  // 3. 단건에서의 ? 빠졌으니 set도 필요없음
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				CommentsVO comments = new CommentsVO();
				comments.setId(rs.getString("id"));
				comments.setComments(rs.getString("comments"));
				comments.setCseq(rs.getString("cseq"));
				comments.setBseq(rs.getString("bseq"));
				
		
				list.add(comments); // 5.리스트에 담기
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
	
	  //삭제
	   public void deleteComments(String bseq) {
	      
	      try {
	         // 1. DB 연결
	         conn = ConnectionManager.getConnnect();

	         // 2. sql구문 준비
	         String sql = "delete from comments where bseq= ? ";

	  
	         psmt = conn.prepareStatement(sql);

	         // 3. 실행
	         psmt.setString(1, bseq);

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
