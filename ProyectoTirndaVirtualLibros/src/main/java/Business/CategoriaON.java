package Business;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import DAO.CategoriaDAO;
import Modelo.Categoria;


@Stateless
public class CategoriaON {

	@Inject
	private CategoriaDAO cdao;
	
	
	public void guardar(Categoria c) throws Exception {
	
		
		cdao.save(c);
	}
	
	public List<Categoria> getListadoCategoria(){
		return cdao.getCategoria2();
	}
	
	public List<Categoria> getListadoCategoriaNombre(String nombre){
		return cdao.getBusquedaCategoria(nombre);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			cdao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}

	
public Categoria getCategoria(int codigo) {
	Categoria aux=cdao.read3(codigo);
	return aux;
 }

}
