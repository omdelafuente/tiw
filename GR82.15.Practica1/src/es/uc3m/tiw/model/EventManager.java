package es.uc3m.tiw.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public List<Event> findEventsMatchingString(String str){
		
		List<Event> events = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Event c WHERE c.title LIKE CONCAT('%',:str,'%') OR c.category LIKE CONCAT('%',:str,'%') OR c.price = :str OR function('date_format',c.eventDate, '%r %M %d %Y') LIKE CONCAT('%',:str,'%') OR c.place LIKE CONCAT('%',:str,'%') OR c.description LIKE CONCAT('%',:str,'%') OR c.state LIKE CONCAT('%',:str,'%')");
			query.setParameter("str", str);
			events = (List<Event>)query.getResultList();
			
		} finally {
			em.close();
		}
		return events;
	}
	
	public List<Event> findEventsByMultipleFields(String title, String category, String place, String description, String state, BigDecimal priceMin, BigDecimal priceMax, LocalDateTime dateMin, LocalDateTime dateMax){
		
		List<Event> events = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Event c WHERE (:title IS NULL OR c.title LIKE CONCAT('%',:title,'%')) AND (:category IS NULL OR c.category = :category) AND (:place IS NULL OR c.place LIKE CONCAT('%',:place,'%')) AND (:description IS NULL OR c.description LIKE CONCAT('%',:description,'%')) AND (:state IS NULL OR c.state = :state) AND (:priceMin IS NULL OR c.price >= :priceMin) AND (:priceMax IS NULL OR c.price <= :priceMax) AND (:dateMin IS NULL OR c.eventDate >= :dateMin) AND (:dateMax IS NULL OR c.eventDate <= :dateMax)");
			query.setParameter("title", title);
			query.setParameter("category", category);
			query.setParameter("place", place);
			query.setParameter("description", description);
			query.setParameter("state", state);
			query.setParameter("priceMin", priceMin);
			query.setParameter("priceMax", priceMax);
			query.setParameter("dateMin", dateMin);
			query.setParameter("dateMax", dateMax);
			
			events = (List<Event>)query.getResultList();
			
		} finally {
			em.close();
		}
		return events;
	}
	
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
