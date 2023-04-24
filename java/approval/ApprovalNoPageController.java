package approval;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import profile.ProfileDAO;
import profile.ProfileDTO;
import utils.AlertFunc;
import utils.FileUtil;
import utils.PagingUtil;

@WebServlet("/approval/approvalNoPage.do")
public class ApprovalNoPageController extends HttpServlet {

    public ApprovalNoPageController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = (String) req.getSession().getAttribute("loginId");
    	
    	ProfileDAO dao2 = new ProfileDAO();
    	ProfileDTO dto = dao2.getManager(id);
		
		//DAO 생성
		ApprovalDAO dao = new ApprovalDAO();
		//변수저장
		Map<String, Object> map = new HashMap<>();
		//검색
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		
		if(searchStr != null) {
			map.put("searchType", searchType);
			map.put("searchStr", searchStr);
		}
		//전체 게시물 개수
		int totalCount = dao.countAllNo(map);
		
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
		
		//페이지 확인
		int pageNum=1;
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp!=null && !pageTemp.equals("")) {
			pageNum=Integer.parseInt(pageTemp);
		}
		
		//목록에서 보여줄 게시물 범위 계산
		int start=(pageNum-1)*pageSize+1;
		int end = pageNum*pageSize;
		map.put("start", start);
		map.put("end", end);
		//DB에서 게시물 정보 읽기
		List<ApprovalDTO> boardList = dao.getListNoPage(map, id);
		dao.close();
		

		String pageingStr = PagingUtil.pagingCenter(totalCount, pageSize, pageBlock, pageNum, "../approval/approvalNoPage.do");
		
		map.put("pagingStr", pageingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		
		
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("map", map);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/approval/ApprovalNoPage.jsp").forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//파일 업로드 처리
		
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
			AlertFunc.alertBack(resp, "파일이 업로드 되지 않았습니다.");
			return;
		}
		//DB 정보 저장
		String idx = mr.getParameter("idx");
		String preOfile = mr.getParameter("preOfile");
		String preNfile = mr.getParameter("preNfile");
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+idx);
		

		//폼 값을 DTO에 저장
		ApprovalDTO dto = new ApprovalDTO();
		
		dto.setId(mr.getParameter("fromId"));
		dto.setName(mr.getParameter("fromName"));
		
		String deptn = mr.getParameter("dept");
		int deptnInt = Integer.parseInt(deptn);
		dto.setDeptn(deptnInt);
		
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
			
		dto.setBoss(mr.getParameter("toId"));
		dto.setState(mr.getParameter("state"));
		
		dto.setIdx(idx);
		dto.setCompanion(mr.getParameter("companion"));
		
		
		String state = mr.getParameter("state");
		if(state.equals("대기")) {
			state="반려";
			dto.setState(state);
		}
		if(state.equals("반려")) {
			dto.setState(state);
		}
		
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
			
			//기존 파일 삭제
			FileUtil.deleteFile(req, "/approvalFile", preNfile);
			
		} else {
			dto.setOfile(preOfile);
			dto.setNfile(preNfile);
		}
		//DAO를 통해 DB에 내용 저장
		ApprovalDAO dao = new ApprovalDAO();
		int result = dao.noPostUpdate(dto);
		
		int Dresult = dao.approvalDelete(idx);
		dao.close();
		
		//성공여부
		if(result==1 && Dresult==1) { //성공
			AlertFunc.alertLocation(resp, "반려 했습니다.반려 페이지로 이동합니다.", "../approval/approvalNoPage.do");
		}else {
			AlertFunc.alertLocation(resp, "반려 되지 않았습니다.", "../approval/view.do?idx="+idx);		
		}
    
    }
    
		
} 
    

