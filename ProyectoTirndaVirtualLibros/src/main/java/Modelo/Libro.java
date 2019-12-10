package Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Libro {
	@Id
	private int codigo;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_Titulo")
	private String titulo;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_descripcion")
	private String descripcion;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_editorial")
    private String editorial;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_anio")
	private int anio;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_disponibilidad")
    private String disponibilidad;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_stock")
    private int stock;
		
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="autLib_codigo")
	private List<AutorLibro> autorLib;
	  
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cli_codigo")   
	private List<Cliente> cliente;
	
  
	@OneToOne
	@JoinColumn(name="cat_codigo")
	@JsonIgnore
	private Categoria categoria;
	  
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

	

	 

	


	
	
	
}
