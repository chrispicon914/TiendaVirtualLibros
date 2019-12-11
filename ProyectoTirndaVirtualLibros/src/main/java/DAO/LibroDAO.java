package DAO;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Modelo.Libro;

/**
 * 
 * @author Cristhian
 *
 */
@Stateless
@Startup
public class LibroDAO {

	@Inject
	private EntityManager em;
	
	public void save(Libro l) {
		if (this.read(l.getCodigo())!=null) {
			this.update(l);
		}else {
			this.create(l);
		}
	}
	
	/**
	 * 
	 * @param l
	 */
	public void create(Libro l) {
		em.persist(l);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Libro read(int id) {
		return em.find(Libro.class, id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Libro read3(int id) {
		String jpql= "SELECT l "
				+"      FROM Libro l "
				+ "        JOIN FETCH l.actividades a "
				+"   WHERE c.cedula = :codigo";
		Query q= em.createQuery(jpql, Libro.class);
		q.setParameter("codigo", id);
		
		Libro d= (Libro) q.getSingleResult();
		
		return d;
	}
	
	/**
	 * 
	 * @param l
	 */
	public void update(Libro l) {
		em.merge(l);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Libro d=read(id);
		em.remove(d);
	}
	/**
	 * 
	 * @return
	 */
	
	public List<Libro> getLibro(){
		String jpql="SELECT l FROM Libro l";
		Query q=em.createQuery(jpql, Libro.class);
		
		List<Libro> libros=q.getResultList();
		/*
		 * for(Libro d: libros) d.getActividades().size();
		 */
		return libros;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Libro> getLibro2(){
		String jpql="SELECT l FROM Libro l";
		Query q=em.createQuery(jpql, Libro.class);
		
		List<Libro> libros=q.getResultList();
		return libros;
	}
	
	/**
	 * 
	 * @param filBusqueda
	 * @return
	 */
	public List<Libro> getBusquedaLibro(String filBusqueda){
		String jpql="SELECT l FROM Libro l "
				    +" WHERE l.titulo LIKE :filtro ";
		Query q=em.createQuery(jpql, Libro.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Libro> libros=q.getResultList();
		System.out.println(libros);
		return libros;
	}
	
	
}
