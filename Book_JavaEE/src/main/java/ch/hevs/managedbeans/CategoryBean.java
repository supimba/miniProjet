package ch.hevs.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ch.hevs.bookshelf.BookShelf;
import ch.hevs.businessobject.Category;

@ManagedBean
@ViewScoped
public class CategoryBean {

	@EJB
	private BookShelf bookshelf;
	private Category category = new Category();

	// create a new category
	public String insertCategory(Category category) {
		bookshelf.insertCategory(category);
		return "category_index.xhtml";
	}

	// get and set the new category
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
