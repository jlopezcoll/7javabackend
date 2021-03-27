package com.sopadeletras.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopadeletras.dao.DiccionarioDAO;
import com.sopadeletras.model.Diccionario;

/**
 * Servlet implementation class Partida
 */
@WebServlet("/partida")
public class Partida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Partida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		DiccionarioDAO diccionarioDB = new DiccionarioDAO();
		String palabra = diccionarioDB.obtener(2).getPalabra();
		//List<Diccionario> listaPalabras = null;
		//Object palabras;
		List<Diccionario> listaPalabras = diccionarioDB.obtenerTodos();
		String palabras = "esto es una string de prueba";
		request.setAttribute("palabras", palabras);
		request.setAttribute("palabra", palabra);
		request.setAttribute("listaPalabras", listaPalabras);
		 
		request.getRequestDispatcher("partida.jsp").forward(request, response);
		/*DiccionarioDAO prueba = new DiccionarioDAO();
		List<Diccionario> listPalabras2 = prueba.obtenerTodos();
		for (Diccionario diccionario : listPalabras2) {
			System.out.println(diccionario.getPalabra());
			}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
