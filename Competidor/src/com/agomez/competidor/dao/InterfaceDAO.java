package com.agomez.competidor.dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T, Id, Suser, Id2  extends Serializable> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(Id id);
	

	public Suser CheckSecurelogin(Id2 user);

	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();
	
}
