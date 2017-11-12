package es.uc3m.tiw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PurchaseManager {
	
	private EntityManagerFactory emf;
	
	public PurchaseManager() {
		
	}
	
	public PurchaseManager(EntityManagerFactory emf) {
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
	
	//añade una nueva compra a la base de datos
	public String createPurchase(Purchase purchase) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(purchase);
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

	//elimina una compra de la base de datos
	public String deletePurchase(Purchase purchase) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			purchase = em.merge(purchase);
			em.remove(purchase);
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

	//actualiza los datos de una compra
	public String updatePurchase(Purchase purchase) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			purchase = em.merge(purchase);
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
	
	//busca una compra por su id 
	public Purchase findPurchaseByID(int id) {
		Purchase purchase = null;
		EntityManager em = getEntityManager();
		try {
			purchase = (Purchase) em.find(Purchase.class, id);
		} finally {
			em.close();
		}
		return purchase;
	}
	
	//busca las compras realizadas por un usuario
	public List<Purchase> findPurchasesByUser(Usr user){
		
		List<Purchase> purchases = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Purchase c WHERE c.client = :user");
			query.setParameter("user", user);
			purchases = (List<Purchase>)query.getResultList();
			
		} finally {
			em.close();
		}
		return purchases;
	}
	
	//busca las compras de un determinado evento
	public List<Purchase> findPurchasesByEvent(Event event){
		
		List<Purchase> purchases = null;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Purchase c WHERE c.event = :event");
			query.setParameter("event", event);
			purchases = (List<Purchase>)query.getResultList();
			
		} finally {
			em.close();
		}
		return purchases;
	}

}
