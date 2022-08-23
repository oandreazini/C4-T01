package mainApp.service;

import java.util.List;

import mainApp.dto.Party;

public interface IPartyService {

	//Metodos del CRUD
	public List<Party> listPartys(); //Listar All 

	public Party savePartys(Party p);	//Guarda un Party CREATE

	public Party partyXID(Integer id); //Leer datos de un Party READ

	public Party updatePartys(Party p); //Actualiza datos del Party UPDATE

	public void deletePartys(Integer id);// Elimina el Party DELETE
}
