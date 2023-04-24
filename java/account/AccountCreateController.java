package account;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import utils.AlertFunc;
import utils.FileUtil;

@WebServlet("/account/pleaseinsert.do")
public class AccountCreateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/account/SignUpPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String saveDirectory=req.getServletContext().getRealPath("/Storage");
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		//DB 정보 저장
		//폼값을 DTO 저장
		AccountBoardDTO dto = new AccountBoardDTO();
		
//		String dept = mr.getParameter("deptn");
//		System.out.println(dept+"==");
//		int deptn;
//		
//		if (dept.equals("인사팀")) {
//			  deptn = 1;
//			} else if (dept.equals("시스템팀")) {
//			  deptn = 0;
//			} else {
//			  deptn = 2;
//			}
		dto.setDeptn(Integer.parseInt(mr.getParameter("deptn")));
		dto.setId(mr.getParameter("id"));
		dto.setName(mr.getParameter("name"));
		
		String grade = mr.getParameter("grade");
		int gradeN;
		
		if(grade.equals("팀장")) {
			gradeN=0;
		}else if(grade.equals("사원")) {
			gradeN=1;
		}else {
			gradeN=9;
		}
		
		dto.setGrade(gradeN);

//		Date day = new Date();
//		day = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").parse(mr.getParameter("In_d")));
		
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date tempDate = null;
		try {
			tempDate = beforeFormat.parse(mr.getParameter("in_d"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String transDate = afterFormat.format(tempDate);
		
		dto.setIn_d(tempDate);
		dto.setOff_d(mr.getParameter("off_d"));
		
		//DAO를 통해 DB에 내용 저장
		AccountBoardDAO dao = new AccountBoardDAO();
		
		int result = dao.insertData(dto);
		dao.close();
		//성공여부
		if(result==1) {//성공
			//resp.sendRedirect("../account/pleaseinsert.do");
			AlertFunc.alertLocation(resp, "계정 생성에 성공했습니다.", "../account/pleaseinsert.do");
		}else {
			//resp.sendRedirect("../account/pleaseinsert.do");
			AlertFunc.alertBack(resp, "계정 생성이 실패하였습니다.");
		}
		
	}

}
