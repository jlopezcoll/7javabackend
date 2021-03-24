package com.sopadeletras.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sopadeletras.model.Sopa;

public class SopaDAO implements GenericDAO<Sopa, Integer>{
	
	private MySqlDB MySqlDB = new MySqlDB();

	@Override
	public void insertar(Sopa t) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = MySqlDB.conectar();
			String query = "INSERT INTO sopa (idJugador, puntos) VALUES (?,?)";
			stat = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, t.getIdJugador());
			stat.setInt(2, t.getPuntos());			
			stat.executeUpdate();
			//Capturamos el ID de la sopa insertada
			rs = stat.getGeneratedKeys();
			if (rs.next()) {
				t.setIdSopa(rs.getInt(1));
			}
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlDB.desconetar();
		}
	}

	@Override
	public void modificar(Sopa t) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = MySqlDB.conectar();
			String query = "UPDATE sopa SET puntos = ? WHERE idSopa = ?";
			stat = conn.prepareStatement(query);
			stat.setInt(1, t.getPuntos());
			stat.setInt(2, t.getIdSopa());
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlDB.desconetar();
		}
	}

	@Override
	public void eliminar(Sopa t) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = MySqlDB.conectar();
			String query = "DELETE FROM sopa WHERE idSopa = ?";
			stat = conn.prepareStatement(query);
			stat.setInt(1, t.getIdSopa());		
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlDB.desconetar();
		}
	}
	@Override
	public List<Sopa> obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sopa obtener(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) throws SQLException {
		SopaDAO prueba = new SopaDAO();
		Sopa nuevaSopa = new Sopa(10, 11000);
		prueba.insertar(nuevaSopa);
		System.out.println(nuevaSopa.getIdSopa());
		nuevaSopa.setPuntos(0);
		prueba.modificar(nuevaSopa);
		//prueba
		
	}
	
	

}
