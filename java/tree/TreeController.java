package tree;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/api/getTreeData")
public class TreeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        TreeDAO dao = new TreeDAO();
	        // DB 초기화
	        //dao.resetTree();
	        // DB 채우
	        //dao.insertTree();
	        
	    	// 데이터 가져오기
	        List<TreeDTO> treeData = dao.getTreeData();

	        // 데이터를 JSON 형태로 변환
	        Gson gson = new Gson();
	        String json = gson.toJson(treeData);

	        // 클라이언트에게 JSON 응답 보내기
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        resp.getWriter().write(json);
	    } catch (Exception e) {
	        // 클라이언트에게 오류 응답 보내기
	        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
	    }
	}
}
