package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Libro {
	@Id
	private int codigo;
	
	private String titulo;
	private String descripcion;
    private String editorial;
	private int anio;
    private String disponibilidad;
    private int stock;
		
	
	  @OneToOne
	  @JoinColumn(name="LibAut_codigo")
	  @JsonIgnore
	  private AutorLibro autorLib;
	  
	 	  	  
	  @OneToOne
	   @JoinColumn(name="cli_codigo")
	  @JsonIgnore
	  private Cliente cliente;
	 
	@Transient
	private int idTipo;
	
	@Transient
	private int idDocenteTemp;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", editorial="
				+ editorial + ", anio=" + anio + ", disponibilidad=" + disponibilidad + ", stock=" + stock + "]";
	}

	

	/*
	 * public Autor getAutor() { return autor; }
	 * 
	 * public void setAutor(Autor autor) { this.autor = autor; }
	 * 
	 * 
	 * 
	 * public Inventario getInventario() { return inventario; }
	 * 
	 * public void setInventario(Inventario inventario) { this.inventario =
	 * inventario; }
	 * 
	 * public Cliente getCliente() { return cliente; }
	 * 
	 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
	 */

	


	
	
	
}
