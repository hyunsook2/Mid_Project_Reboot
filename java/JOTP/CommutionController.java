package JOTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Am.AmDAO2;
import Am.AmandInfoDto;
import utils.PagingUtil;

@WebServlet("/JOTP/CommutionController.do")
public class CommutionController  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String id = (String) req.getSession().getAttribute("loginId");
//	       int grade = Integer.parseInt(req.getParameter("grade"));
	       
	       //DAO 생성
	       AmDAO2 dao = new AmDAO2();
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
	       int totalCount = dao.countAll(map);
	       
	       ServletContext application = getServletContext();
	       int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
	       int pageBlock = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
	       
	       pageSize = 10;
	       
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
	       
	       int result = dao.ManagerGrade(id);
	       //DB에서 게시물 정보 읽기
	       if(result == 1) {
	          List<AmandInfoDto> dto = dao.ManagergetListPage(map);
	          dao.close();       
	          
	          String pageingStr = PagingUtil.pagingCenter(totalCount, pageSize, pageBlock, pageNum, "../JOTP/CommutionController.do");
	          
	          map.put("pagingStr",pageingStr);
	            map.put("totalCount", totalCount);
	            map.put("pageSize", pageSize);
	            map.put("pageNum", pageNum);
	          
	          //View에 최종 전달
	          req.setAttribute("id", id);
	          req.setAttribute("result", result);
	          req.setAttribute("dto", dto);
	          req.setAttribute("map", map);
	          req.getRequestDispatcher("/otp/OtpViewPage.jsp").forward(req, resp);
	       }else {
	          List<AmandInfoDto> dto = dao.getListPage(map,id);
	          dao.close();
	          
	          String pageingStr = PagingUtil.pagingCenter(totalCount, pageSize, pageBlock, pageNum, "../JOTP/CommutionController.do");
	          
	          map.put("pagingStr",pageingStr);
	            map.put("totalCount", totalCount);
	            map.put("pageSize", pageSize);
	            map.put("pageNum", pageNum);
	          
	          //View에 최종 전달
	          req.setAttribute("id", id);
	          req.setAttribute("result", result);
	          req.setAttribute("dto", dto);
	          req.setAttribute("map", map);
	          req.getRequestDispatcher("/otp/OtpViewPage.jsp").forward(req, resp);
	       }
	}
}
