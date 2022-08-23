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

import mainApp.dto.Party;
import mainApp.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {

	@Autowired
	PartyServiceImpl partyServiceImpl;

	@GetMapping("/partys")
	public List<Party> listPartys() {
		return partyServiceImpl.listPartys();
	}

	@PostMapping("/partys")
	public Party savePartys(@RequestBody Party p) {

		return partyServiceImpl.savePartys(p);
	}

	@GetMapping("/partys/{id}")
	public Party partyXID(@PathVariable(name = "id") int id) {

		return partyServiceImpl.partyXID(id);

	}

	@PutMapping("/partys/{id}")
	public Party updatePartys(@PathVariable(name = "id") int id, @RequestBody Party p) {

		Party party_select;
		Party party_update;

		party_select = partyServiceImpl.partyXID(id);
		
		party_select.setTitle(p.getTitle());
		party_select.setMessage(p.getMessage());
		party_select.setUser(p.getUser());
		
		party_update = partyServiceImpl.updatePartys(party_select);

		System.out.println("El partys actualizado es: " + party_update);

		return party_update;
	}

	@DeleteMapping("/partys/{id}")
	public void deletePartys(@PathVariable(name = "id") int id) {
		partyServiceImpl.deletePartys(id);
	}


}
