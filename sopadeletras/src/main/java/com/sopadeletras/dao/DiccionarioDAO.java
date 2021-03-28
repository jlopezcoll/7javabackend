package com.sopadeletras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sopadeletras.model.Diccionario;

public class DiccionarioDAO implements GenericDAO<Diccionario, Integer> {

	private MySqlDB MySqlDB = new MySqlDB();

	@Override
	public void insertar(Diccionario t){
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = MySqlDB.conectar();
			String query = "INSERT INTO diccionario (palabra) VALUES (?)";
			stat = conn.prepareStatement(query);
			stat.setString(1, t.getPalabra());
			stat.executeUpdate();
			stat.close();
			MySqlDB.desconetar();
		} catch (SQLException e) {
			System.out.println("Error en la inserción de la palabra");
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(Diccionario t){
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Diccionario t){
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = MySqlDB.conectar();
			String query = "DELETE FROM diccionario WHERE palabra = ?";
			stat = conn.prepareStatement(query);
			stat.setString(1, t.getPalabra());
			stat.executeUpdate();
			stat.close();
			MySqlDB.desconetar();
		} catch (SQLException e) {
			System.out.println("Error al eliminar la palabra");
			e.printStackTrace();
		}
	}

	@Override
	public List<Diccionario> obtenerTodos() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;		
		Diccionario palabra = null;
		List<Diccionario> palabras = new ArrayList<>();
		try {
			conn = MySqlDB.conectar();
			String query = "SELECT * FROM diccionario";
			stat = conn.prepareStatement(query);
			rs = stat.executeQuery();
			while (rs.next()) {
				palabra = new Diccionario(rs.getInt(1), rs.getString(2));
				palabras.add(palabra);
			}
			rs.close();
			stat.close();
			MySqlDB.desconetar();
		} catch (SQLException e) {
			System.out.println("Error en la obtención de la palabra");
			e.printStackTrace();
		}
		return palabras;	
	}

	@Override
	public Diccionario obtener(Integer id) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;		
		Diccionario palabra = null;
		try {
			conn = MySqlDB.conectar();
			String query = "SELECT * FROM diccionario WHERE idPalabra = ?";
			stat = conn.prepareStatement(query);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				palabra = new Diccionario(rs.getString(2));
			}
			rs.close();
			stat.close();
			MySqlDB.desconetar();
		} catch (SQLException e) {
			System.out.println("Error en la obtención de la palabra");
			e.printStackTrace();
		}
		return palabra;
	}

	//Pruebas de funcionamiento
	/*public static void main(String[] args) throws SQLException {
		DiccionarioDAO prueba = new DiccionarioDAO();
		//System.out.println(prueba.obtener(2).getPalabra());
		//System.out.println(prueba.obtener(5).getPalabra());
		//System.out.println(prueba.obtener(3).getPalabra());
		//System.out.println("--------------------------------");
		//List<Diccionario> listPalabras = prueba.obtenerTodos();
		//for (Diccionario diccionario : listPalabras) {
			//System.out.println(diccionario.getPalabra());
		//}
		//System.out.println("--------- Insertamos una palabra -----------------------");
		Diccionario nuevaPalabra = new Diccionario("alicate");
		prueba.insertar(nuevaPalabra);
		//prueba.eliminar(nuevaPalabra);
		System.out.println("--------- Listado con palabra insertada -----------------------");
		List<Diccionario> listPalabras2 = prueba.obtenerTodos();
		for (Diccionario diccionario : listPalabras2) {
			System.out.println(diccionario.getPalabra());
		}
		
	}*/

}
