package mol.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import mol.common.ConnectionManager;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	
	// 한건조회
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select * from member where id=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id); // 첫번재 물음표 값이 id다
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setPath(rs.getString("path"));				
				vo.setIntroduction(rs.getString("introduction"));		
				vo.setRegdt(rs.getString("regdt")); // 결과값에 담기
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
	
	//회원가입 멤버등록
	public void memberInsert(MemberVO member) {

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, gender, path, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getPath());
			psmt.setString(6, member.getIntroduction());
			

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}


	}
	
	// 수정
	public void memberUpdate(MemberVO member) {

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd=?, name=?, " + "gender=?, path=?, " + "introduction=?"
					+ " where id=?"; // id는 pk라서 수정불가

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(6, member.getId());
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getGender());
			psmt.setString(4, member.getPath());
			psmt.setString(5, member.getIntroduction());

			psmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}


}
