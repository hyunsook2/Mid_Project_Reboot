package tree;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/tree/popup.do")
public class PopUpPageController extends HttpServlet {

    public PopUpPageController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = (String) req.getParameter("id");
    	//String id = (String) req.getSession().getAttribute("loginId");
    	
		ProfileDTO dto = new ProfileDTO();
		ProfileDAO pDao = new ProfileDAO();
		dto = pDao.getMember(id);

		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("../tree/PopupPage.jsp").forward(req, resp);
    }
}