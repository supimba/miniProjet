package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Category class provides the book category information.
 */
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="nomCategorie")
	private String nameCategory;
	
	// relations
	@ManyToMany(mappedBy="categories")
	private Set<Book> books; 
	
	
	// constructors	
	public Category(){
	books = new HashSet<>();
		
	}
	public Category(String nameCategory) {
		books = new HashSet<>();
		this.nameCategory = nameCategory;
	}

	/**
	 * Gets the category id.
	 *  
	 * @return long  the id value of the category
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the category id.
	 *  
	 * @param long  the id value of the category
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the category name.
	 *  
	 * @return String  the name of the category
	 */
	public String getNameCategory() {
		return nameCategory;
	}
	
	/**
	 * 
	 * Sets the category name.
	 *  
	 * @param String  the name of the category
	 */
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
		//book.addCategory(this);
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
		//book.removeCategory(this);
	}
}
