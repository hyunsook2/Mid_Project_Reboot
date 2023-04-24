/*
 * package profile; import java.io.IOException; import java.sql.Date; import
 * java.text.ParseException; import java.text.SimpleDateFormat;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/rebootServlet/edit.do") public class EditController extends
 * HttpServlet { public EditController() { super(); }
 * 
 * protected void doget(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException, ParseException { String id =
 * (String) request.getSession().getAttribute("loginId"); String pass =
 * request.getParameter("password"); String bdayStr =
 * request.getParameter("bday"); // Get the birthday string from the request
 * parameter SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //
 * Create a formatter that matches the format of the date string Date bday =
 * (Date) formatter.parse(bdayStr); // Parse the string into a Date object
 * String pnum = request.getParameter("pnum"); int ad =
 * Integer.parseInt(request.getParameter("ad")); ProfileDAO dao = new
 * ProfileDAO(); ProfileDTO pdto = dao.editMember(id, pass, bday, ad, pnum); //
 * 왜 기능이 안되노? request.setAttribute("pdto", pdto); RequestDispatcher rd =
 * request.getRequestDispatcher("../Reboot/MyPage.jsp"); rd.forward(request,
 * response);
 * 
 * // // // db 연결 // String url = "jdbc:oracle:thin:@localhost:1521:xe"; //
 * String dbId = "reboot"; // String dbPw = "1234"; // // try { //
 * Class.forName("oracle.jdbc.driver.OracleDriver"); // conn =
 * DriverManager.getConnection(url, dbId, dbPw); //
 * System.out.println("Connected to the database"); // // // db 업데이트 // String
 * sql = "UPDATE INFO SET pass = ?, bday = ?, phone = ?, ad = ? WHERE id = ?";
 * // // PreparedStatement pstmt = conn.prepareStatement(sql); //
 * pstmt.setString(1, pass); // pstmt.setString(2, bday); // pstmt.setString(3,
 * pnum); // pstmt.setString(4, ad); // pstmt.setString(5, "id"); // int result
 * = pstmt.executeUpdate(); // pstmt.close(); // conn.close(); //
 * System.out.println(result + " rows updated"); // // } catch
 * (ClassNotFoundException e) { // e.printStackTrace(); // } catch (SQLException
 * e) { // e.printStackTrace(); // } // //response.sendRedirect("Mypage.jsp");
 * // MyPage.jsp로 redirect // RequestDispatcher rd =
 * request.getRequestDispatcher("../rebootServlet/myPage.do?id=${dto.id}"); } }
 */