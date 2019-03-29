package com.agomez.competidor.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agomez.competidor.dao.CompetidorDAO;
import com.agomez.competidor.model.*;
import com.agomez.competidor.security.*;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/adminCompetidor")
public class AdminCompetidor extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CompetidorDAO competidorDAO;
	private static SecureLogin currentUser = new SecureLogin();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entra post");
		doGet(request, response);
//		String name = request.getParameter("action");
//		  response.getWriter().print("Hello "+ name + "!!");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		System.out.println("entra get");
		String action = request.getParameter("action");
		System.out.println("test "+ action);
		if(action!=null) {
			System.out.println(action);
			try {
				if(action.equals("securelogin")) {
					SecureLogin(request, response);
				}
				else if(currentUser.getUser()!="" && currentUser.getUser()!="null" && currentUser.getUser()!=null) {
					switch (action) {
					case "test":
						test(request, response);
						break;
					case "index":
						index(request, response);
						break;
					case "nuevo":
						nuevo(request, response);
						break;
					case "showedit":
						showedit(request, response);
						break;
					case "logout":
						logout(request, response);
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
					case "getcurrentUser":
						getcurrentUser(request, response);
						break;
					default:
						break;

					}
				}
				if(action.equals("signupmenu")) {
					signupmenu(request, response);
				}
				if(action.equals("logout")) {
					logout(request, response);
				}
				if(action.equals("signup")) {
					signup(request, response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}

		}
		else {
			System.out.println("action == null");
			String uname = request.getParameter("test");
			System.out.println("Req:"+uname+" info:"+request.getParameterValues("test"));
			response.getOutputStream().print("Response: "+uname);
		}
	
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setAttribute("displayname", currentUser.getUser());
		System.out.println(request.getParameter("displayname"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
		dispatcher.forward(request, response);
	}
	private void test(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setAttribute("displayname", currentUser.getUser());
		System.out.println(request.getParameter("displayname"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/Test.jsp");
		dispatcher.forward(request, response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		currentUser.setUser("");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	private void signupmenu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/signup.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
		request.setAttribute("displayname", currentUser.getUser());

		dispatcher.forward(request, response);
	}

	private void showedit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Competidor competidor = findById(request.getParameter("id"));
		request.setAttribute("competidor", competidor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		request.setAttribute("displayname", currentUser.getUser());
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("null")
	private void getcurrentUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setAttribute("currentUser", currentUser);
		RequestDispatcher dispatcher6 = null;
		dispatcher6.forward(request, response);
	}
			
	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Competidor c_persist = new Competidor(0, request.getParameter("Nombre"), request.getParameter("Apellidos"),
				request.getParameter("Pais"), request.getParameter("Categoria"),
				Integer.parseInt(request.getParameter("Ranking")));
		persist(c_persist);
		RequestDispatcher dispatcher3 = request.getRequestDispatcher("index2.jsp");
		request.setAttribute("displayname", currentUser.getUser());
		dispatcher3.forward(request, response);
	}

	private void borrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		System.out.println(request.getParameter("id"));
		delete(request.getParameter("id"));
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
		request.setAttribute("displayname", currentUser.getUser());
		List<Competidor> listarCompetidores = findAll();
		request.setAttribute("lista", listarCompetidores);
		//dispatcher.forward(request, response);
		}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/vista/listado.jsp");
		List<Competidor> listarCompetidores = findAll();
		request.setAttribute("lista", listarCompetidores);
		request.setAttribute("displayname", currentUser.getUser());
		dispatcher1.forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Competidor c_update = new Competidor(Integer.parseInt(request.getParameter("id")),
				request.getParameter("Nombre"), request.getParameter("Apellidos"), request.getParameter("Pais"),
				request.getParameter("Categoria"), Integer.parseInt(request.getParameter("Ranking")));
		update(c_update);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vista/mostrar.jsp");
		request.setAttribute("displayname", currentUser.getUser());
		List<Competidor> listarCompetidores = findAll();
		request.setAttribute("lista", listarCompetidores);
		dispatcher.forward(request, response);
	}
	private void SecureLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		SecureLogin almacenado = buscalogin(request.getParameter("user"));
		if( almacenado.getUser().equals(request.getParameter("user"))  ) {
			
		
		try {
				
			if(Passwords.validatePassword(request.getParameter("password"),almacenado.getPassword())){
					currentUser.setUser(almacenado.getUser());
					index(request,response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}
		catch(NullPointerException e){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	
	}
	private void signup(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] condimento= Passwords.getSalt();
		String password = Passwords.generateStorngPasswordHash(request.getParameter("password"), condimento.toString());
		SecureLogin newuser = new SecureLogin(request.getParameter("user"),password,condimento.toString());

		try {
			SecureLogin checksignup = buscalogin(newuser.getUser());
			if(checksignup == null) {
				registeruser(newuser);
				System.out.println("---");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("vista/signup.jsp");
				dispatcher.forward(request, response);
			}
		
		}
		catch(NullPointerException e){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
			
		
		
	}

	// --> hibernate
	public AdminCompetidor() {
		competidorDAO = new CompetidorDAO();
	}

	private void persist(Competidor entity) {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.persist(entity);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	private void update(Competidor entity) {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.update(entity);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	private Competidor findById(String id) {
		competidorDAO.openCurrentSession();
		Competidor book = competidorDAO.findById(id);
		competidorDAO.closeCurrentSession();
		return book;
	}

	private SecureLogin buscalogin(String user) {
		competidorDAO.openCurrentSessionwithTransaction();
		SecureLogin login = competidorDAO.buscarUsuario(user);
		competidorDAO.closeCurrentSessionwithTransaction();

		return login;
	}

	private void registeruser(SecureLogin user) {
		competidorDAO.openCurrentSessionwithTransaction();
		competidorDAO.persist(user);
		competidorDAO.closeCurrentSessionwithTransaction();

	}

	private void delete(String id) {
		competidorDAO.openCurrentSessionwithTransaction();
		Competidor book = competidorDAO.findById(id);
		competidorDAO.delete(book);
		competidorDAO.closeCurrentSessionwithTransaction();
	}

	private List<Competidor> findAll() {
		competidorDAO.openCurrentSession();
		List<Competidor> competidores = competidorDAO.findAll();
		competidorDAO.closeCurrentSession();
		return competidores;
	}
}
