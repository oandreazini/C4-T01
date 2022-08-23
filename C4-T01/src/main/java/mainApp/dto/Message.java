package mainApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages") // en caso que la tabla sea diferente
public class Message {

	// Atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@Column(name="shipping")// no hace falta si se llama igual
	private String shipping;

	@Column(name="text")// no hace falta si se llama igual
	private String text;

	@ManyToOne
	@JoinColumn(name = "idpartys") // no hace falta si se llama igual
	private Party party;

	@ManyToOne
	@JoinColumn(name = "idusers") // no hace falta si se llama igual
	private User user;

	//Constructores
	public Message() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param shipping
	 * @param text
	 * @param party
	 * @param user
	 */
	public Message(int id, String shipping, String text, Party party, User user) {
		this.id = id;
		this.shipping = shipping;
		this.text = text;
		this.party = party;
		this.user = user;
	}

	//Getters & Setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getShipping() {
		return shipping;
	}


	public void setShipping(String shipping) {
		this.shipping = shipping;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Party getParty() {
		return party;
	}


	public void setParty(Party party) {
		this.party = party;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	//Metodo toString

	@Override
	public String toString() {
		return "Message [id=" + id + ", shipping=" + shipping + ", text=" + text + ", party=" + party + ", user="
				+ user + "]";
	}

}
