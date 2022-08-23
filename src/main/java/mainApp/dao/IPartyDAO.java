package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Party;

public interface IPartyDAO extends JpaRepository<Party, Integer>{ 

}
