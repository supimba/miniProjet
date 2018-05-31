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
				"Les Fleurs du mal est le titre d'un recueil de po�mes de Charles Baudelaire, englobant la quasi-totalit� de sa production en vers, de 1840 jusqu'� sa mort survenue fin ao�t 1867.",
				"1840", "Fran�ais");
		

		Writer w1 = new Writer("Baudelaire", "Charles", "homme", new Date(1980, 8, 31), "Charles Baudelaire est un po�te fran�ais. N� � Paris le 9 avril 1821, il meurt dans la m�me ville le 31 ao�t 1867 (� 46 ans).");
		b1.addWriter(w1);
		Category c1 = new Category("Po�sie");
		b1.addCategory(c1);
		em.persist(b1);
		
		
		Book b2 = new Book();
		b2.setIsbn("1020900113");
		b2.setTitle("Jean-Claude Ameisen");
		b2.setLanguage("Fran�ais");
		b2.setSummary("Tous les samedis � 11 h, 1,5 million auditeurs fid�les et passionn�s �coutent sur France Inter l'�mission Sur les �paules de Darwin,"
				+ " de Jean-Claude Ameisen. Lanc�e il y a deux ans, cette �mission est devenue une �mission culte. Durant une heure Ameisen parle de sa voix "
				+ "chaude de l'univers, de la nature, de l'�volution, d'�thique, des grandes r�volutions scientifiques qui nous exhortent � entendre et penser "
				+ "diff�remment le monde");
		b2.setYear("2012");
		
		Writer w2 = new Writer();
		w2.setFirstname("Jean-Claude");
		w2.setLastname("Ameisen");
		w2.setGenre("Homme");
		w2.setBirthday(new Date(1951, 12, 22));
		w2.setBiography("Jean Claude Ameisen, n� le 22 d�cembre 1951 � New York, est un m�decin, immunologiste et chercheur fran�ais en biologie."
				+ "Il est directeur du Centre d'�tudes du vivant de l'Institut des humanit�s de Paris de l'universit� Paris Diderot et pr�sident "
				+ "du Comit� consultatif national d'�thique (2012-2016).");
		
		Category c2 = new Category();
		c2.setNameCategory("R�cits");
		
		em.persist(b1);
	
		
	}
	
	
}
