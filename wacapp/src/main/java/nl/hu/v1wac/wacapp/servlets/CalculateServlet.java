package nl.hu.v1wac.wacapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet(urlPatterns = "/CalculateServlet.do")
public class CalculateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String firstnumb = req.getParameter("firstnumb");
		String secondnumb = req.getParameter("secondnumb");
		int first = Integer.parseInt(firstnumb);
		int second = Integer.parseInt(secondnumb);
		//int solution = first * second;
		
		 out.println("<!DOCTYPE html>");
		 out.println("<html>");
		 out.println(" <title>Calculate Example</title>");
		 out.println(" <body>");
		 out.println(" <h2>Calculate multiply webapplication example</h2>");
		if (req.getParameter("r1") !=null){
			out.println("<h2> Outcome: </h2>" + (first+second) );
		}
		
		if (req.getParameter("r2") !=null){
			out.println("<h2> Outcome: </h2>" + (first-second) );
		}
		
		if (req.getParameter("r3") !=null){
			out.println("<h2> Outcome: </h2>" + (first*second) );
		}
		
		if (req.getParameter("r4") !=null){
			out.println("<h2> Outcome: </h2>" + (first/second) );
		}
		
		 out.println(" </body>");
		 out.println("</html>");		
	}
}
