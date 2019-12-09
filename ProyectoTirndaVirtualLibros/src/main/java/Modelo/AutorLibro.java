package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AutorLibro {

	@Id
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="LibAut_codigo")
	@JsonIgnore
	private Libro libro;
	
	@OneToOne
	@JoinColumn(name="autLib_codigo")
	@JsonIgnore
	private Autor autor;
}
