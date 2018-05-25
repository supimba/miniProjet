package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Category class provides the book category information.
 */
@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="nomCategorie")
	private String nameCategory;
	@Column(name="type")
	private String type;
	
	// relations
	@ManyToOne
	private Book book; 
	
	
	// constructors	
	public Category(){
		
	}
	public Category(String nameCategory, String type) {
		this.nameCategory = nameCategory;
		this.type = type;
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
	
	/**
	 * Gets the type of the category.
	 *  
	 * @return String  the type of the category
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the category type.
	 *  
	 * @param String  the type of the category
	 */
	public void setType(String type) {
		this.type = type;
	}	
	
}
