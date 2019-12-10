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
import explorer.InnerExplorer;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LogicBD logicBD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession sesion = request.getSession(true);
		
		String username = request.getParameter("user_name");
		String password = request.getParameter("contrasena");
		String email = request.getParameter("email_control");

		logicBD.registUser(username, password, email);
		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = this.getServletContext();
		logicBD = new LogicBD();
		servletContext.setAttribute("logicBD", logicBD);
		
	}

}
