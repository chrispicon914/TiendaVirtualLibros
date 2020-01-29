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
/**
 * 
 * @author Cristhian
 *Creación de tabla cliente
 */
@Entity
public class Cliente {
	@Id
	@Column(name="aut_Id")
	private String cedula;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Nombre")
	private String nombre;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Apellido")
	private String apellido;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Direccion")
	private String direccion;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_correo")
	private String correo;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_contrasenia")
	private String contrasenia;
	

	private boolean permisoAdministrador;
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isPermisoAdministrador() {
		return permisoAdministrador;
	}

	

	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", correo=" + correo + ", contrasenia=" + contrasenia + ", permisoAdministrador="
				+ permisoAdministrador + "]";
	}

	



	
	
}
