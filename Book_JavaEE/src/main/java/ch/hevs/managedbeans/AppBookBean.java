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
    private Book book = new Book();
    private Set<Writer> writers;
    private Writer writer;
    private Set<Category> categories;
    private Category category;
    private BookShelf bookShelf;

    
    @PostConstruct
    public void initialize() throws NamingException {
    	// use JNDI to inject reference to bank EJB
		System.out.println("DENIS Initialize");
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
	
	

	public Book getBook() {
		return this.book;
	}
	
	public void getBookFromDatabase(long i)
	{
		this.book = bookShelf.getBook(i);
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

	
	
	
    
}