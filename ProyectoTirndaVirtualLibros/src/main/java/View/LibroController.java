package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Business.LibroON;
import Modelo.Libro;

@ManagedBean
@ViewScoped
public class LibroController {

	private Libro libro= new Libro();
	private List<Libro> listadoLibro;
	private String nom;
	private List<Libro> listadoLibroNom;
	
	
	@Inject
	private LibroON dON;
	
	//private Instalacion insON;
	
	@PostConstruct
	public void init() {
		listadoLibro=dON.getListadoLibro();
	}
	
	public String cargarDatos() {
		try {
			dON.guardar(libro);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(int codigo) {
		System.out.println("codigo editar"+codigo);
		libro=dON.getDocente(codigo);
		System.out.println(libro);
		return "Docente.xhtml";
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
		System.out.println("Filtro " + libro.getTitulo());
		listadoLibroNom=dON.getListadoLibroNombre(libro.getTitulo());
		dON.getListadoLibroNombre(libro.getTitulo());
		
		return null;
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setDocente(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getListadoLibro() {
		return listadoLibro;
	}

	public void setListadoLibro(List<Libro> listadoLibro) {
		this.listadoLibro = listadoLibro;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Libro> getListadoLibroNom() {
		return listadoLibroNom;
	}

	public void setListadoDocenteNom(List<Libro> listadoLibroNom) {
		this.listadoLibroNom = listadoLibroNom;
	}
	
	
	public void addActividades() {
		libro.addActividades(new Actividades());
		System.out.println("tele "+libro.getActividades().size());
	}
	
	
}
