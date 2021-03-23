package com.sopadeletras.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, K> {
	
	void insertar(T t) throws SQLException;
	
	void modificar(T t) throws SQLException;
	
	void eliminar(T t) throws SQLException;
	
	List<T> obtenerTodos() throws SQLException;
	
	T obtener(K id) throws SQLException;

}
