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

import mainApp.dto.Videogame;
import mainApp.service.VideogameServiceImpl;

@RestController
@RequestMapping("/api")
public class VideogameController {
	
	@Autowired
	VideogameServiceImpl videogameServiceImpl;
	
	@GetMapping("/videogames")
	public List<Videogame> listVideogames() {
		return videogameServiceImpl.listVideogames();
	}

	@PostMapping("/videogames")
	public Videogame saveVideogames(@RequestBody Videogame v) {

		return videogameServiceImpl.saveVideogames(v);
	}

	@GetMapping("/videogames/{id}")
	public Videogame videogameXID(@PathVariable(name = "id") int id) {
	
		return videogameServiceImpl.videogameXID(id);

	}

	@PutMapping("/videogames/{id}")
	public Videogame updateVideogames(@PathVariable(name = "id") int id, @RequestBody Videogame v) {

		Videogame videogame_select;
		Videogame videogame_update;

		videogame_select = videogameServiceImpl.videogameXID(id);
		
		videogame_select.setTitle(v.getTitle());
		videogame_select.setGame(v.getGame());
			
		videogame_update = videogameServiceImpl.updateVideogames(videogame_select);

		System.out.println("El videogames actualizado es: " + videogame_update);

		return videogame_update;
	}

	@DeleteMapping("/videogames/{id}")
	public void deleteVideogames(@PathVariable(name = "id") int id) {
		videogameServiceImpl.deleteVideogames(id);
	}


}
