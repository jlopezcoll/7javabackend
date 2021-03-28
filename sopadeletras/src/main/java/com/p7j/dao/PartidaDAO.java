package com.p7j.dao;

import java.util.List;
import com.p7j.model.Partida;

public interface PartidaDAO {

	List<Partida> findAll();
	Partida findById(int id);
	
	Partida insertPartida(Partida partida);
	Partida updatePartida(Partida partida);
	boolean deletePartida(Partida partida);
	
}
