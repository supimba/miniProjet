package ch.hevs.bookshelf;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

@Stateful
public class BookShelfBean implements BookShelf{
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED, name = "BookPU")
	private EntityManager em;

	@Override
	public List<Book> getBooks() {
		return (List<Book>) em.createQuery("SELECT id, title FROM book").getResultList();
	}

	@Override
	public Book getBook(long id) {
		return (Book) em.createQuery("SELECT *, title FROM book where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Writer> getWriters() {
		return (List<Writer>) em.createQuery("SELECT id, title FROM writer").getResultList();

	}

	@Override
	public Writer getWriter(long id) {
		return (Writer) em.createQuery("SELECT *, title FROM writer where id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Category> getCategories() {
		return (List<Category>) em.createQuery("SELECT id, title FROM category").getResultList();

	}

	@Override
	public Category getCategory(long id) {
		return (Category) em.createQuery("SELECT *, title FROM category where id=:id").setParameter("id", id).getResultList();

	}
	
}
