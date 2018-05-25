package ch.hevs.bookshelf;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

public interface BookShelf {
	  public List<Book> getBooks();
	  public Book getBook(long id);
	  
	  public List<Writer> getWriters();
	  public Writer getWriter(long id);
	  
	  public List<Category> getCategories();
	  public Category getCategory(long id);
}
