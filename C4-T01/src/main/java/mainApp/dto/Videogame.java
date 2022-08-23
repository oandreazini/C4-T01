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
@Table(name = "videogames") // en caso que la tabla sea diferente
public class Videogame {

	// Atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@Column(name = "title") // no hace falta si se llama igual
	private String title;

	@ManyToOne
	@JoinColumn(name = "idgames") // no hace falta si se llama igual
	private Game game;

	//Constructores

	public Videogame() {

	}

	/**
	 * 
	 * @param id
	 * @param title
	 * @param game
	 */
	public Videogame(int id, String title, Game game) {
		this.id = id;
		this.title = title;
		this.game = game;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	//Metodo toString

	@Override
	public String toString() {
		return "Videogame [id=" + id + ", title=" + title + ", game=" + game + "]";
	}

}
