package account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import utils.AlertFunc;

@WebServlet("/account/signUP.do")
public class SignUpController extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String saveDirectory = req.getServletContext().getRealPath("/Storage");	//저장할 디렉터리
	System.out.println(saveDirectory);
	
	MultipartRequest mr = new MultipartRequest(req,saveDirectory);
	
	ReadAcountFunc a = new ReadAcountFunc();
	List<AccountDTO> accountList = a.readData();
	
	for (AccountDTO account : accountList) {
		System.out.println("ID: " + account.getId());
		System.out.println("Password: " + account.getDeptn());
		System.out.println("Name: " + account.getName());
		System.out.println("Password: " + account.getPass());
		System.out.println("grade: " + account.getGrade());
		System.out.println("pnum: " + account.getPnum());
		System.out.println("ad: " + account.getAd());
		System.out.println("===============================");
		
	}
	
	    AccountDAO dao = new AccountDAO();
	    dao.insertData(accountList); 
	    dao.close();

	    AlertFunc.alertBack(resp, "등록되었습니다..");
	}
	
}


