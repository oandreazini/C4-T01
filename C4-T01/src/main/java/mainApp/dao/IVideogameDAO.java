package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Videogame;

public interface IVideogameDAO extends JpaRepository<Videogame, Integer>{

}
