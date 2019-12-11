package DAO;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Modelo.Categoria;


@Stateless
@Startup
public class CategoriaDAO {

	@Inject
	private EntityManager em;
	
	public void save(Categoria c) {
		if (this.read(c.getId())!=null) {
			this.update(c);
		}else {
			this.create(c);
		}
	}
	
	public void create(Categoria c) {
		em.persist(c);
	}
	
	public Categoria read(int id) {
		return em.find(Categoria.class, id);
	}
	
	public Categoria read3(int id) {

		String jpql= "SELECT c FROM Categoria c JOIN FETCH c.libros WHERE c.id = :codigo";
		Query q= em.createQuery(jpql, Categoria.class);
		q.setParameter("codigo", id);
		
		Categoria c= (Categoria) q.getSingleResult();
		
		return c;
	}
	
	public void update(Categoria c) {
		em.merge(c);
	}
	
	public void delete(int id) {
		Categoria d=read(id);
		em.remove(d);
	}
	
	public List<Categoria> getCategoria(){
		String jpql="SELECT c FROM Categoria c";
		Query q=em.createQuery(jpql, Categoria.class);
		
		List<Categoria> categorias=q.getResultList();
		
		  for(Categoria c: categorias) 
			  c.getLibros().size();
		 
		return categorias;
	}
	
	public List<Categoria> getCategoria2(){
		String jpql="SELECT c FROM Categoria c";
		Query q=em.createQuery(jpql, Categoria.class);
		
		List<Categoria> categorias=q.getResultList();
		return categorias;
	}
	
	public List<Categoria> getBusquedaCategoria(String filBusqueda){
		String jpql="SELECT c FROM Categoria c "
				    +" WHERE c.categoria LIKE :filtro ";
		Query q=em.createQuery(jpql, Categoria.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Categoria> categorias=q.getResultList();
		System.out.println(categorias);
		return categorias;
	}
}
