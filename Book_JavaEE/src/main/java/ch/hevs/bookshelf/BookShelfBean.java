package ch.hevs.bookshelf;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

@Stateful
public class BookShelfBean implements BookShelf{

	@PersistenceContext(type=PersistenceContextType.EXTENDED, name = "BookShelfPU")
	private EntityManager em;

	@Override
	public Set<Book> getBooks() {
		return (Set<Book>) em.createQuery("SELECT id, title FROM book").getResultList();
	}

	@Override
	public Book getBook(long id) {
		return (Book) em.createQuery("SELECT *, title FROM book where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public Set<Writer> getWriters() {
		return (Set<Writer>) em.createQuery("SELECT id, title FROM writer").getResultList();

	}

	@Override
	public Writer getWriter(long id) {
		return (Writer) em.createQuery("SELECT *, title FROM writer where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public Set<Category> getCategories() {
		return (Set<Category>) em.createQuery("SELECT id, title FROM category").getResultList();

	}

	@Override
	public Category getCategory(long id) {
		return (Category) em.createQuery("SELECT *, title FROM category where id=:id").setParameter("id", id).getResultList();

	}

	@Override
	public void populate() {
		System.out.println("DENIS Populate");

		
		Book b1 = new Book();
		b1.setIsbn("2266083260");
		b1.setTitle("Les Fleurs Du Mal");
		b1.setLanguage("Français");
		b1.setSummary("Les Fleurs du mal est le titre d'un recueil de poèmes de Charles Baudelaire, englobant la quasi-totalité de sa production en vers, de 1840 jusqu'à sa mort survenue fin août 1867.");
		b1.setYear("1840");
		
		Writer w1 = new Writer();
		w1.setLastname("Baudelaire");
		w1.setFirstname("Charles");
		w1.setBirthday("31.08.1980");
		w1.setGenre("homme");
		w1.setBiography("Charles Baudelaire est un poète français. Né à Paris le 9 avril 1821, il meurt dans la même ville le 31 août 1867 (à 46 ans).");
		
		Address a1 = new Address(); 
		a1.setCity("Paris");
		a1.setPostalCode("7500");
		a1.setStreet("No 6 rue Le Regrattie");
		w1.setAddress(a1);
		
	
		Category c1 = new Category();
		c1.setNameCategory("Poésie");
		
		b1.addCategory(c1);
		b1.addWriter(w1);
		em.persist(b1);
		
		
		Book b2 = new Book();
		b2.setIsbn("1020900113");
		b2.setTitle("Jean-Claude Ameisen");
		b2.setLanguage("Français");
		b2.setSummary("Tous les samedis à 11 h, 1,5 million auditeurs fidèles et passionnés écoutent sur France Inter l'émission Sur les épaules de Darwin,"
				+ " de Jean-Claude Ameisen. Lancée il y a deux ans, cette émission est devenue une émission culte. Durant une heure Ameisen parle de sa voix "
				+ "chaude de l'univers, de la nature, de l'évolution, d'éthique, des grandes révolutions scientifiques qui nous exhortent à entendre et penser "
				+ "différemment le monde");
		b2.setYear("2012");
		
		Writer w2 = new Writer();
		w2.setFirstname("Jean-Claude");
		w2.setLastname("Ameisen");
		w2.setGenre("Homme");
		w2.setBirthday("22.12.1951");
		w2.setBiography("Jean Claude Ameisen, né le 22 décembre 1951 à New York, est un médecin, immunologiste et chercheur français en biologie."
				+ "Il est directeur du Centre d'études du vivant de l'Institut des humanités de Paris de l'université Paris Diderot et président "
				+ "du Comité consultatif national d'éthique (2012-2016).");
		Address a2 = new Address();
		a2.setCity("Paris");
		a2.setStreet("5 Rue Thomas Mann");
		a2.setPostalCode("75013");
		w2.setAddress(a2);
		
		Category c2 = new Category();
		c2.setNameCategory("Récits");
		
		b2.addCategory(c2);
		b2.addWriter(w2);
		em.persist(b2);
	
		
	}
	
	
}
