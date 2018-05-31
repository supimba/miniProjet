package ch.hevs.bookshelf;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

@Stateful
public class BookShelfBean implements BookShelf{
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED, name = "BookShelfPU")
	private EntityManager em;

	@Override
	public List<Book> getBooks() {
		return em.createQuery("SELECT id, title FROM book").getResultList();
	}

	@Override
	public Book getBook(long id) {
		return (Book) em.createQuery("SELECT *, title FROM book where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Writer> getWriters() {
		return em.createQuery("SELECT id, title FROM writer").getResultList();

	}

	@Override
	public Writer getWriter(long id) {
		return (Writer) em.createQuery("SELECT *, title FROM writer where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Category> getCategories() {
		return em.createQuery("SELECT id, title FROM category").getResultList();

	}

	@Override
	public Category getCategory(long id) {
		return (Category) em.createQuery("SELECT *, title FROM category where id=:id").setParameter("id", id).getResultList();

	}

	@Override
	public void populate() {
		
		Book b1 = new Book("2266083260", "Les Fleurs Du Mal",
				"Les Fleurs du mal est le titre d'un recueil de poèmes de Charles Baudelaire, englobant la quasi-totalité de sa production en vers, de 1840 jusqu'à sa mort survenue fin août 1867.",
				"1840", "Français");
		

		Writer w1 = new Writer("Baudelaire", "Charles", "homme", new Date(1980, 8, 31), "Charles Baudelaire est un poète français. Né à Paris le 9 avril 1821, il meurt dans la même ville le 31 août 1867 (à 46 ans).");
		b1.addWriter(w1);
		Category c1 = new Category("Poésie");
		b1.addCategory(c1);
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
		w2.setBirthday(new Date(1951, 12, 22));
		w2.setBiography("Jean Claude Ameisen, né le 22 décembre 1951 à New York, est un médecin, immunologiste et chercheur français en biologie."
				+ "Il est directeur du Centre d'études du vivant de l'Institut des humanités de Paris de l'université Paris Diderot et président "
				+ "du Comité consultatif national d'éthique (2012-2016).");
		
		Category c2 = new Category();
		c2.setNameCategory("Récits");
		
		em.persist(b1);
	
		
	}
	
	
}
