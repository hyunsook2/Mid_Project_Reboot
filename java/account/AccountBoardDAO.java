package account;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.sql.*;
import java.sql.Date;

import common.JDBConnPool;
import common.JDBConnect;

public class AccountBoardDAO extends JDBConnPool{
	public AccountBoardDAO() {
		super();
	}

	public int insertData(AccountBoardDTO dto) {
		int result=0;
		String query = "INSERT INTO info(id,deptn, name,grade,in_d, off_d) VALUES (?, ?, ?, ?, ?, ?)";
		
	    try {
	        
	        psmt = con.prepareStatement(query);
	        psmt.setString(1, dto.getId());
	        psmt.setInt(2, dto.getDeptn());
	        psmt.setString(3, dto.getName());
	        psmt.setInt(4, dto.getGrade());
	        psmt.setDate(5, new java.sql.Date(dto.getIn_d().getTime()));
	        psmt.setString(6, dto.getOff_d());
	        result = psmt.executeUpdate();
	        
	    } catch (Exception e) {
	    	System.out.println("게시물 입력 중 예외");
	        e.printStackTrace();
	    }
	    return result;
	}

	public int countAll(Map<String, Object> map) {
		int totalCount = 0;
		String query="select count(*) from info";
		//조건이 여러개 들어가는 쿼리문을 작성해야한다! where와 and 를 어떻게 해결할 것인가...
		// 조건에 맞게 WHERE 절을 생성
		if(map.isEmpty()) {
		    query += ";";
		} else {
		    query += " where";
		    
		    if(map.get("searchDept")!=null){
				query += " deptn like '%"+ map.get("searchDept")+"%' and";
			}
			if(map.get("searchId")!=null){
				query += " id like '%"+ map.get("searchId")+"%' and";
			}
			if(map.get("searchName")!=null){
				query += " name like '%"+ map.get("searchName")+"%' and";
			}
			
			// 맨 마지막 AND 제거
			query = query.substring(0, query.length() - 4);
		}

		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			rs.next(); //resultset으로 불러온 첫 번째 줄은 메뉴바라서 다음 줄로 넘겨줘야 한다.
			totalCount=rs.getInt(1);
		}catch(Exception e) {
			System.out.println("게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<AccountBoardDTO> getListPage(Map<String, Object> map) {
		List<AccountBoardDTO> bl = new Vector<AccountBoardDTO>();
		String query = "select * from info";
		
		if(map.isEmpty()) {
		    query += ";";
		} else {
		    query += " where";

			if(map.get("searchDept")!=null){
				query += " deptn like '%"+ map.get("searchDept")+"%' and";
			}
			if(map.get("searchId")!=null){
				query += " id like '%"+ map.get("searchId")+"%' and";
			}
			if(map.get("searchName")!=null){
				query += " name like '%"+ map.get("searchName")+"%' and";
			}
			query = query.substring(0, query.length() - 4);
		}
		

		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				AccountBoardDTO dto = new AccountBoardDTO(); 
				dto.setDeptn(rs.getInt("deptn"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				bl.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 목록 읽는 중 에러");
			e.printStackTrace();
		}
		return bl;
	}
	


	//인사팀 수정 페이지에서 db 읽어오기
	public AccountBoardDTO getView(String id) {
		AccountBoardDTO dto = new AccountBoardDTO();
		String query = "select * from info where id=?";
		try {
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setDeptn(rs.getInt("deptn"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getInt("grade"));
				dto.setIn_d(rs.getDate("in_d"));
				dto.setOff_d(rs.getString("off_d"));
				dto.setPass(rs.getString("pass"));
				dto.setOut_d(rs.getDate("out_d"));
				dto.setBday(rs.getDate("bday"));
				dto.setPnum(rs.getString("pnum"));
				dto.setAd(rs.getString("ad"));
			}
		}catch(Exception e) {
			System.out.println("상세보기 중 예외");
			e.printStackTrace();
		}
		return dto;
	}

	public int setUpdate(AccountBoardDTO dto) {
		
		
		int result = 0;
		String query = "UPDATE info SET deptn = ?, name = ?, grade = ?, in_d = ?, off_d = ?, pass = ?, out_d = ? , bday = ?, pnum = ?, ad = ? WHERE id = ?";
		try {
		    psmt = con.prepareStatement(query);
		    psmt.setInt(1, dto.getDeptn());
		    psmt.setString(2, dto.getName());
		    psmt.setInt(3, dto.getGrade());
		    psmt.setDate(4,  (Date) dto.getIn_d());
		    psmt.setString(5, dto.getOff_d());
		    psmt.setString(6, dto.getPass());
		    psmt.setDate(7, (Date) dto.getOut_d());
		    psmt.setDate(8, (Date) dto.getBday());
		    psmt.setString(9, dto.getPnum());
		    psmt.setString(10, dto.getAd());
		    psmt.setString(11, dto.getId()); // WHERE 조건절에서 id 값과 일치하는 레코드를 수정
		    result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외");
		    e.printStackTrace();
		} 
		return result;
	}

	public int setDelete(String id) {
		int result=0;
		try {
			String query="delete from info where id=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			result=psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 에러");
			e.printStackTrace();
		}
		return result;
	}
}
