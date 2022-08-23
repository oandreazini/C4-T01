package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.User;

public interface IUserDAO extends JpaRepository<User, Integer>{

}
