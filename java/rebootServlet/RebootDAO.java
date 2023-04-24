package rebootServlet;

import common.JDBConnPool;
import profile.ProfileDTO;

public class RebootDAO extends JDBConnPool {
	
	// 기본생성자
	public RebootDAO() {
		super();
	}
	
	public boolean confirmid(String id) {
		boolean isRight = false;
		try {
			String sql="SELECT COUNT(*) FROM INFO WHERE ID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1) {
				isRight = true;
			}
		} catch (Exception e) {
			System.out.println("아이디 검증 중 에러");
			e.printStackTrace();
		}
		return isRight;
	}
	
	public boolean confirmPassword(String id, String pass) {
		boolean isRight = false;
		try {
			String sql="SELECT COUNT(*) FROM INFO WHERE ID=? AND PASS=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1) {
				isRight = true;
			}
		} catch (Exception e) {
			System.out.println("암호 검증 중 에러");
			e.printStackTrace();
		}
		return isRight;
	}
	
	

}