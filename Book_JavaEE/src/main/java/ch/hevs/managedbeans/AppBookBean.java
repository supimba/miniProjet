package ch.hevs.managedbeans;

import java.util.List;

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
    private List<Book> books;
    private Book book;
    private List<Writer> writers;
    private Writer writer;
    private List<Category> categories;
    private Category category;
    private BookShelf bookShelf;
    
    @PostConstruct
    public void initialize() throws NamingException {
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		bookShelf = (BookShelf) ctx.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");    	
			
		this.books = bookShelf.getBooks();
		this.writers = bookShelf.getWriters();
		this.categories = bookShelf.getCategories();
		this.populate();
    }

	public List<Book> getBooks() {
		return books;
	}

	public Book getBook() {
		return book;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public Writer getWriter() {
		return writer;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategory() {
		return category;
	}

	public BookShelf getBookShelf() {
		return bookShelf;
	}
   
	public void populate(){
		bookShelf.populate();
	}
    
}