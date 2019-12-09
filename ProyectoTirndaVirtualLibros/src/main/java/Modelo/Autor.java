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
public class Autor {
	@Id
	@Column(name="aut_Id")
	private int codigo;
	
	@NotNull
	@Size(min=10, max=10)
	@Column(name="aut_Cedula")
	private String nombre;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Nombre")
	private String apellido;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Apellido")
	private String nacionalidad;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="autLib_codigo")
	private List<Libro> autLibros;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public List<Libro> getAutLibros() {
		return autLibros;
	}


	public void setAutLibros(List<Libro> autLibros) {
		this.autLibros = autLibros;
	}


	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad="
				+ nacionalidad + ", autLibros=" + autLibros + "]";
	}


	   
	
	
}
