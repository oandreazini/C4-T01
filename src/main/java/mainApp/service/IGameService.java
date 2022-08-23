package mainApp.service;

import java.util.List;

import mainApp.dto.Game;


public interface IGameService {

	//Metodos del CRUD
	public List<Game> listGames(); //Listar All 

	public Game saveGames(Game g);	//Guarda un Game CREATE

	public Game gameXID(Integer id); //Leer datos de un Game READ

	public Game updateGames(Game g); //Actualiza datos del Game UPDATE

	public void deleteGames(Integer id);// Elimina el Game DELETE

}
