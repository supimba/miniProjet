package ch.hevs.managedbeans;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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

@ManagedBean(name = "createbookbean")
@ViewScoped
public class BookBean {

	@EJB
	private BookShelf bookShelf;
	private Set<Book> books;
	private Book book = new Book();
	private String test;
	private Set<Category> categories;
	private Category category = new Category();
	private Set<Writer> writers;
	private Writer writer = new Writer();
	private List<String> writerSelectedId;
	private List<String> categorySelectedId;
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
	}

	public void cancelEdit(){
		 editmode = false;
	}
	public void edit() {
	    editmode = true;
	}
	
	public boolean isEditmode() {
	    return editmode;
	}
	
	public Set<Book> getBooks() {
		return bookShelf.getBooks();
	}
	

	public void getBookFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_index.xhtml");

		this.book = bookShelf.getBook(i);
	}
	
	public void createNewBook(){
		
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "book_create.xhtml");
	}
	public List<String> getWriterSelectedId() {
		return writerSelectedId;
	}

	public void setWriterSelectedId(List<String> writerSelectedId) {
		this.writerSelectedId = writerSelectedId;
	}
	
	public List<String> getCategorySelectedId() {
		return categorySelectedId;
	}

	public void setCategorySelectedId(List<String> categorySelectedId) {
		this.categorySelectedId = categorySelectedId;
	}
	
	public void createCategory(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_create.xhtml");
	}


	public String insertBook(Book book) {
		for (String writerId : writerSelectedId)
			book.addWriter(bookShelf.getWriter(Long.valueOf(writerId)));
		
		for(String categoryId : categorySelectedId)
			book.addCategory(bookShelf.getCategory(Long.valueOf(categoryId)));

		bookShelf.insertBook(book);
		return "book_index.xhtml";
	}

	public Set<Writer> getWriters() {
		return bookShelf.getWriters();
	}

	public Set<Category> getCategories() {
		return bookShelf.getCategories();
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category getCategroy() {
		return category;
	}

	public void setCategroy(Category category) {
		this.category = category;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	public void deleteBook(){
		bookShelf.deleteBook(this.book);
		this.book = new Book(); 
		
	}
	
	public void populate() {
		bookShelf.populate();
	}
}
