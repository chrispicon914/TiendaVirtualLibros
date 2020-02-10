package View;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import Business.LibroON;
import Modelo.Autor;
import Modelo.AutorLibro;
import Modelo.Libro;

/**
 * 
 * @author Cristhian
 *
 */
@ManagedBean
@ViewScoped
public class LibroController {

	private Part file;
	private Libro libro=new Libro();
	private List<Libro> listadoLibro;
	private List<Libro> listadoLibroNom;
	
		
	@Inject
	private LibroON dON;
			
	@PostConstruct
	public void init() {
		
		listadoLibro=dON.getListadoLibro();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String cargarDatos() {
		try {
			//dON.gu1=ardar(libro);
			if(file != null) {
				int size = (int) file.getSize();
				byte[] foto;
				if(size > 0) {
					foto = new byte[size];
					file.getInputStream().read(foto);
					libro.setImagen(foto);
				}
			}
			dON.guardarProductoImg(libro);
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
		libro=dON.getLibro(codigo);
		System.out.println(libro);
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


	public List<Libro> getListadoLibroNom() {
		return listadoLibroNom;
	}

	public void setListadoDocenteNom(List<Libro> listadoLibroNom) {
		this.listadoLibroNom = listadoLibroNom;
	}
	
	/**
	 * 
	 * @param tl
	 * @return
	 */
	public String buscarAutor(AutorLibro tl) {
		System.out.println("buscando autor " + tl);
		try {
			
			Autor at = dON.buscarAutor(tl.getTemporal());
			
			System.out.println(at);
			tl.setAutor(at);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * @return the file
	 */
	public Part getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(Part file) {
		this.file = file;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @param listadoLibroNom the listadoLibroNom to set
	 */
	public void setListadoLibroNom(List<Libro> listadoLibroNom) {
		this.listadoLibroNom = listadoLibroNom;
	}

	/**
	 * 
	 * @return
	 */
	public String addAutor() {
		System.out.println("add autor");
		libro.addAutorLibro(new AutorLibro());
		return null;
	}
	
}
