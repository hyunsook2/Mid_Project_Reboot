package org2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDataBase {

	public AbstractDataBase() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB 조직도 연결 성공");
		} catch (Exception e) {
			System.out.println("DB 조직도 연결 실패");
		} 
	}

	public Connection getConnection() throws SQLException
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="Reboot";
		String passwd="1234";
		Connection conn=DriverManager.getConnection(url,user,passwd);
		return conn;
	}//getConnection
	public void close(Connection conn, PreparedStatement psmt, ResultSet select)
	{
		if(select!=null)
		{
			try {
				select.close();
			} catch (SQLException e) {
			}
		}
		if(psmt!=null)
		{
			try {
				psmt.close();
			} catch (SQLException e) {
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();

			} catch (SQLException e) {

			}
		}
	}//close

}