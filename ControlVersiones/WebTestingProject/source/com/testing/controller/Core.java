package com.testing.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

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

import com.testing.dao.TestingDAO;
import com.testing.model.SecureLogin;
import com.testing.security.*;


@WebServlet("/Core")
public class Core extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static TestingDAO testingDAO;
	private static SecureLogin currentUser = new SecureLogin();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		System.out.println(request.getParameter("user"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("action"));

		
			try {
				switch(action) {
				case "testconection":
				test(request,response);
				break;
				case "signup":
					signup(request,response);
				break;
				case "SecureLogin":
					SecureLogin(request,response);
				break;
				}
			} catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	private void test(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setAttribute("servletResponse", "hello from servlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/test.jsp");
		dispatcher.forward(request, response);
	}
	private void SecureLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		SecureLogin almacenado = buscalogin(request.getParameter("user"));
		if( almacenado.getUser().equals(request.getParameter("user"))  ) {
			
		try {
			System.out.println("dentro del try");
			if(Passwords.validatePassword(request.getParameter("password"),almacenado.getPassword())){
					currentUser.setUser(almacenado.getUser());
					RequestDispatcher dispatcher = request.getRequestDispatcher("vista/userdata.jsp");
					dispatcher.forward(request, response);
			}
			else {
//				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//				dispatcher.forward(request, response);
			}
		}
		catch(NullPointerException e){
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
		}
		}
		else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("vista/test.jsp");
			dispatcher.forward(request, response);
		}
			
		
		
	}

	
	
	// --> hibernate
	public Core() {
		testingDAO = new TestingDAO();
	}


		@SuppressWarnings("unused")
		private void persist(SecureLogin entity) {
			testingDAO.openCurrentSessionwithTransaction();
			testingDAO.persist(entity);
			testingDAO.closeCurrentSessionwithTransaction();
		}

		@SuppressWarnings("unused")
		private void update(SecureLogin entity) {
			testingDAO.openCurrentSessionwithTransaction();
			testingDAO.update(entity);
			testingDAO.closeCurrentSessionwithTransaction();
		}

//		private SecureLogin findById(String id) {
//			testingDAO.openCurrentSession();
//			SecureLogin book = testingDAO.SecureLogin(id);
//			testingDAO.closeCurrentSession();
//			return book;
//		}

		@SuppressWarnings("unused")
		private SecureLogin buscalogin(String user) {
			testingDAO.openCurrentSessionwithTransaction();
			SecureLogin login = testingDAO.buscarUsuario(user);
			testingDAO.closeCurrentSessionwithTransaction();
			System.out.println(login);
			return login;
		}

		@SuppressWarnings("unused")
		private void registeruser(SecureLogin user) {
			testingDAO.openCurrentSessionwithTransaction();
			testingDAO.persist(user);
			testingDAO.closeCurrentSessionwithTransaction();

		}

//		private void delete(String id) {
//			testingDAO.openCurrentSessionwithTransaction();
//			SecureLogin book = testingDAO.findById(id);
//			testingDAO.delete(book);
//			testingDAO.closeCurrentSessionwithTransaction();
//		}

		@SuppressWarnings("unused")
		private List<SecureLogin> findAll() {
			testingDAO.openCurrentSession();
			List<SecureLogin> competidores = testingDAO.findAll();
			testingDAO.closeCurrentSession();
			return competidores;
		}
}
