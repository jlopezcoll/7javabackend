package com.sopadeletras.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlDB {
	
	//Declaramos nuestra conexión a null
	private Connection conexion = null;
	//Declaramos la url de mysql
	private final String HOST = "jdbc:mysql://localhost:3306/sopadeletras2";
	//Declaramos el user de mysql
	private final String USER = "root";
	//Declaramos la password de mysql
	private final String PASS = "";
	
	//Metodo para conectar a la BD
	public Connection conectar(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(HOST, USER, PASS);
		} catch (Exception e) {
			System.out.println("Error al conectar a la BD");	
			e.printStackTrace();
		}	
		return conexion;
	}
	
	
	//Metodo para desconectar de BD
	public void desconetar(){
		if (conexion != null) {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Eror al desconectar de la BD");	
			e.printStackTrace();
		}
	}
}
}
