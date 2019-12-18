package DAO;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Factura;
import Modelo.Libro;

@Stateless
@Startup
public class FacturaDAO {

	@Inject
	private EntityManager em;
	
	public void save(Factura f) {
		if (this.read(f.getCodigo())!=null) {
			this.update(f);
		}else {
			this.create(f);
			
		}
	}
	
	public void create(Factura d) {
		em.persist(d);
	}
	
	public Factura read(int id) {
		return em.find(Factura.class, id);
	}
	
	public Factura read3(int id) {
		String jpql= "SELECT f "
				+"      FROM Factura f "
				+ "        JOIN FETCH f.detalles d "
				+"   WHERE f.codigo = :codigo";
		Query q= em.createQuery(jpql, Factura.class);
		q.setParameter("codigo", id);
		
		Factura d= (Factura) q.getSingleResult();
		
		return d;
	}
	
	public void update(Factura d) {
		em.merge(d);
	}
	
	public void delete(int id) {
		Factura d=read(id);
		em.remove(d);
	}
	
	public List<Factura> getFactura(){
		String jpql="SELECT f FROM Factura f";
		Query q=em.createQuery(jpql, Factura.class);
		
		List<Factura> facturas=q.getResultList();
		for(Factura f: facturas)
			f.getDetalles().size();
		return facturas;
	}
	
	public List<Factura> getDocente2(){
		String jpql="SELECT f FROM Factura f";
		Query q=em.createQuery(jpql, Factura.class);
		
		List<Factura> facturas=q.getResultList();
		return facturas;
	}
	
	public List<Factura> getBusquedaFactura(String filBusqueda){
		String jpql="SELECT f FROM Factura f "
				    +" WHERE f.fecha LIKE :filtro ";
		Query q=em.createQuery(jpql, Factura.class);
		q.setParameter("filtro", "%"+filBusqueda+"%");
		
		List<Factura> facturas=q.getResultList();
		System.out.println(facturas);
		return facturas;
	}
	
	private  int codigo() {
		
            
            String pB = "SELECT codigo FROM Factura";
           
            Query q=em.createQuery(pB, Factura.class);
           System.out.println("id "+pB);
           
           return Integer.valueOf(pB);
       }
}