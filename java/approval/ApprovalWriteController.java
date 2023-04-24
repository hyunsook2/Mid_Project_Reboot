package approval;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import Alert.alertFunc;
import utils.AlertFunc;
import utils.FileUtil;


@WebServlet("/approval/ApprovalWrite.do")
public class ApprovalWriteController extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//>업로드 디렉토리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/approvalFile");
		System.out.println(saveDirectory);
		//>파일 업로드를 위한 기본정보
		ServletContext application =  getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		//>파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr==null) {
			//파일 업로드 실패하면
			alertFunc.alertLocation(resp, "첨부 파일이 업로드 되지 않았습니다.", "../approval/ApprovalWrite.do");
			return;
		}
		

		//폼 값을 DTO에 저장
		ApprovalDTO dto = new ApprovalDTO();
		
		System.out.println(mr.getParameter("fromId"));
		System.out.println(mr.getParameter("fromName"));
		System.out.println(mr.getParameter("dept"));
		System.out.println(mr.getParameter("title"));
		System.out.println(mr.getParameter("content"));
		System.out.println(mr.getParameter("toId"));
		System.out.println(mr.getFilesystemName("ofile"));
		
		//원본 파일명과 수정된 파일명
		String filename = mr.getFilesystemName("ofile");
		if(filename!=null) {
			//새 파일 명 생성
			String nfname = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = filename.substring(filename.lastIndexOf("."));
			String newFileName = nfname+ext;
			//파일명 변경
			File oldFile = new File(saveDirectory+File.separator+filename);
			File newFile = new File(saveDirectory+File.separator+newFileName);
			oldFile.renameTo(newFile);
			dto.setOfile(filename);	//원래 파일 이름
			dto.setNfile(newFileName);	//서버에 저장된 파일 이름
		}
		
		dto.setId(mr.getParameter("fromId"));
		dto.setName(mr.getParameter("fromName"));
		
		String deptn = mr.getParameter("dept");
		int deptnInt = Integer.parseInt(deptn);
		dto.setDeptn(deptnInt);
		
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
			
		dto.setBoss(mr.getParameter("toId"));
		
		//DAO를 통해 DB에 내용 저장
		ApprovalDAO dao = new ApprovalDAO();
		
		int result = dao.insertWrite(dto);		
		dao.close();
		
		
		//성공여부
		if(result==1) { //성공
			AlertFunc.alertLocation(resp, "기안서가 작성되었습니다.", "../approval/approvalWaitPage.do");
			//resp.sendRedirect("../approval/approvalWaitPage.do");
		}else {
			AlertFunc.alertBack(resp, "기안작성이 실패했습니다.");
		}
		
	}
}
