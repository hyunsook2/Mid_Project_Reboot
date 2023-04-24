package approval;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profile.ProfileDAO;
import profile.ProfileDTO;


@WebServlet("/approval/noView.do")
public class ApprovalNoViewPageController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("loginId");
		//게시물 읽어오기
		String idx = req.getParameter("idx");
		
		ApprovalDAO dao = new ApprovalDAO();
		ApprovalDTO dto = dao.getNoView(idx);	//내용 읽어오기
		dao.close();
		
//		//줄바꿈 처리
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		
		ProfileDAO dao2 = new ProfileDAO();
		
		ProfileDTO dto2 = dao2.getManager(id);
		ProfileDTO dto3 = dao2.getMember(id);
	
		
		//게시물 뷰로 전달
		req.setAttribute("dto", dto);
		req.setAttribute("dto2", dto2);
		req.setAttribute("dto3", dto3);
		
		req.getRequestDispatcher("/approval/ApprovalViewPage.jsp").forward(req, resp);
	}
}
