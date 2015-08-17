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
		if(em.find(Calcul.class, calcul.getId()) != null){
			em.merge(calcul);
		}
		em.persist(calcul);
		em.getTransaction().commit();
	}

	@Override
	public List<Calcul> load() {	
		Query query = em.createQuery("SELECT c FROM Calcul c");
		List<Calcul> calculs = query.getResultList();
		return calculs;
	}
	
	

}
