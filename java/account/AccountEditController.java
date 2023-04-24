package account;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import utils.AlertFunc;
import utils.FileUtil;

//수정된 값 디비에 넣는 곳 
@WebServlet("/account/accountedit.do")
public class AccountEditController extends HttpServlet{
	

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
		    AccountBoardDTO dto = new AccountBoardDTO();
		    dto.setDeptn(Integer.parseInt(request.getParameter("deptn")));
		    dto.setId(request.getParameter("id"));
		    dto.setName(request.getParameter("name"));
		    
		    String gradeStr = request.getParameter("grade");
		    int gradeNum;
		    if(gradeStr.equals("팀장")) {
		        gradeNum=0;
		    } else if(gradeStr.equals("사원")) {
		        gradeNum=1;
		    } else {
		        gradeNum=9;
		    }
		    
		    dto.setGrade(gradeNum);
		    
		    java.util.Date utilDate = dateFormat.parse(request.getParameter("in_d"));
		    java.sql.Date in_d = new java.sql.Date(utilDate.getTime());
		    dto.setIn_d(in_d);
		    
		    java.util.Date utilDate1 = dateFormat.parse(request.getParameter("out_d"));
		    java.sql.Date out_d = new java.sql.Date(utilDate1.getTime());
		    dto.setOut_d(out_d);
		    
		    java.util.Date utilDate2 = dateFormat.parse(request.getParameter("bday"));
		    java.sql.Date bday = new java.sql.Date(utilDate2.getTime());
		    dto.setBday(bday);
		    
		    dto.setOff_d(request.getParameter("off_d"));
		    dto.setPass(request.getParameter("pass"));
		    
		    dto.setPnum(request.getParameter("pnum"));
		    dto.setAd(request.getParameter("ad"));
		    
		    //DAO를 통해 DB에 내용 저장
		    AccountBoardDAO dao = new AccountBoardDAO();
		    int result = dao.setUpdate(dto);
		    dao.close();
		    //성공여부
		    if(result==1) {//성공
		        AlertFunc.alertLocation(response, "계정 수정에 성공했습니다.", "../account/manageacc.do");
		    } else {
		        AlertFunc.alertBack(response, "계정 수정이 실패하였습니다.");
		    }
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		    // 예외 처리 코드
		}
		
	
		
	}
}
