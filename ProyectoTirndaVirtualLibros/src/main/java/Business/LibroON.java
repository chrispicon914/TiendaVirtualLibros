package Business;

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
	
	/**
	 * 
	 * @param l
	 * @throws Exception, guarda la entidad libro recibiendo como parametro al objeto libro
	 */
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
	Libro aux=dao.read3(codigo);
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
