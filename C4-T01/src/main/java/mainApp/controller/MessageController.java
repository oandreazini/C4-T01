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

import mainApp.dto.Message;
import mainApp.service.MessageServiceImpl;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	MessageServiceImpl messageServiceImpl;
	

	@GetMapping("/messages")
	public List<Message> listMessages() {
		return messageServiceImpl.listMessages();
	}

	@PostMapping("/messages")
	public Message saveMessages(@RequestBody Message m) {

		return messageServiceImpl.saveMessages(m);
	}

	@GetMapping("/messages/{id}")
	public Message messageXID(@PathVariable(name = "id") int id) {
	
		return messageServiceImpl.messageXID(id);

	}

	@PutMapping("/messages/{id}")
	public Message updateMessages(@PathVariable(name = "id") int id, @RequestBody Message m) {

		Message message_select;
		Message message_update;

		message_select = messageServiceImpl.messageXID(id);
		
		message_select.setShipping(m.getShipping());
		message_select.setText(m.getText());
		message_select.setParty(m.getParty());
		message_select.setUser(m.getUser());
		
		message_update = messageServiceImpl.updateMessages(message_select);

		System.out.println("El messages actualizado es: " + message_update);

		return message_update;
	}

	@DeleteMapping("/messages/{id}")
	public void deleteMessages(@PathVariable(name = "id") int id) {
		messageServiceImpl.deleteMessages(id);
	}

	

}
