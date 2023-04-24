package account;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.PagingUtil;


@WebServlet("/account/manageacc.do")
public class AccountBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DAO 생성
		AccountBoardDAO dao = new AccountBoardDAO();
		//변수 저장
		Map<String,Object> map = new HashMap<>();
		//검색
		String searchDept=req.getParameter("searchDept");
		String searchId=req.getParameter("searchId");
		String searchName=req.getParameter("searchName");
		
		int searchDeptNum;
		if(searchDept != null && !searchDept.equals("")) {
			if(searchDept.contains("시스템")) {
				searchDeptNum=0;
			}else if(searchDept.contains("인사")) {
				searchDeptNum=1;
			}else if(searchDept.contains("업무")) {
				searchDeptNum=2;
			}else {
				searchDeptNum=9;
			}
			map.put("searchDept", searchDeptNum);
		}
		if(searchId != null && !searchId.equals("")) {
			map.put("searchId", searchId);
		}
		if(searchName != null && !searchName.equals("")) {
			map.put("searchName", searchName);
		}
		//전체 게시물 갯수 파악
		int totalCount = dao.countAll(map);
		
		//web.xml에서 불러오는 것
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
			
				
		//페이지 확인 
		int pageNum = 1;
		String pageTemp=req.getParameter("pageNum");
		if(pageTemp!=null && !pageTemp.equals("")) {
			pageNum=Integer.parseInt(pageTemp);
		}
			
		//목록에서 보여줄 게시물 범위 계산
		int start = (pageNum-1)*pageSize+1;
		int end = pageNum*pageSize;
		map.put("start", start);
		map.put("end", end);
				
		//DB에서 게시물 정보 읽기
		List<AccountBoardDTO> boardList = dao.getListPage(map);
		dao.close();
				
		//뷰에 값을 전달해 줄 것을 정리
		String pagingStr=PagingUtil.pagingCenter(totalCount,pageSize,pageBlock,pageNum,"../account/manageacc.do");
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
				
		//뷰에 최종 전달
		req.setAttribute("boardList", boardList);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/account/AccountListPage.jsp").forward(req, resp);
	}

}
