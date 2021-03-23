package com.sopadeletras.model;

public class Sopa {
	
	//propiedades
	Integer idSopa = null;
	int idJugador;
	int puntos;
	

	public Sopa() {
		// TODO Auto-generated constructor stub
	}
	

	public Sopa(int idJugador, int puntos) {
		super();
		this.idJugador = idJugador;
		this.puntos = puntos;
	}

	public int getIdSopa() {
		return idSopa;
	}


	public void setIdSopa(int idSopa) {
		this.idSopa = idSopa;
	}


	public int getIdJugador() {
		return idJugador;
	}


	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
