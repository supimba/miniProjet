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

@ManagedBean(name = "CreateBookBean")
@RequestScoped
public class CreateBookBean {

	@EJB
	private BookShelf bookShelf;

	private String isbn;
	private String title;
	private String summary;
	private String year;
	private String language;
	private Set<Writer> writers;
	private Set<Category> categories;
	
	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		System.out.println("DENIS Initialize");
		InitialContext ctx = new InitialContext();

		bookShelf = (BookShelf) ctx
				.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");

		this.writers = bookShelf.getWriters();
		this.categories = bookShelf.getCategories();

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String insertBook() {
		System.out.println("ISBN : " + isbn + " TITLE : "+ title + " LANGUAGE : "+ language + " SUMMARY : "+ summary + " YEAHR : " +year );
		
		bookShelf.insertBook(isbn, title, language, summary, year);
		cleanFields();
		return "Sucess";
	}

	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}
	
	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}

	public void cleanFields() {
		isbn = "";
		title = "";
		summary = "";
		language = "";
		year = "";
	}
}
