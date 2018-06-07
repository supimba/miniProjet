package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Book class provides the information about the book.
 */
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="isbn")
	private String isbn;
	@Column(name="title")
	private String title;
	@Column(name="summary")
	private String summary;
	@Column(name="year")
	private String year;
	@Column(name="language")
	private String language;
	
	// relations
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "book_writers",
		joinColumns = { @JoinColumn(name = "book_id") },
		inverseJoinColumns = { @JoinColumn(name = "writer_id") })
	private Set<Writer> writers;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "book_categories",
		joinColumns = { @JoinColumn(name = "book_id") },
		inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private Set<Category> categories;
	
	// constructors
	public Book(){
		writers = new HashSet<>(); 
		categories = new HashSet<>();
	}
	public Book(String isbn, String title, String summary, String year, String language) {
		writers = new HashSet<>(); 
		categories = new HashSet<>();
		this.isbn = isbn;
		this.title = title;
		this.summary = summary;
		this.year = year;
		this.language = language;
	}

	/**
	 * Gets the book id.
	 *  
	 * @return long the id value of the book
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the book id.
	 *  
	 * @param id the id value of the book
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the book isbn code.
	 *  
	 * @return String the isbn code value of the book
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the book isbn code.
	 *  
	 * @param isbn the isbn code value of the book
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the book title.
	 *  
	 * @return String the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the book title.
	 *  
	 * @param title the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the book summary.
	 *  
	 * @return String the summary of the book
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the book summary.
	 *  
	 * @param summary the summary of the book
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Gets the publication year of the book.
	 *  
	 * @return String the publication year of the book
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the publication year of the book.
	 *  
	 * @param year the publication year of the book
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets the language of the book.
	 *  
	 * @return String the language of the book
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language of the book.
	 *  
	 * @param language the language of the book
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Gets all the writers of the book.
	 * 
	 * @return Set<Writer> all writers of the book
	 */
	public Set<Writer> getWriters(){
		return writers; 
	}
	
	/**
	 * Add a writer to a book.
	 * 
	 * @param writer the writer to add
	 */
	public void addWriter(Writer writer){
		this.writers.add(writer);
		writer.addBook(this);
	}
	
	/**
	 * Remove a writer of a book.
	 * 
	 * @param writer the writer to remove
	 */
	public void removeWriter(Writer writer){
		this.writers.remove(writer); 		
		writer.removeBook(this);
		
	}
	
	public Set<Category> getCategories()
	{
		return this.categories;
	}
	
	/**
	 * Add a category to a book.
	 * 
	 * @param category  the category to add
	 */
	public void addCategory(Category category){
		this.categories.add(category);
		category.addBook(this);
	}
	
	/**
	 * Remove a category of a book.
	 * 
	 * @param category  the category to remove
	 */
	public void removeCategory(Category category){
		this.categories.remove(category);
		category.removeBook(this);

	}
	
	/**
	 * Remove all categories from the book
	 */
	public void clearCategories(){
		categories.clear();
	}
	
	/**
	 * Remove all writers from the book
	 * 
	 */
	public void clearWriters(){
		writers.clear();
	}
	
	@Override
	public String toString() {
		String result = id + "-" + isbn + "-" + title;
		return result;
	}
}
