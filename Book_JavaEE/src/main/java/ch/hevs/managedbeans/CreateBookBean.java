package ch.hevs.managedbeans;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

@ManagedBean(name = "createbookbean")

public class CreateBookBean {

	@EJB
	private BookShelf bookShelf;

	private String isbn;
	private String title;
	private String summary;
	private String year;
	private String language;
	private Set<Category> categories;
	private Category categroy; 
	private Set<Writer> writers;
	private String writerSelectedId;
	private Book book = new Book(); 
	
	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		bookShelf = (BookShelf) ctx.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");
		this.writers = bookShelf.getWriters();
		this.categories = bookShelf.getCategories();
	}

	
	public void insertBook(Book book){
		bookShelf.insertBook(book);		
	}

	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}
	

	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category getCategroy() {
		return categroy;
	}

	public void setCategroy(Category categroy) {
		this.categroy = categroy;
	}

	public String getWriterSelectedId() {
		return writerSelectedId;
	}

	public void setWriterSelectedId(String writerSelectedId) {
		this.writerSelectedId = writerSelectedId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void cleanFields() {
		isbn = "";
		title = "";
		summary = "";
		language = "";
		year = "";
	}
}
