package ch.hevs.managedbeans;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

/**
 * BookShelfBean.java
 * 
 */

public class AppBookBean
{
    private Set<Book> books;
    private Book book;
    private Set<Writer> writers;
    private Writer writer;
    private Set<Category> categories;
    private Category category;
    private BookShelf bookShelf;
    private String toto;
    
    @PostConstruct
    public void initialize() throws NamingException {
    	// use JNDI to inject reference to bank EJB
		System.out.println("DENIS Initialize");
		this.toto = "toto";
    	InitialContext ctx = new InitialContext();
		bookShelf = (BookShelf) ctx.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");    	
		this.books = bookShelf.getBooks();
		this.writers = bookShelf.getWriters();
		this.categories = bookShelf.getCategories();
		
		this.populate();
    }

	public Set<Book> getBooks() {
		return bookShelf.getBooks();
	}

	public Book getBook(long i) {
		return bookShelf.getBook(i);
	}

	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}

	public Writer getWriter(long i) {
		return bookShelf.getWriter(i);
	}

	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}

	public Category getCategory(long i) {
		return bookShelf.getCategory(i);
	}
   
	public void populate(){
		bookShelf.populate();
	}

	public String getToto() {
		return toto;
	}

	public void setToto(String toto) {
		this.toto = toto;
	}
	
	
    
}