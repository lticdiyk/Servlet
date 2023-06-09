package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override			//          request.getParameter("id") -> JSP
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
			servlet -> java(html)   --> Controller
			JSP ->	html(java)
		*/
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목입니다</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h1>Welcome to HelloServlet</h1>");
		pw.println("<p>hello Servlet</p>");
		
		pw.println("<a href='index.html'>index.html</a>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
