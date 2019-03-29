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

public class CompetidorDAO implements InterfaceDAO<Competidor, String, SecureLogin, String> {
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
			 .addAnnotatedClass(SecureLogin.class);
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
	public void persist(SecureLogin entity) {
		getCurrentSession().save(entity);
	}
	public void update(Competidor entity) {
		getCurrentSession().update(entity);
	}

	public Competidor findById(String id) {
		Competidor competidor = (Competidor) getCurrentSession().get(Competidor.class,(Integer.parseInt(id)));
		return competidor;
	}

	public SecureLogin buscarUsuario(String user) {
		SecureLogin login = getCurrentSession().get(SecureLogin.class, user);

		return login;
	}

	public void delete(Competidor entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Competidor> findAll() {
		 List<Competidor> competidores = (List<Competidor>) getCurrentSession().createQuery("from Competidor").list() ;
		return competidores;
	}

	public void deleteAll() {
		List<Competidor> entityList = findAll();
		for (Competidor entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public SecureLogin CheckSecurelogin(String user) {
		// TODO Auto-generated method stub
		return null;
	}
}
