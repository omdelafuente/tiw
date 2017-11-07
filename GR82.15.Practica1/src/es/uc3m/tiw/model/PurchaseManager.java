package es.uc3m.tiw.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

}
