package com.sopadeletras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sopadeletras.model.Diccionario;

public class DiccionarioDAO implements GenericDAO<Diccionario, Integer> {

	private MySqlDB MySqlDB = new MySqlDB();

	@Override
	public void insertar(Diccionario t) throws SQLException {

	}

	@Override
	public void modificar(Diccionario t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Diccionario t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Diccionario> obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diccionario obtener(Integer id) throws SQLException {
		Connection conn = null;
		Diccionario palabra = null;
		try {
			conn = MySqlDB.conectar();
			String query = "SELECT * FROM diccionario WHERE idPalabra = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				palabra = new Diccionario(rs.getString(2));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlDB.desconetar();
		}

		return palabra;
	}

	public static void main(String[] args) throws SQLException {
		DiccionarioDAO prueba = new DiccionarioDAO();
		System.out.println(prueba.obtener(2).getPalabra());
		System.out.println(prueba.obtener(5).getPalabra());
		System.out.println(prueba.obtener(1).getPalabra());

	}

}
