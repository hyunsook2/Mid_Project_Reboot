package Am;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class AmDAO2 extends JDBConnPool{

	public AmDAO2() {
		super();
	}

	public int insertDB(AmDTO2 dto) {
		int res=0;
		String sql = "insert into am2(idx, id, type, day_t, time_s, time_e) values (seq_num.NEXTVAL ,?,?,?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1,dto.getId());
			psmt.setInt(2,dto.getType());
			psmt.setString(3, dto.getDay_t());
			psmt.setString(4, dto.getTime_s());
			psmt.setString(5, dto.getTime_e());
			System.out.println(dto.getId());
			res= psmt.executeUpdate();
			System.out.println(res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public AmDTO2 getAmMember2(int idx) {
		AmDTO2 a2dto = new AmDTO2();
		String SQL = "SELECT * FROM AM2 WHERE idx = ?";
		try {
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			if (rs.next()) {
				a2dto.setIdx(rs.getInt("idx"));
				a2dto.setId(rs.getString("id"));
				a2dto.setType(rs.getInt("type"));
				a2dto.setDay_t(rs.getString("day_t"));
				a2dto.setTime_s(rs.getString("tims_s"));
				a2dto.setTime_e(rs.getString("time_e"));
			} 
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		} 	
		return a2dto;       
	}
	
	public List<AmandInfoDto> getCommution(String id){
		List<AmandInfoDto> list = new ArrayList<>();
		String SQL = "select a.idx ,i.ID, i.DEPTN, i.NAME,  a.TYPE, a.DAY_T, a.TIME_S, a.TIME_E from info i, am2 a "
				+ "where i.id=a.id and a.id=?";
		try {
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				AmandInfoDto dto = new AmandInfoDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setDeptn(rs.getString("deptn"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString( "type"));
				dto.setDay_t(rs.getString("day_t"));
				dto.setTime_s(rs.getString("time_s"));
				dto.setTime_e(rs.getString("time_e"));
				list.add(dto);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public int countAll(Map<String, Object> map) {
	      int totalCount=0;
	      String sql = "SELECT COUNT(*) FROM am2";
//	      if(map.get("searchStr")!=null) {
//	         sql += " where " +map.get("searchType")+" like '%"+map.get("searchStr")+"%'";
//	      }
	      try {
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(sql);   
	         rs.next();   //ResultSet은 맨 처음은 빈   stmt = con.createStatement();   공간이기 때문에 한칸 넘기고 해야 함.
	         totalCount = rs.getInt(1);
	      }catch(Exception e) {
	         System.out.println("게시물 카운트 중 에러");
	         e.printStackTrace();
	      }
	      return totalCount;
	   }

	 public List<AmandInfoDto> getListPage(Map<String, Object> map, String id) {
	      List<AmandInfoDto> bl = new Vector<>();     
	      String sql = "SELECT * FROM " +
	              "(SELECT ROWNUM AS RN, S.* " +
	              "FROM (SELECT a.idx, i.id, i.deptn, i.name, a.type, a.day_t, a.time_s, a.time_e " +
	              "FROM AM2 a, info i WHERE i.id=a.id AND a.id=?";

				  if (map.get("searchStr") != null) {
				     sql += " AND " + map.get("searchType") + " LIKE '%" + map.get("searchStr") + "%'";
				  }
			
				  sql += " ORDER BY a.idx DESC) S) " +
				          "WHERE RN BETWEEN ? AND ?";
	         try {
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1, id);
	            psmt.setString(2, map.get("start").toString());
	            psmt.setString(3, map.get("end").toString());
	            rs=psmt.executeQuery();
	            while(rs.next()) {
	               AmandInfoDto dto = new AmandInfoDto();
	               dto.setIdx(rs.getInt("idx"));
	               dto.setId(rs.getString("id"));
	               dto.setName(rs.getString("name"));
	               dto.setDeptn(rs.getString("deptn"));
	               dto.setDay_t(rs.getString("day_t"));
	               dto.setTime_s(rs.getString("time_s"));
	               dto.setTime_e(rs.getString("time_e"));
	               dto.setType(rs.getString("type"));
	               bl.add(dto);
	            }
	         }catch(Exception e) {
	            System.out.println("게시물 목록 읽는 중 에러");
	            e.printStackTrace();
	         }
	      return bl;
	   }
	 
	 public int ManagerGrade(String id) {
		 int count=0;
		 String sql = "SELECT count(grade) FROM info where grade = 0 and id = ?";
	      try {
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1, id);
	         rs=psmt.executeQuery();
	         rs.next();   //ResultSet은 맨 처음은 빈   stmt = con.createStatement();   공간이기 때문에 한칸 넘기고 해야 함.
	         count = rs.getInt(1);
	      }catch(Exception e) {
	         System.out.println("grade가져오는 중 에러");
	         e.printStackTrace();
	      }
		 return count;
	 }
	 
	public List<AmandInfoDto> ManagergetListPage(Map<String, Object> map) {
	      List<AmandInfoDto> bl = new Vector<>();     
	      String sql = "SELECT * FROM " +
	              "(SELECT ROWNUM AS RN, S.* " +
	              "FROM (SELECT a.idx, i.id, i.deptn, i.name, a.type, a.day_t, a.time_s, a.time_e " +
	              "FROM AM2 a, info i WHERE i.id=a.id ";

				  if (map.get("searchStr") != null) {
				     sql += " AND " + map.get("searchType") + " LIKE '%" + map.get("searchStr") + "%'";
				  }
			
				  sql += " ORDER BY a.idx DESC) S) " +
				          "WHERE RN BETWEEN ? AND ?";
	         try {
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1, map.get("start").toString());
	            psmt.setString(2, map.get("end").toString());
	            rs=psmt.executeQuery();
	            while(rs.next()) {
	               AmandInfoDto dto = new AmandInfoDto();
	               dto.setIdx(rs.getInt("idx"));
	               dto.setId(rs.getString("id"));
	               dto.setName(rs.getString("name"));
	               dto.setDeptn(rs.getString("deptn"));
	               dto.setDay_t(rs.getString("day_t"));
	               dto.setTime_s(rs.getString("time_s"));
	               dto.setTime_e(rs.getString("time_e"));
	               dto.setType(rs.getString("type"));
	               bl.add(dto);
	            }
	         }catch(Exception e) {
	            System.out.println("게시물 목록 읽는 중 에러");
	            e.printStackTrace();
	         }
	      return bl;
	   }
	
	 
	 
//	 public int deletePost(int idx) {
//		    int result=0;
//		    try {
//		       String query="delete from am2 where idx=?";
//		       psmt=con.prepareStatement(query);
//		       psmt.setInt(1, idx);
//		       result=psmt.executeUpdate();
//		    } catch (Exception e) {
//		       System.out.println("게시물 삭제 중 에러");
//		       e.printStackTrace();
//		    }
//		    return result;
//		 }
	 
//	 public int updatePost(AmandInfoDto dto) {
//			int result=0;
//			try {
//				String query = "update am2 "
//							+" set idx=?, name=?, type=?, day_t=?, time_s=?, time_e=? "
//							+" where idx=? and pass=?";
//				psmt=con.prepareStatement(query);
//				psmt.setInt(1, dto.getIdx());
//				psmt.setString(2, dto.getName());
//				psmt.setString(3, dto.getType());
//				psmt.setString(4, dto.getDay_t());
//				psmt.setString(5, dto.getTime_s());
//				psmt.setString(6, dto.getTime_e());
//				result=psmt.executeUpdate();
//			} catch (Exception e) {
//				System.out.println("게시물 수정 중 에러");
//				e.printStackTrace();
//			}
//				return result;
//			}
}
