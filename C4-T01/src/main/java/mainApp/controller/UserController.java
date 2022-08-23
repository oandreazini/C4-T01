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

import mainApp.dto.User;
import mainApp.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	public List<User> listUsers() {
		return userServiceImpl.listUsers();
	}

	@PostMapping("/users")
	public User saveUsers(@RequestBody User u) {

		return userServiceImpl.saveUsers(u);
	}

	@GetMapping("/users/{id}")
	public User userXID(@PathVariable(name = "id") int id) {

		return userServiceImpl.userXID(id);

	}

	@PutMapping("/users/{id}")
	public User updateUsers(@PathVariable(name = "id") int id, @RequestBody User u) {

		User user_select;
		User user_update;

		user_select = userServiceImpl.userXID(id);

		user_select.setName(u.getName());
		user_select.setEmail(u.getEmail());
		user_select.setGame(u.getGame());
		user_select.setMessage(u.getMessage());
		user_select.setParty(u.getParty());

		user_update = userServiceImpl.updateUsers(user_select);

		System.out.println("El user actualizado es: " + user_update);

		return user_update;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable(name = "id") int id) {
		userServiceImpl.deleteUsers(id);
	}


}
