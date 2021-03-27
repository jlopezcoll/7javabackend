package com.sopadeletras.model;

public class Sopa {
	
	//propiedades
	int idSopa;
	String idJugador;
	int puntos;
	

	public Sopa() {
		
	}	

	public Sopa(String idJugador, int puntos) {
		super();
		this.idJugador = idJugador;
		this.puntos = puntos;
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
