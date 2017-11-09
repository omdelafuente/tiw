package es.uc3m.tiw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class UsrManager {
	
	private EntityManagerFactory emf;
	
	public UsrManager() {
		
	}
	
	public UsrManager(EntityManagerFactory emf) {
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
	
	public String createUser (Usr user) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
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
	
	public String deleteUser(Usr user) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			user = em.merge(user);
			em.remove(user);
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
	
	public String updateUser(Usr user) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			user = em.merge(user);
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
	
	public Usr getNewUser() {

		Usr user = new Usr();

		return user;
	}
	
	public Usr findUserByEmail(String email) {
		Usr user = null;
		EntityManager em = getEntityManager();
		try {
			user = (Usr) em.find(Usr.class, email);
		} finally {
			em.close();
		}
		return user;
	}
	
	public List<Usr> findUsersWithCreatedEvents (){
		
		List<Usr> users = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT DISTINCT c FROM Usr c JOIN c.events e WHERE c=e.creator");
			users = (List<Usr>)query.getResultList();
			
		} finally {
			em.close();
		}
		return users;
	}

}
