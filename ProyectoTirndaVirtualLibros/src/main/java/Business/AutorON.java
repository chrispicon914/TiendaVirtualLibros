package Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import DAO.AutorDAO;
import Modelo.Autor;


@Stateless
public class AutorON {

	@Inject
	private AutorDAO adao;
	
	
	public void guardar(Autor a) throws Exception {
	
		
		adao.save(a);
	}
	
	public List<Autor> getListadoAutor(){
		return adao.getAutor();
	}
	
	public List<Autor> getListadoAutorNombre(String nombre){
		return adao.getBusquedaAutor(nombre);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			adao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}

public Autor getAutor(int codigo) {
	Autor aux=adao.read3(codigo);
	return aux;
 }
}
