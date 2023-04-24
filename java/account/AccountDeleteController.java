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
import utils.AlertFunc;

//수정된 값 디비에 넣는 곳 
@WebServlet("/account/accountdelete.do")

public class AccountDeleteController extends HttpServlet{
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		String id = request.getParameter("id");
//		
//		AccountBoardDAO dao = new AccountBoardDAO();
//		AccountBoardDTO dto = dao.getView(id);
//		int result = dao.setDelete(id); //게시물 삭제
//		dao.close();
//
//		AlertFunc.alertLocation(response, "계정 삭제에 성공했습니다.", "../account/manageacc.do");	
//	
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		AccountBoardDAO dao = new AccountBoardDAO();
		AccountBoardDTO dto = dao.getView(id);
		int result = dao.setDelete(id); //게시물 삭제
		dao.close();

		AlertFunc.alertLocation(response, "계정 삭제에 성공했습니다.", "../account/manageacc.do");	
	}
	
}
