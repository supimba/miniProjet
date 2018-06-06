package ch.hevs.managedbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Writer;

@ManagedBean
@ViewScoped
public class WriterBean {
	
	@EJB
	private BookShelf bookshelf; 
	private Writer writer = new Writer();

	
	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		bookshelf = (BookShelf) ctx
				.lookup("java:global/Book_JavaEE-0.0.1-SNAPSHOT/BookShelfBean!ch.hevs.bookshelf.BookShelf");


	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
	public String insertWriter(Writer writer) {
		bookshelf.insertWriter(writer);
		return "writer_index.xthml"; 
	}
	
	public void createWriter() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_create.xhtml");
	}

	public void getWriterFromDatabase(long i) {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_index.xhtml");
		this.writer = bookshelf.getWriter(i);
	}
	


	

}
