package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	private int codigo;
	private String fecha;
	private double subtotal;
	private double iva;
	private double descuento;
	private double costoEnvio;
	private double total;
	private String estadoCarrito;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="detFact_codigo")
	private List<DetalleFactura> detalles;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getCostoEnvio() {
		return costoEnvio;
	}
	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEstadoCarrito() {
		return estadoCarrito;
	}
	public void setEstadoCarrito(String estadoCarrito) {
		this.estadoCarrito = estadoCarrito;
	}
	
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", descuento=" + descuento + ", costoEnvio=" + costoEnvio + ", total=" + total + ", estadoCarrito="
				+ estadoCarrito + ", detalles=" + detalles + "]";
	}
	
	
	public void addDetalles(DetalleFactura act) {
		if (detalles==null) {
			detalles=new ArrayList<>();
		}
		this.detalles.add(act);
		
	}
}
