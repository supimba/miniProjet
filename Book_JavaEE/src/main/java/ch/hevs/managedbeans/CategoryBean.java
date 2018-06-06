package ch.hevs.managedbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Category;

@ManagedBean
@ViewScoped
public class CategoryBean {
	
	@EJB
	private BookShelf bookshelf;
	private Category category = new Category();

	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		bookshelf = (BookShelf) ctx
				.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	} 
	
	public String insertCategory(Category category) {
		
		bookshelf.insertCategory(category);
		return "category_index.xhtml";
	}
	
	public void createCategory(){
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_create.xhtml");
	}
	public void getCategoryFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "category_index.xhtml");
		this.category = bookshelf.getCategory(i);

	}

}
