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
	public void insertBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Book book);
	
	public Set<Writer> getWriters();
	public Writer getWriter(long id);
	public void insertWriter(Writer writer);
	public void updateWriter(Writer writer);
	public void deleteWriter(Writer writer);
	
	public Set<Category> getCategories();
	public Category getCategory(long id);
	public void insertCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Category category); 

}
