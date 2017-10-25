package es.uc3m.tiw.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class EventManager {
	
	private EntityManagerFactory emf;
	
	public EventManager(){
		
	}
	
	public EventManager(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManager getEntityManager() {
		if (emf == null) {
			throw new RuntimeException(
					"The EntityManagerFactory is null.  This must be passed in to the constructor or set using the setEntityManagerFactory() method.");
		}
		return emf.createEntityManager();
	}
	
	public String createEvent(Event event) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(event);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	public String deleteEvent(Event event) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			event = em.merge(event);
			em.remove(event);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	public String updateEvent(Event event) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			event = em.merge(event);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	public Event findEventByID(int id) {
		Event event = null;
		EntityManager em = getEntityManager();
		try {
			event = (Event) em.find(Event.class, id);
		} finally {
			em.close();
		}
		return event;
	}

	public Event getNewEvent() {

		Event event = new Event();

		return event;
	}

}