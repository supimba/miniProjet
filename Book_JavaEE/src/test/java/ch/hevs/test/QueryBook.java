package ch.hevs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;


public class QueryBook {

	@Test
	public void test() {
		EntityTransaction tx = null;
		try {			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShelfPU");
			//@PersistenceContext(name="BookShelfPU", type=PersistenceContextType.E)
			EntityManager em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			
			Book b = new Book();
			Category c = new Category();
			Writer w = new Writer();

			c.setNameCategory("fantastique");
			w.setBiography("bio");
			w.setFirstname("joseph");
			w.setLastname("delarue");
			w.setGenre("homme");
			
			em.persist(c);
			
			b.addCategory(c);
			em.persist(w);
			b.addWriter(w);


			b.setIsbn("123");
			b.setLanguage("fr");
			b.setSummary("summ");
			b.setTitle("title");
			b.setYear("2008");

			em.persist(b);
			tx.commit();
			System.out.println("commited 2");


		} catch (Exception e) {
			System.out.println("error");

			e.printStackTrace();
			/*
			 * try { tx.rollback(); } catch (IllegalStateException e1) {
			 * e1.printStackTrace(); } catch (SecurityException e1) {
			 * e1.printStackTrace(); } catch (SystemException e1) {
			 * e1.printStackTrace(); }
			 */
		}

	}
}