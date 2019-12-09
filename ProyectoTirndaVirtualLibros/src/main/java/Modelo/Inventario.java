package Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Inventario {

	@Id
	@Column(name="inv_Id")
	private int id;
	
	@NotNull
	@Size(min=10, max=10)
	@Column(name="inv_descripcion")
	private String descripcion;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="inv_stock")
	private int stock;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="inv_codigo")
	private List<Libro> libros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Inventario [id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + ", libros=" + libros
				+ "]";
	}
	
	
}
