package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DetalleFactura {

	@Id
	private int codigo;
	private String descripcion;
	private int cantidad;
	private double precioUnitario;
	private double precioTotal;
	
	@OneToOne
	@JoinColumn(name="detFac_codigo")
	@JsonIgnore
	private Libro libro;

	@OneToOne
	@JoinColumn(name="detFact_codigo")
	@JsonIgnore
	private Factura factura;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "DetalleFactura [codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + ", libro=" + libro + "]";
	}
	
	
	
	
}
