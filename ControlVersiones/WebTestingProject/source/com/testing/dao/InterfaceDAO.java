package com.testing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.testing.model.SecureLogin;

public interface InterfaceDAO {

	Session openCurrentSession();

	Session openCurrentSessionwithTransaction();

	void closeCurrentSession();

	void closeCurrentSessionwithTransaction();

	Session getCurrentSession();

	void setCurrentSession(Session currentSession);

	Transaction getCurrentTransaction();

	void setCurrentTransaction(Transaction currentTransaction);

	SecureLogin buscarUsuario(String user);

	List<SecureLogin> findAll();

	SecureLogin CheckSecurelogin(String user);

	void update(SecureLogin entity);

	void persist(SecureLogin entity);

}