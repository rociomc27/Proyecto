package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import entity.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//Todo esto es lo que he intentado hacer el inicio de sesión con la base de datos 
		//(como hizo Amelia en el ejercicio webLoginBD),
		//pero no me sale, no hace nada :(
		
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("Proyecto");
		EntityManager em = factory.createEntityManager();

		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("password");
		
		User user = em.find(User.class, usuario);
		User pass = em.find(User.class, contrasena);
		
		RequestDispatcher rd;
		HttpSession sesion = request.getSession(true);

		
		if (usuario == null && contrasena == null && !sesion.isNew()) {
			usuario = (String) sesion.getAttribute("user");
			contrasena = (String) sesion.getAttribute("password");
		}
		
		if (usuario == null && contrasena == null && sesion.isNew()) {
			rd = request.getRequestDispatcher("/index.jsp");
		}
		
		else if (usuario.equals(user) && contrasena.equals(pass)) {
			rd = request.getRequestDispatcher("/files.jsp");
			sesion.setAttribute("user", usuario);
			sesion.setAttribute("password", contrasena);
		}
		
		else {
			rd = request.getRequestDispatcher("/index.jsp");
			sesion.invalidate();
		}
		rd.forward(request, response);
		*/
		
		//ESTO ES LO QUE HABIA ANTERIORMENTE EN EL MÉTODO DOGET (ANTES DE QUE YO EMPEZARA A TOQUETEAR),
		//Y ESTO FUNCIONA
		String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
		HttpSession sesion = request.getSession();
		if (action.equals("/out")) {
			sesion.invalidate();
			response.sendRedirect("/index.jsp");
		} else {
			request.getRequestDispatcher("/files.jsp").forward(request, response);
		}
		
		/*
		 *ESTO ES LO QUE HABÍA ANTERIORMETE EN EL METODO DOPOST (ANTES DE QUE YO EMPEZARA A TOQUETEAR),
		NO FUNCIONA
		HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        //deberíamos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo código
        if(usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a página con información de login exitoso
            response.sendRedirect("loginExito.jsp");
        }else{
            //lógica para login inválido
        }*/
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = this.getServletContext();
		LogicBD logicBD = new LogicBD();
		servletContext.setAttribute("logicBD", logicBD);
		
	}
}
