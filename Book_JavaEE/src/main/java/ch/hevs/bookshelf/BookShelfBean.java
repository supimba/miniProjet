package ch.hevs.bookshelf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

@Stateful
public class BookShelfBean implements BookShelf {

	@PersistenceContext(type = PersistenceContextType.EXTENDED, name = "BookShelfPU")
	private EntityManager em;

	@Override
	public Set<Book> getBooks() {
		return new HashSet<Book>(em.createQuery("FROM Book").getResultList());
	}

	@Override
	public Book getBook(long id) {
		return (Book) em.createQuery("FROM Book b WHERE b.id=:id").setParameter("id", id).getSingleResult();
	}


	@Override
	public void insertBook(Book book) {
		em.merge(book); 
	}
	

	@Override
	public void updateBook(Book book) {		
		em.persist(book);
	}

	@Override
	public void deleteBook(Book book) {
		em.remove(em.contains(book) ? book : em.merge(book));
	}

	@Override
	public Set<Writer> getWriters() {
		return new HashSet<Writer>(em.createQuery("FROM Writer").getResultList());

	}

	@Override
	public Writer getWriter(long id) {
		return (Writer) em.createQuery("FROM Writer w where w.id=:id").setParameter("id", id).getSingleResult();
	}
	
	@Override
	public void insertWriter(Writer writer) {
		
		System.out.println("INSERT WRITER");
		em.merge(writer); 
		
	}

	@Override
	public void updateWriter(Writer writer) {
		em.persist(writer);
		
	}

	@Override
	public void deleteWriter(Writer writer) {
		em.remove(em.contains(writer) ? writer : em.merge(writer));
		
	}
	
	
	@Override
	public Set<Category> getCategories() {
		return new HashSet<Category>(em.createQuery("FROM Category").getResultList());

	}

	@Override
	public Category getCategory(long id) {
		return (Category) em.createQuery("FROM Category c where c.id=:id").setParameter("id", id).getSingleResult();

	}
	
	@Override
	public void insertCategory(Category category) {

		em.persist(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		em.persist(category);
		
	}
	@Override
	public void deleteCategory(Category category) {
		em.remove(em.contains(category) ? category : em.merge(category));
		
	}

	@TransactionAttribute(value =TransactionAttributeType.REQUIRED)
	@Override
	public void populate() {

		if (this.getBooks().size() == 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
			Book b1 = new Book();
			b1.setIsbn("2266083260");
			b1.setTitle("Les Fleurs Du Mal");
			b1.setLanguage("Fran�ais");
			b1.setSummary(
					"Les Fleurs du mal est le titre d'un recueil de po�mes de Charles Baudelaire, englobant la quasi-totalit� de sa production en vers, de 1840 jusqu'� sa mort survenue fin ao�t 1867.");
			b1.setYear("1840");

			Writer w1 = new Writer();
			w1.setLastname("Baudelaire");
			w1.setFirstname("Charles");
			Date d1 = new Date();
			String birth1 ="31.08.1980";
			try {
				d1 = sdf.parse(birth1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			w1.setBirthday(d1);
			w1.setGenre("homme");
			w1.setBiography(
					"Charles Baudelaire est un po�te fran�ais. N� � Paris le 9 avril 1821, il meurt dans la m�me ville le 31 ao�t 1867 (� 46 ans).");

			Address a1 = new Address();
			a1.setCity("Paris");
			a1.setPostalCode("7500");
			a1.setStreet("No 6 rue Le Regrattie");
			w1.setAddress(a1);

			Category c1 = new Category();
			c1.setNameCategory("Po�sie");

			b1.addCategory(c1);
			b1.addWriter(w1);
			em.persist(b1);

			Book b2 = new Book();
			b2.setIsbn("1020900113");
			b2.setTitle("Sur les �paules de Darwin : Les battements du temps");
			b2.setLanguage("Fran�ais");
			b2.setSummary(
					"Tous les samedis � 11 h, 1,5 million auditeurs fid�les et passionn�s �coutent sur France Inter l'�mission Sur les �paules de Darwin,"
							+ " de Jean-Claude Ameisen. Lanc�e il y a deux ans, cette �mission est devenue une �mission culte. Durant une heure Ameisen parle de sa voix "
							+ "chaude de l'univers, de la nature, de l'�volution, d'�thique, des grandes r�volutions scientifiques qui nous exhortent � entendre et penser "
							+ "diff�remment le monde");
			b2.setYear("2012");

			Writer w2 = new Writer();
			w2.setFirstname("Jean-Claude");
			w2.setLastname("Ameisen");
			w2.setGenre("Homme");
			Date d2 = new Date();
			String birth2 = "22.12.1951";
			try {
				d2 = sdf.parse(birth2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			w2.setBirthday(d2);
			w2.setBiography(
					"Jean Claude Ameisen, n� le 22 d�cembre 1951 � New York, est un m�decin, immunologiste et chercheur fran�ais en biologie."
							+ "Il est directeur du Centre d'�tudes du vivant de l'Institut des humanit�s de Paris de l'universit� Paris Diderot et pr�sident "
							+ "du Comit� consultatif national d'�thique (2012-2016).");
			Address a2 = new Address();
			a2.setCity("Paris");
			a2.setStreet("5 Rue Thomas Mann");
			a2.setPostalCode("75013");
			w2.setAddress(a2);

			Category c2 = new Category();
			c2.setNameCategory("R�cits");

			b2.addCategory(c2);
			b2.addWriter(w2);
			b2.addWriter(w1);

			em.persist(b2);
			
			
			Book b3 = new Book();
			b3.setIsbn("2070366146");
			b3.setTitle("Fictions");
			b3.setLanguage("Fran�ais");
			b3.setSummary(
					"Des nombreux probl�mes qui exerc�rent la t�m�raire perspicacit� de L�nnrot, aucun ne fut aussi �trange - aussi rigoureusement �trange, dirons-nous - que la s�rie p�riodique de meurtres qui culmin�rent dans la propri�t� de Triste-Le-Roy, parmi l'interminable odeur des eucalyptus. Il est vrai qu'Eric L�nnrot ne r�ussit pas � emp�cher le dernier crime, mais il est indiscutable qu'il l'avait pr�vu...");
			b3.setYear("1974");

			Writer w3 = new Writer();
			w3.setFirstname("Jorge Luis");
			w3.setLastname("Borges");
			w3.setGenre("Homme");
			
			Date d3 = new Date();
			String birth3 = "12.08.1900";
			try {
				d3 = sdf.parse(birth3);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			w3.setBirthday(d3);
			w3.setBiography(
					"Jorge Luis Borges de son nom complet Jorge Francisco Isidoro Luis Borges Acevedonote 1, est un �crivain argentin de prose et de po�sie, n� le 24 ao�t 1899 � Buenos Aires et mort � Gen�ve le 14 juin 1986. Ses travaux dans les champs de l�essai et de la nouvelle sont consid�r�s comme des classiques de la litt�rature du xxe si�cle.");
			Address a3 = new Address();
			a3.setCity("Buenos Aires");
			a3.setStreet("5 Cino-Del-Duca");
			a3.setPostalCode("10003");
			w3.setAddress(a3);

			Category c3 = new Category();
			c3.setNameCategory("Nouvelle");
			Category c4 = new Category();

			c4.setNameCategory("Fiction");

			b3.addCategory(c3);
			b3.addCategory(c4);
			b3.addWriter(w3);

			em.persist(b3);
		}
	}





}
