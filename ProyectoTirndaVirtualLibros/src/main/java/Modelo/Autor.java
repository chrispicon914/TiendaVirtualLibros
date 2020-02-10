package Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author Cristhian
 * Inserta la entidad autor a la base de datos
 */
@Entity
public class Autor {
	@Id
	@GeneratedValue
	private int codigo;
	
	@NotNull
	@Size(min=3, max=40)
	private String nombre;
	
	@NotNull
	@Size(min=3, max=40)
	private String apellido;
	
	@NotNull
	@Size(min=3, max=40)
	private String nacionalidad;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AutorLibro> autLibros;

	
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

	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad="
				+ nacionalidad + "]";
	}


	public List<AutorLibro> getAutLibros() {
		return autLibros;
	}

	public void setAutLibros(List<AutorLibro> autLibros) {
		this.autLibros = autLibros;
	}


	   
	
	
}
