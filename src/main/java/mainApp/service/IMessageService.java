package mainApp.service;

import java.util.List;

import mainApp.dto.Message;

public interface IMessageService {

	//Metodos del CRUD
	public List<Message> listMessages(); //Listar All 

	public Message saveMessages(Message m);	//Guarda un Message CREATE

	public Message messageXID(Integer id); //Leer datos de un Message READ

	public Message updateMessages(Message m); //Actualiza datos del Message UPDATE

	public void deleteMessages(Integer id);// Elimina el Message DELETE

}
