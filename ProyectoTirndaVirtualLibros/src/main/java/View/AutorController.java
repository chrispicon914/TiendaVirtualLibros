package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import Business.AutorON;
import Modelo.Autor;

/**
 * 
 * @author Cristhian
 *
 */
@ManagedBean
@ViewScoped
public class AutorController {

	private Autor autores= new Autor();
	private List<Autor> listadoAutor;
	private String nom;
	private List<Autor> listadoAutorNom;
	
	
	@Inject
	private AutorON dON;
	
	//private Instalacion insON;
	
	@PostConstruct
	public void init() {
		listadoAutor=dON.getListadoAutor();
	}
	
	/**
	 * 
	 * @return
	 */
	public String cargarDatos() {
		try {
			dON.guardar(autores);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public String editar(int codigo) {
		System.out.println("codigo editar"+codigo);
		autores=dON.getAutor(codigo);
		System.out.println(autores);
		return "Docente.xhtml";
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
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

	/**
	 * 
	 * @return
	 */
	public String busqueda()
	{
		System.out.println("Filtro " + autores.getNombre());
		listadoAutorNom=dON.getListadoAutorNombre(autores.getNombre());
		dON.getListadoAutorNombre(autores.getNombre());
		
		return null;
	}
	
	/**
	 */
	public Autor getAutores() {
		return autores;
	}

	public void setAutor(Autor autores) {
		this.autores = autores;
	}

	public List<Autor> getListadoAutor() {
		return listadoAutor;
	}

	public void setListadoAutor(List<Autor> listadoAutor) {
		this.listadoAutor = listadoAutor;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Autor> getListadoAutorNom() {
		return listadoAutorNom;
	}

	public void setListadoAutorNom(List<Autor> listadoAutorNom) {
		this.listadoAutorNom = listadoAutorNom;
	}
	
	
	
	
}
