package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IGameDAO;
import mainApp.dto.Game;

@Service
public class GameServiceImpl implements  IGameService{

	// Utilizamos los metodos de la interface IGameDAO, es como si instaciaramos.
	@Autowired
	IGameDAO iGameDAO;

	@Override
	public List<Game> listGames() {
		return iGameDAO.findAll();
	}

	@Override
	public Game saveGames(Game g) {
		return iGameDAO.save(g);
	}

	@Override
	public Game gameXID(Integer id) {
		return iGameDAO.findById(id).get();
	}

	@Override
	public Game updateGames(Game g) {
		return iGameDAO.save(g);
	}

	@Override
	public void deleteGames(Integer id) {
		iGameDAO.deleteById(id);

	}

}
