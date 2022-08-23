package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IUserDAO;
import mainApp.dto.User;

@Service
public class UserServiceImpl implements IUserService{

	// Utilizamos los metodos de la interface IUserDAO, es como si instaciaramos.
	@Autowired
	IUserDAO iUserDAO;
	
	
	@Override
	public List<User> listUsers() {
		return iUserDAO.findAll();
	}

	@Override
	public User saveUsers(User u) {
		return iUserDAO.save(u);
	}

	@Override
	public User userXID(Integer id) {
		return iUserDAO.findById(id).get();
	}

	@Override
	public User updateUsers(User u) {
		return iUserDAO.save(u);
	}

	@Override
	public void deleteUsers(Integer id) {
		iUserDAO.deleteById(id);

	}

}
