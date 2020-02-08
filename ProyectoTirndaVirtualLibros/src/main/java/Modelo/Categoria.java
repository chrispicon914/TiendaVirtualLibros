package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String categoria;
	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="lib_codigo")   
//	private List<Libro> libros;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String descripcion) {
		this.categoria = descripcion;
	}


//	public List<Libro> getLibros() {
//		return libros;
//	}
//
//
//	public void setLibros(List<Libro> libros) {
//		this.libros = libros;
//	}


//	@Override
//	public String toString() {
//		return "Categoria [id=" + id + ", categoria=" + categoria + ", libros=" + libros + "]";
//	}
//	
	
//	public void addLibros(Libro act) {
//		if (libros==null) {
//			libros=new ArrayList<>();
//		}
//		this.libros.add(act);
//		
//	}
	
}
