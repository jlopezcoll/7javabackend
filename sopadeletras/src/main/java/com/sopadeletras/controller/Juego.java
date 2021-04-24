package com.sopadeletras.controller;

import com.sopadeletras.dao.SopaDAO;
import com.sopadeletras.model.Sopa;

public class Juego {
	
	Sopa sopa;
	SopaDAO sopaDao;
	String jugador;
	
	
	public Juego() {
		sopa = new Sopa();
		sopaDao = new SopaDAO();
	}
	
	public void setJugador(String j) {
		this.sopa.setIdJugador(j);
	}
	public void setPuntuacion( int p) {
		this.sopa.setPuntos(p);
	}	
	
	public int getPuntuacion() {
		return this.sopa.getPuntos();
	}
	
	public void guardarPartida() {
		this.sopaDao.insertar(this.sopa);
	}
	
	
	
	

}
