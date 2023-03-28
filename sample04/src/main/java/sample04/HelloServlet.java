package sample04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Human;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	public void doProc(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("HelloServlet doProc()");
		
		//req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		String address = req.getParameter("address");
		
		System.out.println("name:" + name);
		
		/*
		
		// response sendRedirect
		// 한글의 경우는 인코딩을 처리해 주어야 한다. 
		String ename = URLEncoder.encode(name);
		String eaddress = URLEncoder.encode(address);
		
	//	resp.sendRedirect("world");	// 맵핑된 world(WorldServlet)로 이동		
		resp.sendRedirect("world?name=" + ename + "&age=" + age + "&address=" + eaddress);
		*/
		
		
		
		// RequestDispatcher forward(전진)
		Human h = new Human(name, age, address);
		
		// 짐싸!
		req.setAttribute("human", h);
		
		// 이동
	//	resp.sendRedirect("world");   // 이동은 되는데 데이터는 전송이 안됨
		req.getRequestDispatcher("world").forward(req, resp);
	}	
}







