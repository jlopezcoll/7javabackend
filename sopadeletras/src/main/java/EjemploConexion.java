import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EjemploConexion {
	
	//Declaramos nuestra conexión a null
	private Connection conexion = null;
	
	public EjemploConexion() throws SQLException {
		try {
			conectar();
			consultaSinPreparar();
			consultaPreparada("c%");
			System.out.println("------------------");
			consultaPreparadaINT(1);
		} finally {
			cerrar();
		}		
	}
	
	public void conectar() throws SQLException {
		//Declaramos la url de mysql
		String jdbc = "jdbc:mysql://localhost:3306/sopadeletras";
		conexion = DriverManager.getConnection(jdbc, "root", "");
		//System.out.println("Estoy conectado");		
	}
	
	private void consultaSinPreparar() throws SQLException{
		String query = "SELECT * FROM diccionario ORDER BY idPalabra";
		Statement statement = conexion.createStatement();
		ResultSet set = statement.executeQuery(query);
		while (set.next()) {
			int idPalabra = set.getInt("idPalabra");
			String palabra = set.getString("palabra");
			System.out.println("Palabra " + idPalabra + " " + palabra);
		}
		set.close();
		statement.close();
		
	}
	
	private void consultaPreparada(String id) throws SQLException{
		String query = "SELECT * FROM diccionario WHERE palabra LIKE ? ORDER BY idPalabra";
		PreparedStatement statement = conexion.prepareStatement(query);
		statement.setString(1, id);
		//statement.setInt(1,  nombre);
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			int idPalabra = set.getInt("idPalabra");
			String palabra = set.getString("palabra");
			System.out.println("Palabra " + idPalabra + " " + palabra);
		}
		set.close();
		statement.close();
		
	}
	
	private void consultaPreparadaINT(int id) throws SQLException{
		String query = "SELECT * FROM diccionario WHERE idPalabra = ?";
		PreparedStatement statement = conexion.prepareStatement(query);
		statement.setInt(1, id);
		//statement.setInt(1,  nombre);
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			int idPalabra = set.getInt("idPalabra");
			String palabra = set.getString("palabra");
			System.out.println("Palabra " + idPalabra + " " + palabra);
		}
		set.close();
		statement.close();
		
	}
	
	
	public void cerrar() throws SQLException{
		if (conexion != null) {
			conexion.close();			
		}
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(EjemploConexion.class);

	public static void main(String[] args) {
		try {
			new EjemploConexion();
		} catch (SQLException e) {
			LOG.error("Error en la conexión", e);
		}
		

	}

}
