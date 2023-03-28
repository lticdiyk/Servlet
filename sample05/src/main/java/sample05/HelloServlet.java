package sample05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");
		
		/*
			getSession(false)
			session 이 존재하면 현재 HttpSession을 반환한다
			session 이 생성되어 있는지 판단.
			session 객체가 없으면 null을 반환한다
			
			getSession(true)
			session 이 존재하면 현재 HttpSession을 반환한다
			session 객체가 없으면 새로 session을 생성한다
		*/
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Hello입니다</title>");
		pw.println("</head>");
		
		pw.println("<body>");		
		pw.println("<h1>Hello</h1>");
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			session = req.getSession(true);			// 세션 생성
		//	session.setMaxInactiveInterval(30);		//  365 * 24 * 60 * 60
			
			session.setAttribute("visited", "1");	// 세션 저장 : visited(key):1(value)
			pw.println("<p>첫번째 방문입니다</p>");
		}
		else {
			String visited = (String)session.getAttribute("visited");
			
			if(visited != null) {
				int count = Integer.parseInt(visited);
				
				count++;
				
				pw.println("<p>" + count + "번째 방문입니다</p>");
				session.setAttribute("visited", count + "");
			}
		}		
		
		// session object를 삭제
	//	session.removeAttribute("visited");
		
		// session 삭제
	//	session.invalidate();
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
