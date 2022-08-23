package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users") // en caso que la tabla sea diferente
public class User {

	// Atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "name") // no hace falta si se llama igual
	private String name;
	
	@Column(name = "email") // no hace falta si se llama igual
	private String email;
	
	@OneToMany
	@JoinColumn(name="id") // no hace falta si se llama igual
	private List<Message> message;
	
	@OneToMany
	@JoinColumn(name="id") // no hace falta si se llama igual
	private List<Game> game;
	
	@OneToMany
	@JoinColumn(name="id") // no hace falta si se llama igual
	private List<Party> party;

	
	//Constructores
	
	public User() {
		
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param message
	 * @param game
	 * @param party
	 */
	public User(int id, String name, String email, List<Message> message, List<Game> game, List<Party> party) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.game = game;
		this.party = party;
	}

	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "messages")
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "games")
	public List<Game> getGame() {
		return game;
	}

	public void setGame(List<Game> game) {
		this.game = game;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partys")
	public List<Party> getParty() {
		return party;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}

	
	//Metodo toString
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", game=" + game
				+ ", party=" + party + "]";
	}

}
