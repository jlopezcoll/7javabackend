package com.sopadeletras.model;

public class Diccionario {
	
	//propiedades
	Integer idPalabra;
	String palabra;
	

	public Diccionario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Diccionario(String palabra) {
		//super();
		this.palabra = palabra;
	}



	public int getIdPalabra() {
		return idPalabra;
	}


	public void setIdPalabra(int idPalabra) {
		this.idPalabra = idPalabra;
	}


	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

}
