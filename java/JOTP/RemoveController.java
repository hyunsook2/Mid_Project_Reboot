package JOTP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alert.alertFunc;
import Am.AmDAO2;
import Am.AmDTO2;

@WebServlet("/otp/remove")
public class RemoveController extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 String id = (String) req.getSession().getAttribute("loginId");
//		 int idx = Integer.parseInt(req.getParameter("idx"));
//		    //DAO 생성
//		 AmDAO2 dao = new AmDAO2();
//		 AmDTO2 dto = dao.getAmMember2(idx);
//		 dao.deletePost(idx);
//		 dao.close();
//		 alertFunc.alertLocation(resp, "삭제되었습니다.", "${pageContext.request.contextPath}/JOTP/CommutionController.do");
//	}
}
