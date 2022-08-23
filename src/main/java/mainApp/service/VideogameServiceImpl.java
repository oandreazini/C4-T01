package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IVideogameDAO;
import mainApp.dto.Videogame;

@Service
public class VideogameServiceImpl implements IVideogameService {

	// Utilizamos los metodos de la interface IVideogameDAO, es como si instaciaramos.
	@Autowired
	IVideogameDAO iVideogameDAO;

	@Override
	public List<Videogame> listVideogames() {
		return iVideogameDAO.findAll();
	}

	@Override
	public Videogame saveVideogames(Videogame v) {
		return iVideogameDAO.save(v);
	}

	@Override
	public Videogame videogameXID(Integer id) {
		return iVideogameDAO.findById(id).get();
	}

	@Override
	public Videogame updateVideogames(Videogame u) {
		return iVideogameDAO.save(u);
	}

	@Override
	public void deleteVideogames(Integer id) {
		iVideogameDAO.deleteById(id);

	}

}
