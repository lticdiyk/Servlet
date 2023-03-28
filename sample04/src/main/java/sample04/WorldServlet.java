package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Human;

public class WorldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	//	req.setCharacterEncoding("utf-8");
		
		/*
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		String address = req.getParameter("address");
		*/
		
		// 짐을 풀다
		Human human = (Human)req.getAttribute("human");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>World입니다</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h1>World</h1>");
		
		/*
		pw.println("<p>이름:" + name + "</p>");
		pw.println("<p>나이:" + age + "</p>");
		pw.println("<p>주소:" + address + "</p>");
		*/				
		
		pw.println("<p>이름:" + human.getName() + "</p>");
		pw.println("<p>나이:" + human.getAge() + "</p>");
		pw.println("<p>주소:" + human.getAddress() + "</p>");
		
		pw.println("</body>");
		
		pw.println("</html>");
	}
	
}
