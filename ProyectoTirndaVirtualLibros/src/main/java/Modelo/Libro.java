package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Cristhian
 *
 */

@Entity
public class Libro {
	@Id
	@GeneratedValue
	@Column(name="aut_Id")	
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
	@Column(name="lib_anio")
	private int anio;
	
	@NotNull
	@Size(min=3, max=40)
	@Column(name="lib_disponibilidad")
    private String disponibilidad;
	
	@NotNull
	@Column(name="lib_stock")
    private int stock;
	
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="autLib_codigo")
	private List<AutorLibro> autorLib;
	  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="detFac_codigo")
	private List<DetalleFactura> detFac;
    
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

	public List<AutorLibro> getAutorLib() {
		return autorLib;
	}

	public void setAutorLib(List<AutorLibro> autorLib) {
		this.autorLib = autorLib;
	}

//	public List<Cliente> getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}
//
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
	
	
	
	

	public void addAutorLibro(AutorLibro tl) {
		if(this.autorLib==null)
			this.autorLib = new ArrayList<>();
		this.autorLib.add(tl);
		
	}

	public List<DetalleFactura> getDetFac() {
		return detFac;
	}

	public void setDetFac(List<DetalleFactura> detFac) {
		this.detFac = detFac;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", editorial="
				+ editorial + ", anio=" + anio + ", disponibilidad=" + disponibilidad + ", stock=" + stock
				+ ", autorLib=" + autorLib + ", detFac=" + detFac + "]";
	}

	
	
	

	 

	


	
	
	
}
