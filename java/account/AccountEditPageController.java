package account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/account/editpage.do")
public class AccountEditPageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시물 읽어오기
				AccountBoardDAO dao = new AccountBoardDAO();
				String id = req.getParameter("id");
				//String id = (String) req.getSession().getAttribute("loginId");
				AccountBoardDTO dto = dao.getView(id); //내용 읽어오기
				dao.close();
				
				//게시물 뷰로 전달
				req.setAttribute("list", dto);
				req.getRequestDispatcher("../account/ManagerEditPage.jsp").forward(req, resp);
	}
	
}
