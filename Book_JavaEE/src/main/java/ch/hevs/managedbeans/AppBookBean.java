package ch.hevs.managedbeans;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
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
	
	@EJB
	private BookShelf bookShelf;
	
	private Set<Book> books;
	private Book book = new Book();
	private Set<Writer> writers;
	private Writer writer = new Writer();
	private Set<Category> categories;
	private Category category = new Category();
	private List<String> writersSelectedId; 
	private List<String> categoriesSelectedId;
	private List<String> booksSelectedId; 
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
	
	// CRUD for books
	public void createNewBook(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_create.xhtml");
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
	
	public void deleteBook(){
		bookShelf.deleteBook(this.book);
		this.book = new Book(); 
	}
	
	// udpate and delete writer
	public void updateWriter(Writer writer){
		writer.clearBooks();
		
		for (String bookId : booksSelectedId)
			writer.addBook(bookShelf.getBook(Long.valueOf(bookId)));
		
		bookShelf.updateWriter(writer);
		this.editmode = false;
	}

	public void deleteWriter(){
		bookShelf.deleteWriter(this.writer);
		this.writer = new Writer(); 
	}

	// update and delete category
	public void updateCategory(Category category) {
		bookShelf.updateCategory(category);
		this.editmode = false;		
	}
	
	public void deleteCategory() {
		bookShelf.deleteCategory(category);
		this.category = new Category(); 
	}
	
	/**
	 * Get the category id value and redirect the user to the category details
	 * 
	 * @param i
	 */
	public void getCategoryFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_index.xhtml");
		this.category = bookShelf.getCategory(i);

	}
	
	/**
	 * Get the writer id value and redirect the user to the category details
	 * 
	 * @param i
	 */
	public void getWriterFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_index.xhtml");
		this.writer = bookShelf.getWriter(i);

	}
	
	/**
	 * Get the book id value and redirect the user to the category details
	 * 
	 * @param i
	 */
	public void getBookFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_index.xhtml");

		this.book = bookShelf.getBook(i);
	}
	
	/**
	 * Redirect the user to the category form
	 */
	public void createCategory(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_create.xhtml");
	}
	
	// getters and setters
	public Set<Book> getBooks() {
		return bookShelf.getBooks();
	}

	public Book getBook() {
		return this.book;
	}
	
	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public Writer getWriter()
	{
		return this.writer;
	}
	
	public void setWriter(Writer writer)
	{
		this.writer = writer;
	}
	
	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}
	
	
	// get user selection in edition mode
	public List<String> getCategoriesSelectedId() {
		return categoriesSelectedId;
	}
	public void setCategoriesSelectedId(List<String> categoriesSelectedId) {
		this.categoriesSelectedId = categoriesSelectedId;
	}
	
	public List<String> getBooksSelectedId() {
		return booksSelectedId;
	}

	public void setBooksSelectedId(List<String> booksSelectedId) {
		this.booksSelectedId = booksSelectedId;
	}
	
	public List<String> getWritersSelectedId() {
		return writersSelectedId;
	}

	public void setWritersSelectedId(List<String> writersSelectedId) {
		this.writersSelectedId = writersSelectedId;
	}
	
	
	
	
	/**
	 * Activate the edition mode.
	 */
	public void edit() {
	    editmode = true;
	}
	
	/**
	 * Deactivate the edition mode.
	 */
	public void cancelEdit(){
		 editmode = false;
	}
	
	/**
	 * Flag to check edit mode 
	 *  
	 * @return
	 */
	public boolean isEditmode() {
	    return editmode;
	}
	
	/**
	 * Call the method to populate the database
	 */
	public void populate() {
		bookShelf.populate();
	}
}