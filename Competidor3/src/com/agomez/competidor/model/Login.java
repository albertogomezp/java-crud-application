package com.agomez.competidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @autor: Alberto Gómez Peña
 * @ web: www.albertogomp.es
 */

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name = "user")
	private String user;
	@Column(name="password")
	private String password;
	public Login() {
		super();
	}
	public Login(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
