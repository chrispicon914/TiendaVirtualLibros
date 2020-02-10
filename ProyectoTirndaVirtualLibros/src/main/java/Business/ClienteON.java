package Business;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import DAO.ClienteDAO;
import Modelo.Cliente;

@Stateless
public class ClienteON {
	@Inject
	private ClienteDAO cdao;
	
	
	public void guardar(Cliente c) throws Exception {
	
		
		cdao.save(c);
	}
	
	public List<Cliente> getListadoCliente(){
		return cdao.getCliente();
	}
	
	public List<Cliente> getListadoClienteNombre(String nombre){
		return cdao.getBusquedaCliente(nombre);
	}
	
	public List<Cliente> getListadoClienteCedula(String cedula){
		return cdao.getBusquedaCedulaCliente(cedula);
	}
	
	public void borrar(int codigo ) throws Exception {
		try {
			cdao.delete(codigo);
		} catch (Exception  e) {
			throw new  Exception("Error al borrar "+e.getMessage());
		}
	}
	
	public List<Object[]> validarFactura(int id) {
		return cdao.validadFacturaa(id);
	}

public Cliente getCliente(String codigo) {
	Cliente aux=cdao.read3(codigo);
	return aux;
 }

public Cliente logueo(String correo, String contrasenia) {
	return cdao.logueo(correo, contrasenia);
}

}
