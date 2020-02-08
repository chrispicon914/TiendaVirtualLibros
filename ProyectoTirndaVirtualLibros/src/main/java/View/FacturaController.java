package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Business.FacturaON;
import Modelo.DetalleFactura;
import Modelo.Factura;

@ManagedBean
@ViewScoped
public class FacturaController {

	private Factura factura= new Factura();
	private List<Factura> listadoFactura;
	private String nom;
	private List<Factura> listadoFacturaFec;
	private DetalleFactura detalle= new DetalleFactura();
	
	@Inject
	private FacturaON fON;
	
		
	@PostConstruct
	public void init() {
		listadoFactura=fON.getListadoFactura();
	}
	
	public String cargarDatos() {
		try {
			fON.guardar(factura);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(int codigo) {
		System.out.println("codigo editar"+codigo);
		//factura=dON.getFactura(codigo);
		System.out.println(factura);
		return "Docente.xhtml";
	}
	
	public String borrar(int codigo) {
		System.out.println("codigo borrar"+codigo);
		try {
			fON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String busqueda()
	{
		System.out.println("Filtro " + factura.getFecha());
		listadoFacturaFec=fON.getListadoFacturaFecha(factura.getFecha());
		fON.getListadoFacturaFecha(factura.getFecha());
		
		return null;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Factura> getListadoFactura() {
		return listadoFactura;
	}

	public void setListadoFactura(List<Factura> listadoFactura) {
		this.listadoFactura = listadoFactura;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Factura> getListadoFacturaFec() {
		return listadoFacturaFec;
	}

	public void setListadoFacturaFec(List<Factura> listadoFacturaFec) {
		this.listadoFacturaFec = listadoFacturaFec;
	}
	
	
	public void addDetalles() {
		factura.addDetalles(new DetalleFactura());
		System.out.println("tele "+factura.getDetalles().size());
	}

	public DetalleFactura getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleFactura detalle) {
		this.detalle = detalle;
	}
	
	
	
}
