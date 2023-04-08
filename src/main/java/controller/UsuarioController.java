package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioDao usuarioDao;
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Integer idTxt = Integer.parseInt(request.getParameter("id"));
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.find(idTxt);
		request.setAttribute("usuario", u);
		request.getRequestDispatcher("/usuarioedit.jsp").forward(request, response);*/
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarUsuario(request, response);
			break;
		case "/delete":
			eliminarUsuario(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarUsuario(request, response);
			break;
		default:
			listUsuario(request, response);
			break;
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.find(id);
		u.setNombre(nombre);
		u.setEmail(email);
		u.setPais(pais);
		uDao.update(u);
		request.getRequestDispatcher("/usuariolist.jsp").forward(request, response);*/
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioedit.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Usuario u = new Usuario();
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		u.setNombre(nombre);
		u.setEmail(email);
		u.setPais(pais);
		UsuarioDao uDao = new UsuarioDao();
		uDao.insert(u);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Integer idTxt = Integer.parseInt(request.getParameter("id"));
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.find(idTxt);
		request.setAttribute("usuario", u);
		request.getRequestDispatcher("/usuarioedit.jsp").forward(request, response);
	}
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.find(id);
		u.setNombre(nombre);
		u.setEmail(email);
		u.setPais(pais);
		uDao.update(u);
		request.getRequestDispatcher("/list").forward(request, response);
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuarioActual = uDao.find(id);
		uDao.delete(usuarioActual);
		response.sendRedirect("list");
	}
	
	private void listUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
		dispatcher.forward(request, response);
	
	
		
			
		}
}
