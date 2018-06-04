package ch.hevs.managedbeans;

import javax.ejb.EJB;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Writer;

public class WriterBean {
	
	@EJB
	private BookShelf bookshelf; 
	
	private Writer writer;

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
	public void insertWriter(Writer writer) {
		bookshelf.insertWriter(writer);
	}
	

}
