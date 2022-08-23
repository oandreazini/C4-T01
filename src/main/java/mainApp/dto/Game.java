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
@Table(name = "games") // en caso que la tabla sea diferente
public class Game {

	// Atributos de entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "name") // no hace falta si se llama igual
	private String name;
	
	@Column(name = "description") // no hace falta si se llama igual
	private String description;

	@OneToMany
	@JoinColumn(name="id")
	private List<Videogame> videogame;

	//Constructores
	public Game() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param videogame
	 */
	public Game(int id, String name, String description, List<Videogame> videogame) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.videogame = videogame;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "videogames")
	public List<Videogame> getVideogame() {
		return videogame;
	}

	public void setVideogame(List<Videogame> videogame) {
		this.videogame = videogame;
	}

	//Metodo toString
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", videogame=" + videogame + "]";
	}

}
