package rebootServlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Am.AmDAO2;
import Am.AmDTO2;
import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/rebootServlet/myPage.do")
public class MypageController extends HttpServlet {

    public MypageController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = (String) req.getSession().getAttribute("loginId");
    	
		ProfileDTO dto = new ProfileDTO();
		ProfileDAO pDao = new ProfileDAO();
		dto = pDao.getMember(id);

		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("../Reboot/MyPage.jsp").forward(req, resp);
    }
}
