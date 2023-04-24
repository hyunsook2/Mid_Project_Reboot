package rebootServlet;

import java.io.IOException;

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

@WebServlet("/rebootServlet/accountList.do")
public class AccountListController extends HttpServlet {
	
	public AccountListController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("loginId");
    	
		ProfileDAO dao = new ProfileDAO();
		ProfileDTO dto = new ProfileDTO();
		dto = dao.getMember(id);
		       
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("../account/manageacc.do").forward(req, resp);
	}
}
