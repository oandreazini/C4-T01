package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IMessageDAO;
import mainApp.dto.Message;

@Service
public class MessageServiceImpl implements  IMessageService{

	// Utilizamos los metodos de la interface IMessageDAO, es como si instaciaramos.
	@Autowired
	IMessageDAO iMessageDAO;

	@Override
	public List<Message> listMessages() {
		return iMessageDAO.findAll();
	}

	@Override
	public Message saveMessages(Message m) {
		return iMessageDAO.save(m);
	}

	@Override
	public Message messageXID(Integer id) {
		return iMessageDAO.findById(id).get();
	}

	@Override
	public Message updateMessages(Message m) {
		return iMessageDAO.save(m);
	}

	@Override
	public void deleteMessages(Integer id) {
		iMessageDAO.deleteById(id);

	}


}
