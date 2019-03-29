package com.testing.dao;

import com.agomez.competidor.model.Competidor;
import com.testing.model.*;
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

public class TestingDAO implements InterfaceDAO {
	private Session currentSession;
	private Transaction currentTransaction;

	public TestingDAO() {
	}

	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#openCurrentSession()
	 */
	@Override
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#openCurrentSessionwithTransaction()
	 */
	@Override
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#closeCurrentSession()
	 */
	@Override
	public void closeCurrentSession() {
		currentSession.close();
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#closeCurrentSessionwithTransaction()
	 */
	@Override
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration()
			 .configure()
			 .addPackage("com.testing.model")
			 .addAnnotatedClass(SecureLogin.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
 		return sessionFactory;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#getCurrentSession()
	 */
	@Override
	public Session getCurrentSession() {
		return currentSession;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#setCurrentSession(org.hibernate.Session)
	 */
	@Override
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#getCurrentTransaction()
	 */
	@Override
	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#setCurrentTransaction(org.hibernate.Transaction)
	 */
	@Override
	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	} 
	

	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#buscarUsuario(java.lang.String)
	 */
	@Override
	public SecureLogin buscarUsuario(String user) {
		SecureLogin login = getCurrentSession().get(SecureLogin.class, user);

		return login;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SecureLogin> findAll() {
		 List<SecureLogin> users = (List<SecureLogin>) getCurrentSession().createQuery("from SecureLogin").list() ;
		return users;
	}


	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#CheckSecurelogin(java.lang.String)
	 */
	@Override
	public SecureLogin CheckSecurelogin(String user) {

		return null;
		
	}
	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#persist(com.testing.model.SecureLogin)
	 */
	@Override
	public void persist(SecureLogin entity) {
		getCurrentSession().save(entity);
	}
	
	/* (non-Javadoc)
	 * @see com.testing.dao.InterfaceDAO#update(com.testing.model.SecureLogin)
	 */
	@Override
	public void update(SecureLogin entity) {
		getCurrentSession().update(entity);
	}
	
	public void delete(SecureLogin entity) {
		getCurrentSession().delete(entity);
	}
	
	
	
	
}
