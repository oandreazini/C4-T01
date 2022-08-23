package mainApp.service;

import java.util.List;

import mainApp.dto.Videogame;

public interface IVideogameService {
	
	//Metodos del CRUD
	public List<Videogame> listVideogames(); //Listar All 

	public Videogame saveVideogames(Videogame v);	//Guarda un Videogame CREATE

	public Videogame videogameXID(Integer id); //Leer datos de un Videogame READ

	public Videogame updateVideogames(Videogame u); //Actualiza datos del Videogame UPDATE

	public void deleteVideogames(Integer id);// Elimina el Videogame DELETE

}
