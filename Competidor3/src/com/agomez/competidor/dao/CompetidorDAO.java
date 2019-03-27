package com.agomez.competidor.dao;

import com.agomez.competidor.model.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 * @autor: Alberto Gömez Peña
 * @web: www.albertogomp.es
 */

public class CompetidorDAO implements InterfaceDAO<Competidor, String> {
	private Session currentSession;
	private Transaction currentTransaction;

	public CompetidorDAO() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration()
			 .configure()
			 .addPackage("com.agomez.competidor.model")
			 .addAnnotatedClass(Competidor.class)
		     .addAnnotatedClass(Login.class);
			 	
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
 		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Competidor entity) {
		getCurrentSession().save(entity);
	}

	public void update(Competidor entity) {
		getCurrentSession().update(entity);
	}

	public Competidor findById(String id) {
		Competidor book = (Competidor) getCurrentSession().get(Competidor.class,(Integer.parseInt(id)));
		return book;
	}

	public Login Checklogin(String id) {
		System.out.println("---**");
		Login login = getCurrentSession().get(Login.class, id);
		System.out.println("---**");

		return login;
	}

	public void delete(Competidor entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Competidor> findAll() {
		 List<Competidor> competidores = (List<Competidor>) getCurrentSession().createQuery("from Competidor").list();
		return competidores;
	}

	public void deleteAll() {
		List<Competidor> entityList = findAll();
		for (Competidor entity : entityList) {
			delete(entity);
		}
	}

	/*
	 * private Conexion con; private Connection connection;
	 * 
	 * public CompetidorDAO(String jdbcURL, String jdbcUsername, String
	 * jdbcPassword) throws SQLException { System.out.println(jdbcURL); con = new
	 * Conexion(jdbcURL, jdbcUsername, jdbcPassword); }
	 */

	/*
	 * Hibernate - sesiones: public static Session openCurrentSession() {
	 * currentSession = getSessionFactory().openSession(); return currentSession; }
	 * public static Session openCurrentSessionwithTransaction() { currentSession =
	 * getSessionFactory().openSession(); currentTransaction =
	 * currentSession.beginTransaction(); return currentSession; }
	 * 
	 * public static void closeCurrentSession() { currentSession.close(); }
	 * 
	 * public static void closeCurrentSessionwithTransaction() {
	 * System.out.println("---"); currentTransaction.commit();
	 * System.out.println("---"); currentSession.close(); System.out.println("---");
	 * 
	 * }
	 * 
	 * private static SessionFactory getSessionFactory() { Configuration
	 * configuration = new Configuration().configure();
	 * StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	 * .applySettings(configuration.getProperties()); SessionFactory sessionFactory
	 * = configuration.buildSessionFactory(builder.build()); return sessionFactory;
	 * }
	 * 
	 * public static Session getCurrentSession() { return currentSession; }
	 * 
	 * public void setCurrentSession(Session currentSession) { this.currentSession =
	 * currentSession; }
	 * 
	 * public static Transaction getCurrentTransaction() { return
	 * currentTransaction; }
	 * 
	 * public void setCurrentTransaction(Transaction currentTransaction) {
	 * this.currentTransaction = currentTransaction; } //------------------ public
	 * static void persist(Competidor competidor) {
	 * getCurrentSession().save(competidor); } public static void update(Competidor
	 * competidor) { getCurrentSession().update(competidor); }
	 * 
	 * public static Competidor findById(String id) { Competidor competidor =
	 * (Competidor) getCurrentSession().get(Competidor.class, id); return
	 * competidor; }
	 * 
	 * public static void delete(Competidor competidor) {
	 * getCurrentSession().delete(competidor); }
	 * 
	 * @SuppressWarnings("unchecked") public static List<Competidor> findAll() {
	 * List<Competidor> competidor = (List<Competidor>)
	 * getCurrentSession().createQuery("SELECT * from lista").list(); return
	 * competidor; } public static void deleteAll() { List<Competidor> entityList =
	 * findAll(); for (Competidor entity : entityList) { delete(entity); } }
	 */
	/*
	 * --------------------------------- // insertar competidor public boolean
	 * insertar(Competidor competidor) throws SQLException { boolean rowInserted;
	 * 
	 * String sql =
	 * "INSERT INTO lista (id, nombre, apellidos, Pais, Categoria, Ranking) VALUES (?, ?, ?,?,?,?)"
	 * ; System.out.println(competidor.getApellidos()); con.conectar(); connection =
	 * con.getJdbcConnection(); PreparedStatement statement =
	 * connection.prepareStatement(sql); statement.setString(1, null );
	 * statement.setString(2, competidor.getNombre()); statement.setString(3,
	 * competidor.getApellidos()); statement.setString(4, competidor.getPais());
	 * statement.setString(5, competidor.getCategoria()); statement.setInt(6,
	 * competidor.getRanking()); rowInserted = statement.executeUpdate() > 0;
	 * 
	 * statement.close(); con.desconectar();
	 * 
	 * return rowInserted; }
	 * 
	 * // listar todos los competidores public List<Competidor> listarCompetidores()
	 * throws SQLException {
	 * 
	 * List<Competidor> listaCompetidor = new ArrayList<Competidor>(); String sql =
	 * "SELECT * FROM lista"; con.conectar(); connection = con.getJdbcConnection();
	 * Statement statement = connection.createStatement(); ResultSet resulSet =
	 * statement.executeQuery(sql);
	 * 
	 * while (resulSet.next()) { int id = resulSet.getInt("id"); String nombre =
	 * resulSet.getString("nombre"); String apellidos =
	 * resulSet.getString("apellidos"); String pais = resulSet.getString("pais");
	 * String categoria = resulSet.getString("categoria"); int ranking =
	 * resulSet.getInt("ranking"); Competidor competidor = new Competidor(id,
	 * nombre, apellidos, pais, categoria, ranking);
	 * listaCompetidor.add(competidor); } con.desconectar(); return listaCompetidor;
	 * }
	 * 
	 * // obtener por id public Competidor obtenerPorId(int id) throws SQLException
	 * { Competidor competidor = null;
	 * 
	 * String sql = "SELECT * FROM lista WHERE id= ? "; con.conectar(); connection =
	 * con.getJdbcConnection(); PreparedStatement statement =
	 * connection.prepareStatement(sql); statement.setInt(1, id); ResultSet res =
	 * statement.executeQuery(); if (res.next()) {
	 * System.out.println("prepara para obtener"); competidor = new
	 * Competidor(res.getInt("id"), res.getString("nombre"),
	 * res.getString("apellidos"), res.getString("pais"),
	 * res.getString("categoria"), res.getInt("ranking"));
	 * System.out.println("obtiene"); } res.close(); con.desconectar();
	 * System.out.println(competidor); return competidor; }
	 * 
	 * // actualizar public boolean actualizar(Competidor competidor) throws
	 * SQLException { boolean rowActualizar = false; String sql =
	 * "UPDATE lista SET Nombre=?,Apellidos=?,Pais=?,Categoria=?, Ranking=? WHERE id=?"
	 * ; con.conectar(); connection = con.getJdbcConnection(); PreparedStatement
	 * statement = connection.prepareStatement(sql); statement.setString(1,
	 * competidor.getNombre()); statement.setString(2, competidor.getApellidos());
	 * statement.setString(3, competidor.getPais()); statement.setString(4,
	 * competidor.getCategoria()); System.out.println(competidor.getApellidos());
	 * statement.setInt(5, competidor.getRanking()); statement.setInt(6,
	 * competidor.getId()); rowActualizar = statement.executeUpdate() > 0;
	 * statement.close(); con.desconectar(); return rowActualizar; }
	 * 
	 * //eliminar public boolean eliminar(Competidor competidor) throws SQLException
	 * { boolean rowEliminar = false; String sql = "DELETE FROM lista WHERE ID=?";
	 * con.conectar(); connection = con.getJdbcConnection(); PreparedStatement
	 * statement = connection.prepareStatement(sql); statement.setInt(1,
	 * competidor.getId());
	 * 
	 * rowEliminar = statement.executeUpdate() > 0; statement.close();
	 * con.desconectar();
	 * 
	 * return rowEliminar; } //Obtener login public Login loguear(String user)
	 * throws SQLException{ Login login = null; String sql =
	 * "SELECT * FROM login WHERE user= ? "; con.conectar(); connection =
	 * con.getJdbcConnection(); PreparedStatement statement =
	 * connection.prepareStatement(sql);
	 * System.out.println("Entra en la conexion del login"); statement.setString(1,
	 * user); ResultSet res = statement.executeQuery(); if (res.next()) { login =
	 * new Login(res.getString("user"), res.getString("password")); } res.close();
	 * con.desconectar(); return login; }
	 */
}
