package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Message;

public interface IMessageDAO extends JpaRepository<Message, Integer>{ 

}
