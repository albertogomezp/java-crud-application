package com.agomez.competidor.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.Table;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/*
 * @author: Alberto Gómez Peña
 * @ web: www.albertogomp.es
 */

@Entity
@Table(name = "lista")
public class Competidor  {
	
	@Id	
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "Pais")
	private String pais;
	@Column(name = "Categoria")
	private String categoria;
	@Column(name = "Ranking")
	private int ranking;
	
	public Competidor() {
		super();
	}
	public Competidor(int id, String nombre, String apellidos, String pais, String categoria, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pais = pais;
		this.categoria = categoria;
		this.ranking = ranking;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	@Override
	public String toString() {
		return "Competidor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pais=" + pais
				+ ", categoria=" + categoria + ", ranking=" + ranking + "]";
	}

}