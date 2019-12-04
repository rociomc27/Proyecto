package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import database.LogicBD;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LogicBD logicBD;
    
    public Login() {
        super();
        logicBD = new LogicBD();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession sesion = request.getSession(true);
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		Boolean comprobar = logicBD.comprobarUserPass(username, password);
		
		if(comprobar == false) {
			rd = request.getRequestDispatcher("/index.jsp");
		} else {
			rd = request.getRequestDispatcher("/files.jsp");
			sesion.setAttribute("user", username);
		}
		
		rd.forward(request, response);
		
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = this.getServletContext();
		logicBD = new LogicBD();
		servletContext.setAttribute("logicBD", logicBD);
		
	}
}
