package com.sopadeletras.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sopadeletras.model.Diccionario;
//import com.sopadeletras.model.hibernate.Sopa;

public class DiccionarioDAO implements GenericDAO<Diccionario, Integer> {

	private EntityManager manager;
	
	public DiccionarioDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopadeletras");
		manager = emf.createEntityManager();
		}

	@Override
	public void insertar(Diccionario t){
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}
	@Override
	public void modificar(Diccionario t){
		// TODO Auto-generated method stub

	}

	
	@Override
	public void eliminar(Diccionario t){
		manager.getTransaction().begin();
		manager.remove(t);
		manager.getTransaction().commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Diccionario> obtenerTodos() {
		return (List<Diccionario>) manager.createQuery("FROM Diccionario").getResultList();
	}


	@Override
	public Diccionario obtener(Integer id) {
		return manager.find(Diccionario.class, id);
		
	}

	//Pruebas de funcionamiento
	//public static void main(String[] args){
		//DiccionarioDAO prueba = new DiccionarioDAO();
		//System.out.println(prueba.obtener(2).getPalabra());
		//System.out.println(prueba.obtener(5).getPalabra());
		//System.out.println(prueba.obtener(3).getPalabra());
		//System.out.println("--------------------------------");
		//Diccionario nuevaPalabra = new Diccionario("dado");
		//prueba.insertar(nuevaPalabra);
		//List<Diccionario> listPalabras = prueba.obtenerTodos();
		//for (Diccionario diccionario : listPalabras) {
			//System.out.println(diccionario.getPalabra());
		//}
		//System.out.println("--------- Insertamos una palabra -----------------------");
		//Diccionario nuevaPalabra = new Diccionario("canario");
		//prueba.insertar(nuevaPalabra);
		//prueba.eliminar(nuevaPalabra);
		//System.out.println("--------- Listado con palabra insertada -----------------------");
		//List<Diccionario> listPalabras2 = prueba.obtenerTodos();
		//for (Diccionario diccionario : listPalabras2) {
			//System.out.println(diccionario.getPalabra());
		//}
		
	//}

}
