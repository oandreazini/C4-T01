package mainApp.service;

import java.util.List;

import mainApp.dto.User;

public interface IUserService {

	//Metodos del CRUD
	public List<User> listUsers(); //Listar All 

	public User saveUsers(User u);	//Guarda un User CREATE

	public User userXID(Integer id); //Leer datos de un User READ

	public User updateUsers(User u); //Actualiza datos del User UPDATE

	public void deleteUsers(Integer id);// Elimina el User DELETE
}
