package approval;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.FileUtil;

@WebServlet("/approval/download.do")
public class DownloadController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//매개변수 받기
		String ofile = req.getParameter("ofile"); //원본 파일명
		String nfile = req.getParameter("nfile");	//저장된 파일명
		String idx = req.getParameter("idx");	//게시물 일련번호
		
		//파일 다운로드
		FileUtil.downloadFile(req,resp,"/approvalFile",nfile,ofile);
		
	}
	
}
