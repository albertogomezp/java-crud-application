package com.agomez.competidor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agomez.competidor.dao.CompetidorDAO;
import com.agomez.competidor.model.*;

@WebServlet("/adminCompetidor")
public class AdminCompetidor extends HttpServlet {

	private static CompetidorDAO competidorDAO;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {

			case "index":
				System.out.println("entro index");
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				System.out.println("entro nuevo");
				break;
			case "showedit":
				showedit(request, response);
				break;
			case "hacerlogin":
				HacerLogin(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "editar":
				actualizar(request, response);
				break;
			case "findById":
				findById(request.getParameter("id"));
				break;
			case "eliminar":
				borrar(request, response);
				break;
			case "mostrar":
				listar(request, response);
				break;

			default:
				break;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}




	private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
		dispatcher.forward(request, response);
	}

	private void showedit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Competidor competidor = findById(request.getParameter("id"));
		request.setAttribute("competidor", competidor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Competidor c_persist = new Competidor(0,
				request.getParameter("Nombre"), request.getParameter("Apellidos"), request.getParameter("Pais"),
				request.getParameter("Categoria"), Integer.parseInt(request.getParameter("Ranking")));
		System.out.println("entro persist");
		persist(c_persist);
		RequestDispatcher dispatcher3 = request.getRequestDispatcher("index2.jsp");
		dispatcher3.forward(request, response);
	}

	private void borrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		delete(request.getParameter("id"));
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("index2.jsp");
		dispatcher2.forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Competidor> listarCompetidores = findAll();
		request.setAttribute("lista", listarCompetidores);
		dispatcher1.forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Competidor c_update = new Competidor(Integer.parseInt(request.getParameter("id")),
				request.getParameter("Nombre"), request.getParameter("Apellidos"), request.getParameter("Pais"),
				request.getParameter("Categoria"), Integer.parseInt(request.getParameter("Ranking")));
		update(c_update);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
		dispatcher.forward(request, response);
	}
	
	private void HacerLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("---");
		System.out.println(request.getParameter("user")+" "+request.getParameter("password"));
		Login TryLogin = new Login(request.getParameter("user"),request.getParameter("password"));
		if(TryLogin.getUser()!="" && TryLogin.getPassword()!="") {
			System.out.println("---");
			Login login = preLoguear(request.getParameter("user"));
			System.out.println("---");

			if(TryLogin.getPassword().equals(login.getPassword())) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
				dispatcher.forward(request, response);

			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			}
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}
	}

	// --> hibernate
	public AdminCompetidor() {
		competidorDAO = new CompetidorDAO();
	}

	public void persist(Competidor entity) {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.persist(entity);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Competidor entity) {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.update(entity);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	public Competidor findById(String id) {
		competidorDAO.openCurrentSession();
		Competidor book = competidorDAO.findById(id);
		competidorDAO.closeCurrentSession();
		return book;
	}
	public Login preLoguear(String user) {
		System.out.println("---*");
		competidorDAO.openCurrentSession();
		System.out.println("---*");
		Login login = competidorDAO.Checklogin(user);
		System.out.println("---*");
		competidorDAO.closeCurrentSession();
		System.out.println("---*");

		return login;
	}
	public void delete(String id) {
		competidorDAO.openCurrentSessionwithTransaction();
		Competidor book = competidorDAO.findById(id);
		competidorDAO.delete(book);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	public List<Competidor> findAll() {
		competidorDAO.openCurrentSession();
		List<Competidor> competidores = competidorDAO.findAll();
		competidorDAO.closeCurrentSession();
		return competidores;
	}

	public void deleteAll() {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.deleteAll();
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	public CompetidorDAO competidorDAO() {
		return competidorDAO;
	}
}
