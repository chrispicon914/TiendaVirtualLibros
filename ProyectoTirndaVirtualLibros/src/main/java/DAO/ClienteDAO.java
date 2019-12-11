package DAO;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Cliente;

@Stateless
@Startup
public class ClienteDAO {

	@Inject
	private EntityManager em;
	
	public void save(Cliente c) {
		if (this.read(c.getCedula())!=null) {
			this.update(c);
		}else {
			this.create(c);
		}
	}
	
	public void create(Cliente c) {
		em.persist(c);
	}
	
	public Cliente read(String cedula) {
		return em.find(Cliente.class, cedula);
	}
	
	public Cliente read3(String id) {
		String jpql= "SELECT c "
				+"      FROM Cliente c "
				+"   WHERE c.cedula = :codigo";
		Query q= em.createQuery(jpql, Cliente.class);
		q.setParameter("codigo", id);
		
		Cliente d= (Cliente) q.getSingleResult();
		
		return d;
	}
	
	public void update(Cliente c) {
		em.merge(c);
	}
	
	public void delete(String id) {
		Cliente d=read(id);
		em.remove(d);
	}
	
	public List<Cliente> getCliente(){
		String jpql="SELECT c FROM Cliente c";
		Query q=em.createQuery(jpql, Cliente.class);
		
		List<Cliente> clientes=q.getResultList();
		/*
		 * for(Cliente d: clientes) d.getActividades().size();
		 */
		return clientes;
	}
	
	public List<Cliente> getCliente2(){
		String jpql="SELECT c FROM Cliente c";
		Query q=em.createQuery(jpql, Cliente.class);
		
		List<Cliente> docentes=q.getResultList();
		return docentes;
	}
	
	public List<Cliente> getBusquedaCliente(String filBusqueda){
		String jpql="SELECT c FROM Cliente c "
				    +" WHERE c.nombre LIKE :filtro ";
		Query q=em.createQuery(jpql, Cliente.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Cliente> clientes=q.getResultList();
		System.out.println(clientes);
		return clientes;
	}
	
	
	public String logueo(String correo, String contrasenia) {
		
		String ban="";
		String jplq= "select c from Cliente c where c.correo= :correo and c.contrasenia = :contrasenia";
		Query q= em.createQuery(jplq, Cliente.class);
		q.setParameter("correo", correo);
		q.setParameter("contrasenia", contrasenia);
		
		try {
			Cliente cli=  (Cliente) q.getSingleResult();
			if (cli != null) {
				if (cli.isPermisoAdministrador()) {
					ban="admin";
				}else {
					ban="cliente";
				}
			}else {
				ban="Datos Incorrectos";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ban;
	}
		
	
}
