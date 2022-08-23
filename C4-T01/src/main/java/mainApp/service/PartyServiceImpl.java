package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mainApp.dao.IPartyDAO;
import mainApp.dto.Party;

public class PartyServiceImpl implements IPartyService {

	// Utilizamos los metodos de la interface IPartyDAO, es como si instaciaramos.
	@Autowired
	IPartyDAO iPartyDAO;

	@Override
	public List<Party> listPartys() {
		return iPartyDAO.findAll();
	}

	@Override
	public Party savePartys(Party p) {
		return iPartyDAO.save(p);
	}

	@Override
	public Party partyXID(Integer id) {
		return iPartyDAO.findById(id).get();
	}

	@Override
	public Party updatePartys(Party p) {
		return iPartyDAO.save(p);
	}

	@Override
	public void deletePartys(Integer id) {
		iPartyDAO.deleteById(id);

	}

}
