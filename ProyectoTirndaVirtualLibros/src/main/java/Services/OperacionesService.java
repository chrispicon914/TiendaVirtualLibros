package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import Business.ClienteON;
import Business.FacturaON;
import Business.LibroON;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Libro;





@Path("/Operaciones")
public class OperacionesService {

	@Inject
	private FacturaON facturaON;
	
	@Inject
	private ClienteON clienteON;
	
	@Inject
	private LibroON libroON;
	
	@POST 
	@Path("/createFactura")
	@Produces("application/json")
	@Consumes("application/json")
public  Response insertFactura(Factura factura) {
		
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		
		try {
			facturaON.guardar(factura);
			data.put("codigo", "1");
			data.put("Mensaje: ", "Factura ingresada");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("codigo", "0");
			data.put("Mensaje: ", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		
		return builder.build();
		
		
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
		public List<Factura> getFactura(){
			return facturaON.getListadoFactura();
		}
	
	
	@GET
	@Path("/listarFecha")
	@Produces("application/json")
		public List<Factura> getFacturaFecha(@QueryParam("fecha") String fecha){
				return facturaON.getListadoFacturaFecha(fecha);
		}
	

	@GET
	@Path("/listarClienNombre")
	@Produces("application/json")
		public List<Cliente> getClienteNombre(@QueryParam("nombre") String nombre){
				return clienteON.getListadoClienteNombre(nombre);
		}
	
	@GET
	@Path("/listarClienCedula")
	@Produces("application/json")
		public List<Cliente> getClienteCedula(@QueryParam("cedula") String cedula){
				return clienteON.getListadoClienteCedula(cedula);
		}
	
	@GET
	@Path("/listarCliente")
	@Produces("application/json")
		public List<Cliente> getCliente(){
			return clienteON.getListadoCliente();
		}
	
	@POST 
	@Path("/createCliente")
	@Produces("application/json")
	@Consumes("application/json")
public  Response insertCliente(Cliente cliente) {
		
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		
		try {
			clienteON.guardar(cliente);
			data.put("codigo", "1");
			data.put("Mensaje: ", "Cliente ingresado");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("codigo", "0");
			data.put("Mensaje: ", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		
		return builder.build();
		
		
	}
	
	@GET
	@Path("/logueo")
	@Produces("application/json")
		public String logueo(@QueryParam("correo") String correo, @QueryParam("contrasenia") String contrasenia){
			return clienteON.logueo(correo, contrasenia);
		}
	
	@GET
	@Path("/listarLibro")
	@Produces("application/json")
		public List<Libro> getLibro(){
			return libroON.getListadoLibro();
		}
	
}
