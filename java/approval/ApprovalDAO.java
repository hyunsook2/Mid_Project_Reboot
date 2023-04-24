package approval;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class ApprovalDAO extends JDBConnPool {

	public int insertWrite(ApprovalDTO dto) {
		int result=0;
		String sql = "INSERT INTO APPROVAL(IDX,ID, NAME, DEPTN,TITLE, CONTENT, BOSS, REGDATE, OFILE,NFILE) VALUES(SEQ_APPROVAL_NUM.NEXTVAL,?,?,?,?,?,?,SYSDATE,?,?)";
	try {
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getName());
		psmt.setInt(3, dto.getDeptn());
		psmt.setString(4, dto.getTitle());
		psmt.setString(5, dto.getContent());
		psmt.setString(6, dto.getBoss());
		psmt.setString(7, dto.getOfile());
		psmt.setString(8, dto.getNfile());

		result = psmt.executeUpdate();
	}catch(Exception e) {
		System.out.println("게시물 입력 중 예외");
		e.printStackTrace();
	}
	return result;
	
	}

	public int countAllWait(Map<String, Object> map) {
		int totalCount=0;
		
		String sql = "SELECT COUNT(*) FROM APPROVAL";
		if(map.get("searchStr")!=null) {
			sql += " WHERE " +map.get("searchType")+" LIKE '%"+map.get("searchStr")+"%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);	
			rs.next();	//ResultSet은 맨 처음은 빈	stmt = con.createStatement();	공간이기 때문에 한칸 넘기고 해야 함.
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("wait게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}
	public int countAllNo(Map<String, Object> map) {
		int totalCount=0;
		
		String sql = "SELECT COUNT(*) FROM APPROVALNO";
		if(map.get("searchStr")!=null) {
			sql += " WHERE " +map.get("searchType")+" LIKE '%"+map.get("searchStr")+"%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);	
			rs.next();	//ResultSet은 맨 처음은 빈	stmt = con.createStatement();	공간이기 때문에 한칸 넘기고 해야 함.
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("wait게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}
	public int countAllOk(Map<String, Object> map) {
		int totalCount=0;
		
		String sql = "SELECT COUNT(*) FROM APPROVALOK";
		if(map.get("searchStr")!=null) {
			sql += " WHERE " +map.get("searchType")+" LIKE '%"+map.get("searchStr")+"%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);	
			rs.next();	//ResultSet은 맨 처음은 빈	stmt = con.createStatement();	공간이기 때문에 한칸 넘기고 해야 함.
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("wait게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}
	

	public List<ApprovalDTO> getListWaitPage(Map<String, Object> map, String id) {
		List<ApprovalDTO> bl = new Vector<>();
		
		String sql = "SELECT PNUM, S.* FROM ( "
		           + "SELECT ROWNUM AS PNUM, A.* "
		           + "FROM ( SELECT * FROM APPROVAL "
		           + "       WHERE DEPTN = (SELECT DEPTN FROM INFO WHERE ID = ?) ";

		if(map.get("searchStr")!=null) {
		    sql += " AND " + map.get("searchType") + " LIKE '%" + map.get("searchStr") + "%' ";
		}

		sql += "       ORDER BY REGDATE DESC ) A "
		     + ") S "
		     + "WHERE PNUM BETWEEN ? AND ?";
			
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, map.get("start").toString());
				psmt.setString(3, map.get("end").toString());
				rs=psmt.executeQuery();
				while(rs.next()) {
					
					ApprovalDTO dto = new ApprovalDTO();
					
					dto.setIdx(rs.getString("idx"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setRegdate(rs.getDate("regdate"));
					dto.setOfile(rs.getString("ofile"));
					dto.setNfile(rs.getString("nfile"));
					dto.setState(rs.getString("state"));
					
					bl.add(dto);
				}
			}catch(Exception e) {
				System.out.println("대기 게시물 목록 읽는 중 에러");
				e.printStackTrace();
			}
		
		return bl;
	}
	public List<ApprovalDTO> getListNoPage(Map<String, Object> map, String id) {
		List<ApprovalDTO> bl = new Vector<>();
		
		String sql = "SELECT PNUM, S.* FROM ( "
		           + "SELECT ROWNUM AS PNUM, A.* "
		           + "FROM ( SELECT * FROM APPROVALNO "
		           + "       WHERE DEPTN = (SELECT DEPTN FROM INFO WHERE ID = ?) ";

		if(map.get("searchStr")!=null) {
		    sql += " AND " + map.get("searchType") + " LIKE '%" + map.get("searchStr") + "%' ";
		}

		sql += "       ORDER BY REGDATE DESC ) A "
		     + ") S "
		     + "WHERE PNUM BETWEEN ? AND ?";
			
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, map.get("start").toString());
				psmt.setString(3, map.get("end").toString());
				
				
				rs=psmt.executeQuery();
				while(rs.next()) {
					
					ApprovalDTO dto = new ApprovalDTO();
					
					dto.setIdx(rs.getString("idx"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setRegdate(rs.getDate("regdate"));
					dto.setOfile(rs.getString("ofile"));
					dto.setNfile(rs.getString("nfile"));
					dto.setState(rs.getString("state"));
					
					bl.add(dto);
				}
			}catch(Exception e) {
				System.out.println("반려 게시물 목록 읽는 중 에러");
				e.printStackTrace();
			}
		
		return bl;
	}	
	
	public List<ApprovalDTO> getListOkPage(Map<String, Object> map, String id) {
		List<ApprovalDTO> bl = new Vector<>();
		
		String sql = "SELECT PNUM, S.* FROM ( "
		           + "SELECT ROWNUM AS PNUM, A.* "
		           + "FROM ( SELECT * FROM APPROVALOK "
		           + "       WHERE DEPTN = (SELECT DEPTN FROM INFO WHERE ID = ?) ";

		if(map.get("searchStr")!=null) {
		    sql += " AND " + map.get("searchType") + " LIKE '%" + map.get("searchStr") + "%' ";
		}

		sql += "       ORDER BY REGDATE DESC ) A "
		     + ") S "
		     + "WHERE PNUM BETWEEN ? AND ?";
			
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, map.get("start").toString());
				psmt.setString(3, map.get("end").toString());
				
				
				rs=psmt.executeQuery();
				while(rs.next()) {
					
					ApprovalDTO dto = new ApprovalDTO();
					
					dto.setIdx(rs.getString("idx"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setRegdate(rs.getDate("regdate"));
					dto.setOfile(rs.getString("ofile"));
					dto.setNfile(rs.getString("nfile"));
					dto.setState(rs.getString("state"));
					
					bl.add(dto);
				}
			}catch(Exception e) {
				System.out.println("승인 게시물 목록 읽는 중 에러");
				e.printStackTrace();
			}
		
		return bl;
	}	

	public ApprovalDTO getView(String idx) {
		ApprovalDTO dto = new ApprovalDTO();
		String sql="SELECT * FROM APPROVAL WHERE IDX=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setCompanion(rs.getString("companion"));
				dto.setState(rs.getString("state"));

			}
		} catch (Exception e) {
			System.out.println("대기 상세보기 중 예외");
			e.printStackTrace();
		}
				
		return dto;
	}
	
	public ApprovalDTO getNoView(String idx) {
		ApprovalDTO dto = new ApprovalDTO();
		String sql="SELECT * FROM APPROVALNO WHERE IDX=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setCompanion(rs.getString("companion"));
				dto.setState(rs.getString("state"));

			}
		} catch (Exception e) {
			System.out.println("반려 상세보기 중 예외");
			e.printStackTrace();
		}
				
		return dto;
	}
	
	public ApprovalDTO getOkView(String idx) {
		ApprovalDTO dto = new ApprovalDTO();
		String sql="SELECT * FROM APPROVALOK WHERE IDX=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setCompanion(rs.getString("companion"));
				dto.setState(rs.getString("state"));

			}
		} catch (Exception e) {
			System.out.println("승인 상세보기 중 예외");
			e.printStackTrace();
		}
				
		return dto;
	}
	
	public int noPostUpdate(ApprovalDTO dto) {
		int result=0;
		String sql = "INSERT INTO APPROVALNO (IDX,ID, NAME, DEPTN,TITLE, CONTENT, STATE, BOSS, REGDATE, OFILE,NFILE,COMPANION) VALUES(SEQ_APPROVALNO_NUM.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?,?,?)";
	try {
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getName());
		psmt.setInt(3, dto.getDeptn());
		psmt.setString(4, dto.getTitle());
		psmt.setString(5, dto.getContent());
		psmt.setString(6, dto.getState());
		psmt.setString(7, dto.getBoss());
		psmt.setString(8, dto.getOfile());
		psmt.setString(9, dto.getNfile());
		psmt.setString(10, dto.getCompanion());

		result = psmt.executeUpdate();
	}catch(Exception e) {
		System.out.println("게시물 입력 중 예외");
		e.printStackTrace();
	}
	return result;
	
	}
	
	public int okPostUpdate(ApprovalDTO dto) {
		int result=0;
		String sql = "INSERT INTO APPROVALOK (IDX,ID, NAME, DEPTN,TITLE, CONTENT, STATE, BOSS, REGDATE, OFILE,NFILE,COMPANION) VALUES(SEQ_APPROVALOK_NUM.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?,?,?)";
	try {
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getName());
		psmt.setInt(3, dto.getDeptn());
		psmt.setString(4, dto.getTitle());
		psmt.setString(5, dto.getContent());
		psmt.setString(6, dto.getState());
		psmt.setString(7, dto.getBoss());
		psmt.setString(8, dto.getOfile());
		psmt.setString(9, dto.getNfile());
		psmt.setString(10, dto.getCompanion());

		result = psmt.executeUpdate();
	}catch(Exception e) {
		System.out.println("게시물 입력 중 예외");
		e.printStackTrace();
	}
	return result;
	
	}

	public int approvalDelete(String idx) {
		int result = 0;
		try {
			String sql="DELETE FROM APPROVAL WHERE IDX=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 에러");
			e.printStackTrace();
		}
		
		return result;
	}

	
}
