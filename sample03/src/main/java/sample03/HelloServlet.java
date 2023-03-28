package sample03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
				
		String hobby[] = req.getParameterValues("hobby");
		String url[] = req.getParameterValues("url");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목입니다</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<p>취미</p>");
		if(hobby != null) {
			for (int i = 0; i < hobby.length; i++) {
				pw.println("<p>" + hobby[i] + "</p>");
			}
		}
		
		pw.println("<p>사이트</p>");
		if(url != null) {
			for (int i = 0; i < url.length; i++) {
				pw.println("<p>" + url[i] + "</p>");
			}
		}
		
		pw.println("</body>");
		
		pw.println("</html>");
	}

	
}
