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
	private Book bookEdit; 
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
		this.populate();
	}
	
	public void cancelEdit(){
		 editmode = false;
	}
	public void edit() {
	    editmode = true;
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

	public boolean isEditmode() {
	    return editmode;
	}

	public Book getBookEdit() {
		return bookEdit;
	}

	public void setBookEdit(Book bookEdit) {
		this.bookEdit = book;
	}

	public Set<Book> getBooks() {
		return bookShelf.getBooks();
	}

	public Book getBook() {
		return this.book;
	}

	public void getBookFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_index.xhtml");

		this.book = bookShelf.getBook(i);
	}
	public void createNewBook(){
		
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_create.xhtml");
	}
	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}

	public Writer getWriter()
	{
		return this.writer;
	}
	
	public void getWriterFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_index.xhtml");
		this.writer = bookShelf.getWriter(i);
	}

	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public void updateCategory(Category category) {
		bookShelf.updateCategory(category);
		this.editmode = false;		
	}
	public void deleteCategory() {
		bookShelf.deleteCategory(category);
		this.category = new Category(); 
	}
	
	public void getCategoryFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_index.xhtml");
		this.category = bookShelf.getCategory(i);

	}
	public void createCategory(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_create.xhtml");
	}

	public void populate() {
		bookShelf.populate();
	}
	
	public String editBook(Book book){
		return "book_edit.xhtml";
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
	
	public void deleteBook(){
		bookShelf.deleteBook(this.book);
		this.book = new Book(); 
		
	}
	

}