package com.sopadeletras.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.sopadeletras.model.Diccionario;
import com.sopadeletras.model.Sopa;

public class SopaDAO implements GenericDAO<Sopa, Integer>{
	
	//private MySqlDB MySqlDB = new MySqlDB();
	private EntityManager manager;
	
	public SopaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopadeletras");
		manager = emf.createEntityManager();
		}

	@Override
	public void insertar(Sopa t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}
//	public void insertar(Sopa t){
//		Connection conn = null;
//		PreparedStatement stat = null;
//		ResultSet rs = null;
//		try {
//			conn = MySqlDB.conectar();
//			String query = "INSERT INTO sopa (idJugador, puntos) VALUES (?,?)";
//			stat = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			stat.setString(1, t.getIdJugador());
//			stat.setInt(2, t.getPuntos());			
//			stat.executeUpdate();
//			//Capturamos el ID de la sopa insertada
//			rs = stat.getGeneratedKeys();
//			if (rs.next()) {
//				t.setIdSopa(rs.getInt(1));
//			}
//			stat.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySqlDB.desconetar();
//		}
//	}

	@Override
	public void modificar(Sopa t){
	}
//	public void modificar(Sopa t){
//		Connection conn = null;
//		PreparedStatement stat = null;
//		try {
//			conn = MySqlDB.conectar();
//			String query = "UPDATE sopa SET puntos = ? WHERE idSopa = ?";
//			stat = conn.prepareStatement(query);
//			stat.setInt(1, t.getPuntos());
//			stat.setInt(2, t.getIdSopa());
//			stat.executeUpdate();
//			stat.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySqlDB.desconetar();
//		}
//	}

	@Override
	public void eliminar(Sopa t){
		manager.getTransaction().begin();
		manager.remove(t);
		manager.getTransaction().commit();
	}

//	public void eliminar(Sopa t){
//		Connection conn = null;
//		PreparedStatement stat = null;
//		try {
//			conn = MySqlDB.conectar();
//			String query = "DELETE FROM sopa WHERE idSopa = ?";
//			stat = conn.prepareStatement(query);
//			stat.setInt(1, t.getIdSopa());		
//			stat.executeUpdate();
//			stat.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySqlDB.desconetar();
//		}
//	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Sopa> obtenerTodos() {
		return (List<Sopa>) manager.createQuery("FROM Sopa").getResultList();
	}

	@Override
	public Sopa obtener(Integer id){
		return manager.find(Sopa.class, id);
	}
//	public Sopa obtener(Integer id){
//		Connection conn = null;
//		PreparedStatement stat = null;
//		ResultSet rs = null;		
//		Sopa sopa= null;
//		try {
//			conn = MySqlDB.conectar();
//			String query = "SELECT * FROM sopa WHERE idSopa = ?";
//			stat = conn.prepareStatement(query);
//			stat.setInt(1, id);
//			rs = stat.executeQuery();
//			if (rs.next()) {
//				sopa = new Sopa(rs.getInt(1), rs.getString(2), rs.getInt(3));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}				
//			}
//			if (stat != null) {
//				try {
//					stat.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}				
//			}
//			MySqlDB.desconetar();
//		}
//		return sopa;
//	}
	
	
	/*public static void main(String[] args) throws SQLException {
		SopaDAO prueba = new SopaDAO();
		//SopaDAO prueba2 = new SopaDAO();
		Sopa nuevaSopaJ = new Sopa("Javi", 11000);
		Sopa nuevaSopa2 = prueba.obtener(1);
		prueba.insertar(nuevaSopaJ);
		System.out.println(nuevaSopaJ.getIdJugador() + nuevaSopaJ.getPuntos());
		System.out.println(nuevaSopa2.getIdSopa() + nuevaSopa2.getIdJugador() + nuevaSopa2.getPuntos());
		nuevaSopa2.setPuntos(2000);
		prueba.modificar(nuevaSopa2);
		System.out.println(nuevaSopa2.getIdJugador() + nuevaSopa2.getPuntos());
		//prueba
		
	}*/
	
	

}
