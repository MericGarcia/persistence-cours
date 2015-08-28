package fr.keyconsulting.formation.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.service.PersistenceService;

public class ORMPersistenceService implements PersistenceService{

	private static final String PERSISTENCE_UNIT_NAME = "model";
	private EntityManagerFactory factory;
	private EntityManager em;

	public ORMPersistenceService() {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em = factory.createEntityManager();
	}

	@Override
	public void persist(Calcul calcul) {
		em.getTransaction().begin();
		/*
		 * Use entitymanager to persist the new calcul
		 * 
		 * */
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Calcul> load() {	
		Query query = em.createQuery("");  // write HQL query for selecting all calculs
		List<Calcul> calculs = query.getResultList();
		return calculs;
	}
	
	

}
