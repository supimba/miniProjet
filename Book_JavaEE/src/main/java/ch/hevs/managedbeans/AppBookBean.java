package ch.hevs.managedbeans;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

@ManagedBean
public class AppBookBean {
	private Set<Book> books;
	private Book book = new Book();
	private Set<Writer> writers;
	private Writer writer = new Writer();
	private Set<Category> categories;
	private Category category = new Category();
	private BookShelf bookShelf;

	private List<String> writersSelectedId; 
	private List<String> categoriesSelectedId;
	private boolean editmode; 

	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();

		bookShelf = (BookShelf) ctx
				.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");
		this.books = bookShelf.getBooks();
		this.writers = bookShelf.getWriters();
		this.categories = bookShelf.getCategories();
//		this.populate();
	}
	


	public void updateBook(Book book){
	
		book.clearCategories();
		book.clearWriters();
		
		for (String writerId : writersSelectedId)
			book.addWriter(bookShelf.getWriter(Long.valueOf(writerId)));
		
		for (String categoryId : categoriesSelectedId)
			book.addCategory(bookShelf.getCategory(Long.valueOf(categoryId)));
		
		bookShelf.updateBook(book);
		this.editmode = false;

	}



	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}

	public Writer getWriter()
	{
		return this.writer;
	}
	


	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}
	
	public Category getCategory() {
		return this.category;
	}
	

	public void createCategory(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_create.xhtml");
	}


	

	public List<String> getWritersSelectedId() {
		return writersSelectedId;
	}
	public void setWritersSelectedId(List<String> writersSelectedId) {
		this.writersSelectedId = writersSelectedId;
	}
	public List<String> getCategoriesSelectedId() {
		return categoriesSelectedId;
	}
	public void setCategoriesSelectedId(List<String> categoriesSelectedId) {
		this.categoriesSelectedId = categoriesSelectedId;
	}
	

	

}