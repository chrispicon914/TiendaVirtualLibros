package DAO;

import java.util.List;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Autor;
import Modelo.Cliente;

/**
 * 
 * @author Cristhian
 *
 */
@Stateless
@Startup
public class AutorDAO {

	@Inject
	private EntityManager em;
	
	public void save(Autor a) {
		if (this.read(a.getCodigo())!=null) {
			this.update(a);
		}else {
			this.create(a);
		}
	}
	
	/**
	 * 
	 * @param a
	 */
	public void create(Autor a) {
		em.persist(a);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Autor read(int id) {
		return em.find(Autor.class, id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Autor read3(int id) {
		String jpql= "SELECT a "
				+"      FROM Autor a "
				+ "        JOIN FETCH d.actividades a "
				+"   WHERE a.codigo = :codigo";
		Query q= em.createQuery(jpql, Cliente.class);
		q.setParameter("codigo", id);
		
		Autor au= (Autor) q.getSingleResult();
		
		return au;
	}
	
	/**
	 * 
	 * @param a
	 */
	public void update(Autor a) {
		em.merge(a);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Autor d=read(id);
		em.remove(d);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Autor> getAutor(){
		String jpql="SELECT a FROM Autor a";
		Query q=em.createQuery(jpql, Autor.class);
		List<Autor> autores=q.getResultList();
		return autores;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Autor> getAutor2(){
		String jpql="SELECT a FROM Autor a";
		Query q=em.createQuery(jpql, Autor.class);
		
		List<Autor> autores=q.getResultList();
		return autores;
	}
	
	/**
	 * 
	 * @param filBusqueda
	 * @return
	 */
	public List<Autor> getBusquedaAutor(String filBusqueda){
		String jpql="SELECT a FROM Autor a "
				    +" WHERE a.nombre LIKE :filtro ";
		Query q=em.createQuery(jpql, Autor.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Autor> autores=q.getResultList();
		System.out.println(autores);
		return autores;
	}
}
