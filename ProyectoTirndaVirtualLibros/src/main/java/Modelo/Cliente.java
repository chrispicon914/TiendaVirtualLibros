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
public class Cliente {
	@Id
	@Column(name="aut_Id")
	private String cedula;
	
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
	private String direccion;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="aut_Apellido")
	private String correo;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="aut_codigo")
	private List<Libro> libros;
}
