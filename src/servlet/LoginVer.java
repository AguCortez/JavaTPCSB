package servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginVer
 */
@WebServlet("/LoginVer")
public class LoginVer extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	
		PrintWriter out=response.getWriter();
		int dni=Integer.parseInt(request.getParameter("dniUsu"));
		String pass=request.getParameter("passUsu");
		
		if (dni==123 && pass=="123") {
			out.println("succes");
		}
		else {out.println("F");}
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}


}
