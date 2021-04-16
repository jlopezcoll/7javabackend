package com.sopadeletras;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;

import com.sopadeletras.model.hibernate.Sopa;

@EJB
@Stateless
public class TestSopa {
	
	@PersistenceContext(unitName = "sopadeletras")
	private static EntityManager manager;
	
	public static Sopa getSopa(int id) {
		return manager.find(Sopa.class, id);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@SuppressWarnings("unused")//
		
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("sopadeletras");
        //manager = factory.createEntityManager();
		//Sopa sopa;
		Sopa sopa = new Sopa();
		//System.out.println(manager.find(Sopa.class, 1));
		//sopa = manager.find(Sopa.class, 1);
		sopa = getSopa(1);
		System.out.println(sopa.getIdJugador());

	}

}
