package rebootServlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profile.ProfileDAO;
import profile.ProfileDTO;

@WebServlet("/rebootServlet/editPage.do")
public class EditPageController extends HttpServlet {
	public EditPageController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("loginId");

		ProfileDTO dto = new ProfileDTO();
		ProfileDAO pDao = new ProfileDAO();

		dto = pDao.getMember(id);
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/Reboot/EditPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getSession().getAttribute("loginId");
		
		String pass = request.getParameter("password");
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		String ad = request.getParameter("ad");
		
		try {
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = dateFormat.parse(request.getParameter("bday"));
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        System.out.println(sqlDate);
	        ProfileDAO dao = new ProfileDAO();
	        ProfileDTO pdto = dao.editMember(id, pass, pnum, ad, sqlDate);
	        request.setAttribute("pdto", pdto);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        // 예외 처리 코드
	    }

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("../Reboot/MyPage.jsp");
		 * rd.forward(request, response);
		 */
		response.sendRedirect("../rebootServlet/myPage.do");
	}
}