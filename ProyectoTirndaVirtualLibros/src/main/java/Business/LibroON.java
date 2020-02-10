package Business;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;




import DAO.AutorDAO;
import DAO.LibroDAO;
import Modelo.Autor;
import Modelo.Libro;

/**
 * 
 * @author Cristhian
 *
 */

@Stateless
public class LibroON {

	
	@Inject
	private LibroDAO dao;
	
	@Inject
	private AutorDAO adao;
	
	private Libro libro;
	
	/**
	 * 
	 * @param l
	 * @throws Exception, guarda la entidad libro recibiendo como parametro al objeto libro
	 */
	
	public String guardarProductoImg(Libro libro) throws IOException {
		String redirect = "";
		System.out.println("llego");
		//System.out.println(producto);
		//System.out.println(file);
		//libro.setImagen(IOUtils.toByteArray(file.getInputstream()));

		dao.create(libro);
		// em.persist(producto);
		return redirect;

	}
	public void guardar(Libro l) throws Exception {
		
		
	
		dao.save(l);
	}
	
	public List<Libro> getListadoLibro(){
		return dao.getLibro();
	}
	
	public List<Libro> getListadoLibroNombre(String nombre){
		return dao.getBusquedaLibro(nombre);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}

public Libro getLibro(int codigo) {
	Libro aux=dao.read(codigo);
	return aux;
 }

public List<Libro> getListadoLibrosAutor(){
	return dao.getLibro();
}

	public List<Autor> getListadoAutorLibros(){
		return adao.getAutor();
	}
	
	public Autor buscarAutor(int codigo) throws Exception {
		try {
			Autor a = adao.read(codigo);
			return a;
		}catch(Exception e) {
			throw new Exception("Código no corresponde a un AUTOR");
		}
	}
}
