package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Game;

public interface IGameDAO extends JpaRepository<Game, Integer>{ 

}
