package ec.edu.ups.ppwd63.Prueba.dao;

import java.util.List;

import ec.edu.ups.ppwd63.Prueba.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public void remove(int codigo) {
		Persona persona = em.find(Persona.class, codigo);
		em.remove(persona);
	}
	
	public Persona read(int codigo) {
		Persona persona = em.find(Persona.class, codigo);
		return persona;
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Persona.class);
		return q.getResultList();
	}
	
	public Persona getClientePorCedula(String cedula){
		String jpql = "SELECT c FROM Cliente c WHERE c.cedula = :cedula";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter("cedula", cedula);
		List<Persona> personas = q.getResultList();
		if(personas.size()>0)
			return personas.get(0);
		return null;
	}

}
