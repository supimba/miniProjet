package ch.hevs.bookshelf;

import java.util.Set;

import javax.ejb.Local;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;


public interface BookShelf {
	
	
	public void populate(); 
	  public Set<Book> getBooks();
	  public Book getBook(long id);
	  
	  public Set<Writer> getWriters();
	  public Writer getWriter(long id);
	  
	  public Set<Category> getCategories();
	  public Category getCategory(long id);
}
