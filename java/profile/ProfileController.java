package profile;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/rebootServlet/mypage.do")*/
public class ProfileController extends HttpServlet {
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = (String) req.getSession().getAttribute("loginId");
    	
        ProfileDAO dao = new ProfileDAO();
        ProfileDTO pdto = dao.getMember(id);
        req.setAttribute("pdto", pdto);
        RequestDispatcher rd = req.getRequestDispatcher("../Reboot/MyPage.jsp");
        rd.forward(req, resp);
    }
}
   