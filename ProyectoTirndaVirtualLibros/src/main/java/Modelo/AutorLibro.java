package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * 
 * @author Cristhian
 *
 */

@Entity
public class AutorLibro {

	@Id
    @GeneratedValue
	private int codigo;
	
	@ManyToOne
	private Libro libro;
	
	@ManyToOne
	private Autor autor;
	
	@Transient
	private int temporal;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getTemporal() {
		return temporal;
	}

	public void setTemporal(int temporal) {
		this.temporal = temporal;
	}

	@Override
	public String toString() {
		return "AutorLibro [codigo=" + codigo +  ", autor=" + autor + "]";
	}
	
	
}
