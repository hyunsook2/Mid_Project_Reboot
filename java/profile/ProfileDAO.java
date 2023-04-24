package profile;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBConnPool;

public class ProfileDAO extends JDBConnPool{


	public ProfileDAO() {
		super();
	}

	public ProfileDTO getMember(String id) {
		ProfileDTO pdto = new ProfileDTO();
		String SQL = "SELECT * FROM INFO WHERE id = ?";
		try {
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pdto.setId(rs.getString("id"));
				pdto.setDeptn(rs.getInt("deptn"));
				pdto.setName(rs.getString("name"));
				pdto.setPassword(rs.getString("pass"));
				pdto.setAd(rs.getString("ad"));
				pdto.setPnum(rs.getInt("pnum"));
				pdto.setIn_d(rs.getDate("in_d"));
				pdto.setOut_d(rs.getDate("out_d"));
				pdto.setBday(rs.getDate("bday"));
				pdto.setGrade(rs.getInt("grade"));
				
			
			} 
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		} 
		
		return pdto;       
	}
	public ProfileDTO editMember(String id, String password, int pnum, String ad, Date bday) {
	    ProfileDTO pdto = new ProfileDTO();
	    String SQL = "UPDATE INFO SET pass = ?, pnum = ?, ad = ?, bday = ? WHERE id = ? ";
	    try {
	        psmt = con.prepareStatement(SQL);
	        psmt.setString(1, password);
	        psmt.setInt(2, pnum);
	        psmt.setString(3, ad);
	        psmt.setDate(4, bday);
	        psmt.setString(5, id);
	        int result = psmt.executeUpdate();
	        if (result > 0) {
	            pdto.setPassword(password);
	            pdto.setAd(ad);
	            pdto.setBday(bday);
	            pdto.setPnum(pnum);
	            System.out.println("됐음");
	        } 
	    } catch (Exception e) {
	        System.out.println("에러 발생");
	        e.printStackTrace();
	    } 
	    
	    return pdto; 
	}
	
	public ProfileDTO getManager(String id) {
		
		ProfileDTO pdto = new ProfileDTO();
		String SQL = "SELECT ID, NAME FROM info WHERE DEPTN = (SELECT DEPTN FROM info WHERE ID = ?) AND GRADE = 0";
		try {
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pdto.setId(rs.getString("id"));
				pdto.setName(rs.getString("name"));
			} 
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		} 
		
		return pdto;    
	}
}





   
   
   
   

