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
	@JoinColumn(name="autLib_codigo")
	@JsonIgnore
	private Libro libro;
	
	@OneToOne
	@JoinColumn(name="libaut_codigo")
	@JsonIgnore
	private Autor autor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
