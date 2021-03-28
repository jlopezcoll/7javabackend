package com.p7j.dao;

import java.util.List;
import com.p7j.model.Palabra;

public interface PalabraDAO {

	List<Palabra> findAll();
	Palabra findById(int id);
	
	Palabra insertPalabra(Palabra palabra);
	Palabra updatePalabra(Palabra palabra);
	boolean deletePalabra(Palabra palabra);
	
}
