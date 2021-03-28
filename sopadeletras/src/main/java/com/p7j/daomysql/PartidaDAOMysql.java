package com.p7j.daomysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.p7j.dao.PartidaDAO;
import com.p7j.model.Partida;

public class PartidaDAOMysql implements PartidaDAO {

	public PartidaDAOMysql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Partida> findAll() {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from partidas";
		List<Partida> listaPartidas = new ArrayList<Partida>();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Partida p = new Partida();
				p.setId(rs.getInt("id"));
				p.setJugador(null);
				p.setPuntuacion(rs.getInt("puntuacion"));
				p.setFecha(rs.getDate("fecha"));
				listaPartidas.add(p);
			}
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la devolución de datos.");
		}
		return listaPartidas;
	}

	@Override
	public Partida findById(int id) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from partidas where id="+id;
		Partida partida = new Partida();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				partida.setId(rs.getInt("id"));
				partida.setJugador(null);
				partida.setPuntuacion(rs.getInt("puntuacion"));
				partida.setFecha(rs.getDate("fecha"));
			}
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la devolución de datos.");
		}
		return partida;
	}

	@Override
	public Partida insertPartida(Partida partida) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "insert into partidas(id, jugador, puntuacion, fecha) values ("+partida.getId()+", "+partida.getJugador()+", "+partida.getPuntuacion()+", '"+partida.getFecha()+"')";
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la inserción de datos.");
		}
		return partida;
	}

	@Override
	public Partida updatePartida(Partida partida) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "update partidas set jugador="+partida.getJugador()+", puntuacion="+partida.getPuntuacion()+", fecha='"+partida.getFecha()+"' where id="+partida.getId();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la actualización de datos.");
		}
		return partida;
	}

	@Override
	public boolean deletePartida(Partida partida) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "delete from partidas where id="+partida.getId();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en el borrado de datos.");
		}
		return true;
	}

}
