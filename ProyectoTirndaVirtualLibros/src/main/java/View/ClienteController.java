package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import Business.ClienteON;
import Modelo.Cliente;


@ManagedBean
@ViewScoped
public class ClienteController {

	private Cliente cliente= new Cliente();
	private List<Cliente> listadoCliente;
	private String nom;
	private List<Cliente> listadoClienteNom;
	
	
	@Inject
	private ClienteON dON;
	
	
	@PostConstruct
	public void init() {
		listadoCliente=dON.getListadoCliente();
	}
	
	public String cargarDatos() {
		try {
			dON.guardar(cliente);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(String codigo) {
		System.out.println("codigo editar"+codigo);
		cliente=dON.getCliente(codigo);
		System.out.println(cliente);
		return "Libro.xhtml";
	}
	
	public String borrar(int codigo) {
		System.out.println("codigo borrar"+codigo);
		try {
			dON.borrar(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String busqueda()
	{
		System.out.println("Filtro " + cliente.getNombre());
		listadoClienteNom=dON.getListadoClienteNombre(cliente.getNombre());
		dON.getListadoClienteNombre(cliente.getNombre());
		
		return null;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(List<Cliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Cliente> getListadoClienteNom() {
		return listadoClienteNom;
	}

	public void setListadoClienteNom(List<Cliente> listadoClienteNom) {
		this.listadoClienteNom = listadoClienteNom;
	}
		
}
