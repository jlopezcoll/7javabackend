package com.sopadeletras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;

import com.sopadeletras.model.hibernate.Sopa;

public class TestSopa {
	
	//@PersistenceContext(unitName = "sopadeletras")
	private static EntityManager manager;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@SuppressWarnings("unused")
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sopadeletras");
        manager = factory.createEntityManager();
		//Sopa sopa;
		Sopa sopa = new Sopa();
		//System.out.println(manager.find(Sopa.class, 1));
		sopa = manager.find(Sopa.class, 1);
		System.out.println(sopa.getIdJugador());

	}

}
