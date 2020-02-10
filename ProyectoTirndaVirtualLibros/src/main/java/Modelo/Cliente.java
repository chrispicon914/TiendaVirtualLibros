package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=3, max=40)
	private String nombre;
	
	@NotNull
	@Size(min=3, max=40)
	private String apellido;
	
	@NotNull
	@Size(min=3, max=40)
	private String direccion;
	
	@NotNull
	@Size(min=3, max=40)
	private String correo;
	
	@NotNull
	@Size(min=3, max=40)
	private String contrasenia;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Factura> facturas;

	private boolean permisoAdministrador;
	
	public void agregarFactura(Factura factura) {
		if(facturas == null) {
			facturas = new ArrayList<Factura>();
		}
		facturas.add(factura);
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

	

	/**
	 * @param permisoAdministrador the permisoAdministrador to set
	 */
	public void setPermisoAdministrador(boolean permisoAdministrador) {
		this.permisoAdministrador = permisoAdministrador;
	}


	/**
	 * @return the facturas
	 */
	public List<Factura> getFacturas() {
		return facturas;
	}


	/**
	 * @param facturas the facturas to set
	 */
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Cliente [c, nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", correo=" + correo + ", contrasenia=" + contrasenia + ", permisoAdministrador="
				+ permisoAdministrador + "]";
	}

	



	
	
}
