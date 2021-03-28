package com.p7j.daomysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p7j.dao.PalabraDAO;
import com.p7j.model.Palabra;

public class PalabraDAOMysql implements PalabraDAO {

	public PalabraDAOMysql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Palabra> findAll() {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from palabras";
		List<Palabra> listaPalabras = new ArrayList<Palabra>();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Palabra p = new Palabra();
				p.setId(rs.getInt("id"));
				p.setPalabra(rs.getString("palabra"));
				listaPalabras.add(p);
			}
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la devolución de datos.");
		}
		return listaPalabras;
	}

	@Override
	public Palabra findById(int id) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from palabras where id="+id;
		Palabra palabra = new Palabra();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				palabra.setId(rs.getInt("id"));
				palabra.setPalabra(rs.getString("palabra"));
			}
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la devolución de datos.");
		}
		return palabra;
	}

	@Override
	public Palabra insertPalabra(Palabra palabra) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "insert into palabras(id, palabra) values ("+palabra.getId()+", '"+palabra.getPalabra()+"')";
		
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
		return palabra;
	}

	@Override
	public Palabra updatePalabra(Palabra palabra) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "update palabras set palabra='"+palabra.getPalabra()+"' where id="+palabra.getId();
		
		try {
			co = Conexion.getConexion();
			st = co.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			rs.close();
			co.close();
		} catch(SQLException e) {
			System.out.println("Error en la devolución de datos.");
		}
		return palabra;
	}

	@Override
	public boolean deletePalabra(Palabra palabra) {
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "delete from palabras where id="+palabra.getId();
		
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
