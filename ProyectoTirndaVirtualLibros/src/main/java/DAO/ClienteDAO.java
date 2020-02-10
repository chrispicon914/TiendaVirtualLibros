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
		if (this.read(c.getId())!= null) {
			this.update(c);
		}else {
			this.create(c);
		}
	}
	
	public List<Object[]> validadFacturaa(int id) {
		//String jpql = "SELECT c, f FROM Cliente c, Factura f JOIN FETCH c.facturas where id = :id";
		//SELECT u FROM User u LEFT JOIN u.addresses a WHERE u.id = a.user
		String open = "open";
		//String jpql = "SELECT c FROM Cliente c  JOIN FETCH c.facturas f where c.id = :id and f.estadoCarrito like 'open' ";
		String jpql = "SELECT c.id, c.nombre, f.codigo, l.titulo, f.total, d.cantidad FROM cliente C, factura f, detallefactura d, libro l WHERE  c.id = :id  and f.estadoCarrito like 'open' ";
		//Query query = em.createQuery(jpql, Cliente.class);
		Query query = em.createNativeQuery(jpql);
		query.setParameter("id", id);
		List<Object[]> cli =  query.getResultList();
		for (Object[] object: cli) {
			System.out.println(object[0]);
			System.out.println(object[1]);
			System.out.println(object[2]);
		}
				
		return cli;
	}

	
	public void create(Cliente c) {
		em.persist(c);
	}
	
	public Cliente read(int id) {
		return em.find(Cliente.class, id);
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
	
	public void delete(int id) {
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
	
	public List<Cliente> getBusquedaCedulaCliente(String filBusqueda){
		String jpql="SELECT c FROM Cliente c "
				    +" WHERE c.cedula LIKE :filtro ";
		Query q=em.createQuery(jpql, Cliente.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Cliente> clientes=q.getResultList();
		System.out.println(clientes);
		return clientes;
	}
	
	public Cliente logueo(String correo, String contrasenia) {
		Cliente clie=null;
		String jplq= "select c from Cliente c where c.correo= :correo and c.contrasenia = :contrasenia";
		Query q= em.createQuery(jplq, Cliente.class);
		q.setParameter("correo", correo);
		q.setParameter("contrasenia", contrasenia);
		
			List<Cliente> cli=  q.getResultList();
			System.out.println("correo " +cli);
			
			if (cli.isEmpty()) {
				clie=cli.get(0);
			}else {
				clie=null;
			}
		
		
		return clie;
	}
		
	
}
