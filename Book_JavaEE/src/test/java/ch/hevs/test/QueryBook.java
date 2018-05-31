package ch.hevs.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;


public class QueryBook {

	@Test
	public void test() {
		EntityTransaction tx = null;
		try {			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShelfPU");
			EntityManager em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();

			Book b = new Book();
			Category c = new Category();
			Writer w = new Writer();
			Address a = new Address();
			a.setStreet("route de sion 22");
			a.setCity("sierr");
			a.setPostalCode("3960");
			c.setNameCategory("fantastique22");

			w.setBiography("bio");
			w.setBirthday("06.11.1993");
			w.setFirstname("joseph");
			w.setLastname("delarue");
			w.setGenre("homme");
			w.setAddress(a);
			b.setIsbn("123");
			b.setLanguage("freeee");
			b.setSummary("summ");
			b.setTitle("title");
			b.setYear("2008");
			b.addCategory(c);
			
			em.persist(b);
			
			Category c2 = new Category();
			c2.setNameCategory("fantastiquement cool");
			em.persist(c2);
	
			tx.commit();
			tx.begin();
			em.remove(b);
			tx.commit();
			

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