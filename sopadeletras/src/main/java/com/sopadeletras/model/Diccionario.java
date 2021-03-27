package com.sopadeletras.model;

public class Diccionario {
	
	//propiedades
	int idPalabra;
	String palabra;
	
	//Contructor vacio
	public Diccionario() {
	}
	
	//Contructor con palabra de atributo
	public Diccionario(String palabra) {
		this.palabra = palabra;
	}
	
	//Contructor con 2 atributos
	public Diccionario(int idPalabra, String palabra) {
		super();
		this.idPalabra = idPalabra;
		this.palabra = palabra;
	}
	
	//Getter and Setters
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
