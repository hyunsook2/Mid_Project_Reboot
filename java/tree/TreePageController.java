package tree;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/tree/tree.do")
public class TreePageController extends HttpServlet {
	public TreePageController() {
	        super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("loginId");
		
		ProfileDAO dao = new ProfileDAO();
		ProfileDTO dto = new ProfileDTO();
		dto = dao.getMember(id);
		       
		req.setAttribute("dto", dto);
			
		req.getRequestDispatcher("../tree/TreePage.jsp").forward(req, resp);
	}

}
