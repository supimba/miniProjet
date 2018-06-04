package ch.hevs.managedbeans;

import javax.ejb.EJB;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Category;

public class CategoryBean {
	
	@EJB
	private BookShelf bookshelf;
	
	private Category category = new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	} 
	
	public void insertCategory(Category category) {
		
		bookshelf.insertCategory(category);
	}

}
