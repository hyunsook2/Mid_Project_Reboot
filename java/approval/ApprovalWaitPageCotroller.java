package approval;

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

@WebServlet("/approval/approvalWaitPage.do")
public class ApprovalWaitPageCotroller extends HttpServlet {

    public ApprovalWaitPageCotroller() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    			String id = (String) req.getSession().getAttribute("loginId");
    			
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
    			int totalCount = dao.countAllWait(map);
    			
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
    			List<ApprovalDTO> boardList = dao.getListWaitPage(map, id);
    			dao.close();
    			

    			String pageingStr = PagingUtil.pagingCenter(totalCount, pageSize, end, pageNum, "../approval/approvalWaitPage.do");
    			
    			System.out.println(totalCount);
    			System.out.println(pageSize);
    			System.out.println(pageBlock);
    			System.out.println(pageNum);
    			
    			map.put("pagingStr", pageingStr);
    			map.put("totalCount", totalCount);
    			map.put("pageSize", pageSize);
    			map.put("pageNum", pageNum);
    			
    			
    			req.setAttribute("boardList", boardList);
    			req.setAttribute("map", map);
    			req.getRequestDispatcher("/approval/ApprovalWaitPage.jsp").forward(req, resp);
    }
}
