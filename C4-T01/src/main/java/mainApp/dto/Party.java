package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "messages") // en caso que la tabla sea diferente
public class Party {

	// Atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@Column(name="title")// no hace falta si se llama igual
	private String title;

	@ManyToOne
	@JoinColumn(name = "idusers") // no hace falta si se llama igual
	private User user;

	@OneToMany
	@JoinColumn(name="id") // no hace falta si se llama igual
	private List<Message> message;

	//Constructores

	public Party() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param title
	 * @param user
	 * @param message
	 */

	public Party(int id, String title, User user, List<Message> message) {
		this.id = id;
		this.title = title;
		this.user = user;
		this.message = message;
	}

	//Getters & Setters


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "messages")
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	//Metodo toString

	@Override
	public String toString() {
		return "Party [id=" + id + ", title=" + title + ", user=" + user + ", message=" + message + "]";
	}
}
