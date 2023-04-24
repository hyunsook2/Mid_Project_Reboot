package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
			try {
				//oracle jdbc드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");// jdbc driver load
				//Connection
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Reboot","1234");// 연결
				System.out.println("연결완료");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
