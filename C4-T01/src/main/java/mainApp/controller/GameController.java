package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Game;
import mainApp.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> listGames() {
		return gameServiceImpl.listGames();
	}

	@PostMapping("/games")
	public Game saveGames(@RequestBody Game g) {

		return gameServiceImpl.saveGames(g);
	}

	@GetMapping("/games/{id}")
	public Game gameXID(@PathVariable(name = "id") int id) {
	
		return gameServiceImpl.gameXID(id);

	}

	@PutMapping("/games/{id}")
	public Game updateGames(@PathVariable(name = "id") int id, @RequestBody Game g) {

		Game game_select;
		Game game_update;

		game_select = gameServiceImpl.gameXID(id);
		
		game_select.setName(g.getName());
		game_select.setDescription(g.getDescription());
		game_select.setVideogame(g.getVideogame());
	
		game_update = gameServiceImpl.updateGames(game_select);

		System.out.println("El games actualizado es: " + game_update);

		return game_update;
	}

	@DeleteMapping("/games/{id}")
	public void deleteGames(@PathVariable(name = "id") int id) {
		gameServiceImpl.deleteGames(id);
	}


}
