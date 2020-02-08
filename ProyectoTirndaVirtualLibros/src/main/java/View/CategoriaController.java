package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import Business.CategoriaON;
import Modelo.Categoria;
import Modelo.Libro;

/**
 * 
 * @author Cristhian
 *
 */
@ManagedBean
@ViewScoped
public class CategoriaController {

	private Categoria categoria= new Categoria();
	private List<Categoria> listadoCategoria;
	private String nom;
	private List<Categoria> listadoCategoriaNom;
	
	
	@Inject
	private CategoriaON dON;
	
		
	@PostConstruct
	public void init() {
		listadoCategoria=dON.getListadoCategoria();
	}
	
	/**
	 * 
	 * @return
	 */
	public String cargarDatos() {
		try {
			dON.guardar(categoria);
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
		categoria=dON.getCategoria(codigo);
		System.out.println(categoria);
		return "Libro.xhtml";
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
			//init();
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * Realiza la búsqueda de una categoria
	 */
	public String busqueda()
	{
		System.out.println("Filtro " + categoria.getCategoria());
		listadoCategoriaNom=dON.getListadoCategoriaNombre(categoria.getCategoria());
		dON.getListadoCategoriaNombre(categoria.getCategoria());
		
		return null;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListadoCategoria() {
		return listadoCategoria;
	}

	public void setListadoCateforia(List<Categoria> listadoCategoria) {
		this.listadoCategoria = listadoCategoria;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Categoria> getListadoCategoriaNom() {
		return listadoCategoriaNom;
	}

	public void setListadoDocenteNom(List<Categoria> listadoCategoriaNom) {
		this.listadoCategoriaNom = listadoCategoriaNom;
	}
	

	 
	
}
