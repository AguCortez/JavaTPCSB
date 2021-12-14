package servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import entites.*;
import util.sociosUtil;

@WebServlet("/verificaIngreso")
public class verificaIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public verificaIngreso() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int usuario =Integer.parseInt(request.getParameter("dniUsuario"));
		String contra= request.getParameter("passUsuario");
		sociosUtil su=new sociosUtil();
		Socio elsocio=su.getBydni(usuario);
		if(elsocio!=null && elsocio.getContrasenia().equals(contra))
			{
			 Usuario usu=new Usuario(usuario,contra);		 
			 HttpSession sesion = request.getSession();
			 sesion.setAttribute("usuario", usu);
			  RequestDispatcher rd1 = request.getRequestDispatcher("menu2.jsp");
				  rd1.forward(request, response);
			 
			}
		else
		{
			RequestDispatcher rd1 = request.getRequestDispatcher("error.jsp");
			rd1.forward(request, response);
			
		}
		
		
	}

}
