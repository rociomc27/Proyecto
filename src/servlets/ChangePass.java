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

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LogicBD logicBD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();

    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
        ServletContext servletContext = this.getServletContext();
        logicBD = (LogicBD) servletContext.getAttribute("logicBD");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession sesion = request.getSession();
		
		String username = (String) sesion.getAttribute("user");
		String password = request.getParameter("contrasenaA");
		String passwordN = request.getParameter("contrasenaN");
		String passwordR = request.getParameter("contrasenaR");
		
		if (passwordR.equals(passwordN)) {
			Boolean comprobar = logicBD.cambioContrasena(username, password, passwordN);
			if (comprobar == true) {
				rd = request.getRequestDispatcher("/files.jsp");
			} else {
				rd = request.getRequestDispatcher("/newpassword.jsp");
			}
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/newpassword.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
