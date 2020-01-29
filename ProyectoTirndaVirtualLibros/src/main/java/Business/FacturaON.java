package Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import DAO.AutorDAO;
import DAO.FacturaDAO;
import DAO.LibroDAO;
import Modelo.Autor;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Libro;

@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO dao;
		
	public void guardar(Factura f) {
			
		dao.save(f);
	}
	
	public List<Factura> getListadoFactura(){
		return dao.getFactura();
	}
	
	public List<Factura> getListadoFacturaFecha(String fecha){
		
		return dao.getBusquedaFactura(fecha);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}

public Factura getFactura(int codigo) {
	Factura aux=dao.read3(codigo);
	return aux;
 }
}
