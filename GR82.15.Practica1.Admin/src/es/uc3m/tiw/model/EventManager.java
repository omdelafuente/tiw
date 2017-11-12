package es.uc3m.tiw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


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
	
	//a�ade un evento a la base de datos
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

	//elimina un evento de la base de datos
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

	//actualiza los datos de un evento
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

	//encuentra un evento por su id
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
	
	//encuentra todos los eventos creados
	public List<Event> findAll() {
		
		List<Event> events = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Event c");
			events = (List<Event>) query.getResultList();
		} finally {
			em.close();
		}
		return events;
	}
	
	//busca un string en los campos de un evento
	public List<Event> findEventsMatchingString(String str){
		
		List<Event> events = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Event c WHERE c.title LIKE CONCAT('%',:str,'%') OR c.category LIKE CONCAT('%',:str,'%') OR c.price LIKE CONCAT('%',:str,'%') OR function('date_format',c.eventDate, '%r %M %d %Y') LIKE CONCAT('%',:str,'%') OR c.place LIKE CONCAT('%',:str,'%') OR c.description LIKE CONCAT('%',:str,'%') OR c.state LIKE CONCAT('%',:str,'%')");
			query.setParameter("str", str);
			events = (List<Event>)query.getResultList();
			
		} finally {
			em.close();
		}
		return events;
	}
	
	//busca todos los eventos creados por un usuario
	public List<Event> findEventsByCreator(Usr creator){
		
		List<Event> events = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Event c WHERE c.creator = :creator");
			query.setParameter("creator", creator);
			events = (List<Event>)query.getResultList();
			
		} finally {
			em.close();
		}
		return events;
	}

	public Event getNewEvent() {

		Event event = new Event();

		return event;
	}

}
