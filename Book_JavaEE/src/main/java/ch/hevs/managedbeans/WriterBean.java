package ch.hevs.managedbeans;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Writer;

public class WriterBean {
	
	@EJB
	private BookShelf bookshelf; 
	
	private Writer writer = new Writer();


	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
	public void insertWriter(Writer writer) {
//		writer.setBirthday(birthdayS);
		bookshelf.insertWriter(writer);
	}
	
	public void createWriter() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "writer_create.xhtml");
	}



	

}
