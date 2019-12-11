package View;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import Business.ClienteON;

@ManagedBean
public class LoginController {

	private String correo;
	private String contrasenia;
	private String mensaje;
	
	@Inject
	private ClienteON cON;
	
	@PostConstruct
	private void init() {
		correo= new String();
		contrasenia= new String();
		mensaje=  new String();
	}
	
	public String login() {
		mensaje= cON.logueo(correo, contrasenia);
		System.out.println("funciona");
		return "ListarCategoria";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
