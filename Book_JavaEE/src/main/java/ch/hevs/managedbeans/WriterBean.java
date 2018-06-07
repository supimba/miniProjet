package ch.hevs.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Writer;

@ManagedBean
@ViewScoped
public class WriterBean {
	
	@EJB
	private BookShelf bookshelf; 
	
	private Writer writer = new Writer();
	
	/**
	 * Create a new writer and insert into database
	 * @param writer
	 * @return
	 */
	public String insertWriter(Writer writer) {
		bookshelf.insertWriter(writer);
		return "writer_index.xhtml"; 
	}
	
	public void createWriter() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_create.xhtml");
	}
	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

}
