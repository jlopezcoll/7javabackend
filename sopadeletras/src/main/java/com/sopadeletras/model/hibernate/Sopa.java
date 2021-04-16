package com.sopadeletras.model.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="sopa")
public class Sopa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSopa")
	private int idSopa;
	@Column(name = "idJugador")
	private String idJugador;
	@Column(name = "puntos")
	private int puntos;
	

	public Sopa() {
		
	}	

	public Sopa(int idSopa, String idJugador, int puntos) {
		this.idSopa = idSopa;
		this.idJugador = idJugador;
		this.puntos = puntos;
	}	

	public int getIdSopa() {
		return idSopa;
	}


	public void setIdSopa(int idSopa) {
		this.idSopa = idSopa;
	}


	public String getIdJugador() {
		return idJugador;
	}


	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
