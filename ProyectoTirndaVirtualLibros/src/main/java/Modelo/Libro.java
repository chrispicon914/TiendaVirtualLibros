package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private int codigo;
	
	@NotNull
	@Size(min=3, max=40)
	private String titulo;
	
	@NotNull
	@Size(min=3, max=40)
	private String descripcion;
	
	@NotNull
	@Size(min=3, max=40)
    private String editorial;
	
	@NotNull
	private int anio;
	
	@NotNull
	@Size(min=3, max=40)
    private String disponibilidad;
	
	@NotNull
	    private int stock;
	
	@NotNull
	private double precioVenta;
	
	@Lob
	private byte[] imagen;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="autLib_codigo")
	private List<AutorLibro> autorLib;
	  
    @OneToOne
	private DetalleFactura detFac;
    
    @OneToOne
    private Categoria categoria;
//    
//    @OneToOne
//    private Carrito carrito;
    
    @OneToOne
    private Voto calificacion;
    
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

	public DetalleFactura getDetFac() {
		return detFac;
	}

	public void setDetFac(DetalleFactura detFac) {
		this.detFac = detFac;
	}

	/**
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", editorial="
				+ editorial + ", anio=" + anio + ", disponibilidad=" + disponibilidad + ", stock=" + stock
				+ ", precioVenta=" + precioVenta + ", imagen=" + Arrays.toString(imagen) + ", autorLib=" + autorLib
				+ ", detFac=" + detFac + ", categoria=" + categoria + ", , calificacion="
				+ calificacion + "]";
	}

	
}
