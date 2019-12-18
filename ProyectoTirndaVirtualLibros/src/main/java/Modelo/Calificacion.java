package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Calificacion {

	@Id
	private int codigo;
	private int caantidadVotos;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCaantidadVotos() {
		return caantidadVotos;
	}
	public void setCaantidadVotos(int caantidadVotos) {
		this.caantidadVotos = caantidadVotos;
	}
	@Override
	public String toString() {
		return "Calificacion [codigo=" + codigo + ", caantidadVotos=" + caantidadVotos + "]";
	}
	
	
}
