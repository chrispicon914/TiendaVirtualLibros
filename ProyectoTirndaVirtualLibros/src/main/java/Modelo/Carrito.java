package Modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Carrito {

	private int codigo;
	
	private double valorTotal;
	private int codCliente;
	private int codProducto;
	
	private List<Libro> pro;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the codCliente
	 */
	public int getCodCliente() {
		return codCliente;
	}
	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	/**
	 * @return the codProducto
	 */
	public int getCodProducto() {
		return codProducto;
	}
	/**
	 * @param codProducto the codProducto to set
	 */
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	/**
	 * @return the pro
	 */
	public List<Libro> getPro() {
		return pro;
	}
	/**
	 * @param pro the pro to set
	 */
	public void setPro(List<Libro> pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "Carrito [codigo=" + codigo + ", valorTotal=" + valorTotal + ", codCliente=" + codCliente
				+ ", codProducto=" + codProducto + ", pro=" + pro + "]";
	}
	
	
	
	
}
