package tree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class TreeDAO extends JDBConnPool {
	// 기본생성자
	public TreeDAO() {
		super();
	}

	public void resetTree() {
		try {
			// TB_DEPT 테이블의 모든 데이터 삭제
			String deleteData = "DELETE FROM TB_DEPT";
			stmt = con.createStatement();
			stmt.executeUpdate(deleteData);

			// 기본값 삽입
			String initData = "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_001',NULL,'REBOOT',1);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_002','DE_001','정보관리팀',2);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_003','DE_001','경영관리팀',2);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_004','DE_001','영업부',2);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_005','DE_002','팀장',3);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_006','DE_002','팀원',3);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_007','DE_003','팀장',3);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_008','DE_003','팀원',3);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_009','DE_004','팀장',3);"
					+ "INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,LV)VALUES('DE_010','DE_004','팀원',3);";
			stmt.executeUpdate(initData);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void insertTree() {
		try {
			String v_dept_cd = "DE_011";
			String v_dept_nm = "";

			String selectInfo = "SELECT DEPTN, NAME, GRADE FROM INFO";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectInfo);

			while (rs.next()) {
				int deptn = rs.getInt("DEPTN");
				String name = rs.getString("NAME");
				int grade = rs.getInt("GRADE");

				if (deptn == 1 && grade == 0) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_005', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				} else if (deptn == 1 && grade == 1) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_006', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				} else if (deptn == 2 && grade == 0) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_007', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				} else if (deptn == 2 && grade == 1) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_008', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				} else if (deptn == 3 && grade == 0) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_009', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				} else if (deptn == 3 && grade == 1) {
					v_dept_nm = name;
					String insertData = "INSERT INTO TB_DEPT(DEPT_CD, PAR_DEPT_CD, DEPT_NM,LV) " + "VALUES ('" + v_dept_cd
							+ "', 'DE_010', '" + v_dept_nm + "',4)";
					stmt.executeUpdate(insertData);
					v_dept_cd = "DE_" + String.format("%03d", Integer.parseInt(v_dept_cd.substring(3)) + 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public String getTree() {
		String html = "";
		try {
			if (con == null) {
				return "Connection is null";
			}
			String query = "SELECT LEVEL LV, DEPT_NM, LPAD(' ', 2*LEVEL-1) || SYS_CONNECT_BY_PATH(DEPT_NM, '/') PATH, DEPT_CD, PAR_DEPT_CD "
					+ "FROM TB_DEPT " + "START WITH PAR_DEPT_CD IS NULL " + "CONNECT BY PAR_DEPT_CD = PRIOR DEPT_CD "
					+ "ORDER SIBLINGS BY DEPT_CD";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int level = rs.getInt("LV");
				String deptName = rs.getString("DEPT_NM");
				String path = rs.getString("PATH");
				String deptCode = rs.getString("DEPT_CD");
				String parentDeptCode = rs.getString("PAR_DEPT_CD");

				html += String.format("%s [%s] %s (코드: %s, 상위코드: %s)%n", path, level, deptName, deptCode,
						parentDeptCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return html;
	}

	public String getTreeFormatted() {
		String html = "";
		try {
			String query = "SELECT LEVEL, DEPT_NM, LPAD(' ', 2*LEVEL-1) || SYS_CONNECT_BY_PATH(DEPT_NM, '/') PATH, DEPT_CD, PAR_DEPT_CD "
					+ "FROM TB_DEPT " + "START WITH PAR_DEPT_CD IS NULL " + "CONNECT BY PAR_DEPT_CD = PRIOR DEPT_CD "
					+ "ORDER SIBLINGS BY DEPT_CD";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int level = rs.getInt("LV");
				String deptName = rs.getString("DEPT_NM");
				String path = rs.getString("PATH");
				String deptCode = rs.getString("DEPT_CD");
				String parentDeptCode = rs.getString("PAR_DEPT_CD");

				// 변환된 값을 저장할 변수들
				String position = "";
				String name = "";

				// level에 따라 출력 내용을 변환
				switch (level) {
				case 1:
					position = "사장";
					name = "REBOOT";
					break;
				case 2:
					switch (deptName) {
					case "정보관리팀":
						position = "팀원";
						break;
					case "인사팀":
						position = "팀장";
						break;
					case "업무팀":
						position = "팀원";
						break;
					}
					break;
				case 3:
					if (deptName.equals("정보관리팀")) {
						position = "팀장";
					} else {
						position = "팀원";
					}
					break;
				case 4:
					position = "사원";
					name = deptName;
					break;
				}

				// 변환된 값을 출력
				html += String.format("%s[%s] %s %s (코드: %s, 상위코드: %s)%n", path, level, position, name, deptCode,
						parentDeptCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return html;
	}

	public String getTree2() {
		String html = "";
		try {
			if (con == null) {
				return "Connection is null";
			}
			String query = "SELECT LPAD(' ', (LEVEL - 1) * 2, ' ') || DEPT_NM AS DEPT_NM " + "FROM TB_DEPT "
					+ "START WITH PAR_DEPT_CD IS NULL " + "CONNECT BY PRIOR DEPT_CD = PAR_DEPT_CD ";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String deptName = rs.getString("DEPT_NM");
				html += deptName + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return html;
	}

	public String getTree3() {
	    String html = "";
	    try {
	        if (con == null) {
	            return "Connection is null";
	        }
	        String query = "SELECT LPAD(' ', (LEVEL - 1) * 2, ' ') || DEPT_NM AS DEPT_NM, LEVEL AS DEPT_LEVEL "
	                + "FROM TB_DEPT "
	                + "START WITH PAR_DEPT_CD IS NULL "
	                + "CONNECT BY PRIOR DEPT_CD = PAR_DEPT_CD "
	                + "ORDER SIBLINGS BY DEPT_CD";
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        int currentLevel = 0;
	        while (rs.next()) {
	            String deptName = rs.getString("DEPT_NM");
	            int deptLevel = rs.getInt("DEPT_LEVEL");
	            if (deptLevel > currentLevel) {
	                html += "\n<ul>";
	            } else if (deptLevel < currentLevel) {
	                html += "</ul></li>";
	            } else {
	                html += "</li>";
	            }
	            html += "\n<li>" + deptName;
	            currentLevel = deptLevel;
	        }
	        while (currentLevel > 0) {
	            html += "</ul></li>";
	            currentLevel--;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return html;
	}
	
	public List<TreeDTO> getTreeData() {
	    List<TreeDTO> treeData = new ArrayList<>();
	    try {
	        if (con == null) {
	            return null;
	        }
	        String query = "SELECT DEPT_CD, PAR_DEPT_CD, DEPT_NM, LEVEL, ID " +
	                "FROM TB_DEPT " +
	                "START WITH PAR_DEPT_CD IS NULL " +
	                "CONNECT BY PRIOR DEPT_CD = PAR_DEPT_CD " +
	                "ORDER SIBLINGS BY DEPT_CD";
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String orgCode = rs.getString("DEPT_CD");
	            String orgUpperCode = rs.getString("PAR_DEPT_CD");
	            String orgName = rs.getString("DEPT_NM");
	            int orgLevel = rs.getInt("LEVEL");
	            String id = rs.getString("ID");

	            TreeDTO treeNode = new TreeDTO(orgLevel, orgName, null, orgCode, orgUpperCode, id);
	            treeData.add(treeNode);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return treeData;
	}
	
	
	
	
}