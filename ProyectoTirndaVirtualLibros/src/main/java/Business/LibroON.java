package Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import DAO.LibroDAO;
import Modelo.Libro;

@Stateless
public class LibroON {

	@Inject
	private LibroDAO dao;
	
	
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

public Libro getDocente(int codigo) {
	Libro aux=dao.read3(codigo);
	return aux;
 }
}
