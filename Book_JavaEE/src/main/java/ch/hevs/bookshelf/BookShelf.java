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
	void deleteBook(Book book);
	void insertWriter(String firstname, String lastname, String birthday, String genre, String biography);
	void updateWriter(Writer writer);
	void deleteWriter(Writer writer);
	void insertCategory(String nameCategory);
	void updateCategory(Category category);
	void updateBook(Book book);
	void insertBook(String isbn, String title, String summary, String language, String year);
}
