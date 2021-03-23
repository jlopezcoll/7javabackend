package com.sopadeletras.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlDB {
	
	//Declaramos nuestra conexión a null
	private Connection conexion = null;
	//Declaramos la url de mysql
	private final String HOST = "jdbc:mysql://localhost:3306/sopadeletras";
	//Declaramos el user de mysql
	private final String USER = "root";
	//Declaramos la password de mysql
	private final String PASS = "";
	
	public Connection conectar() throws SQLException {
		try {			
			conexion = DriverManager.getConnection(HOST, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Estoy conectado");		
		return conexion;
	}
	
	public void desconetar() throws SQLException{
		if (conexion != null) {
		try {
			conexion.close();
			//conexion = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
