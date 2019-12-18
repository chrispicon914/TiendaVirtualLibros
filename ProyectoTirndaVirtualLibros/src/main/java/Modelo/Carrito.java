package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrito {

	@Id
	private int codigo;
	private double valorTotal;
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
	@Override
	public String toString() {
		return "Carrito [codigo=" + codigo + ", valorTotal=" + valorTotal + "]";
	}
	
	
}
