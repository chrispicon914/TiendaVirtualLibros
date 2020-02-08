package View;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import DAO.LibroDAO;
import Modelo.Libro;




@Named
@ApplicationScoped
public class ImageBean {
	
	private Libro foto;
	
	@EJB
	private LibroDAO service;
	
	public byte[] getBytes(int id) {
		foto= service.buscarFoto(id);
		return foto.getImagen();
	}

}
