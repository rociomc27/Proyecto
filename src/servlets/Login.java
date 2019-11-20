package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=(request.getPathInfo()!=null?request.getPathInfo():"");
	        HttpSession sesion = request.getSession();
	        if(action.equals("/out")){
	            sesion.invalidate();
	            response.sendRedirect("/index.jsp");
	        }else{
	           
	        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        //deber�amos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo c�digo
        if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y adem�s no hay sesi�n iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a p�gina con informaci�n de login exitoso
            response.sendRedirect("loginExito.jsp");
        }else{
            //l�gica para login inv�lido
        }
	}

}
