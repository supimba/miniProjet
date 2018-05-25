package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Book class provides the information about the book.
 */
@Entity
@Table(name="Livre")
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Writer> writers;
	@OneToMany(mappedBy = "book")
	private List<Category> categories;
	
	// constructors
	public Book(){

	}
	public Book(String isbn, String title, String summary, String year, String language) {
		writers = new ArrayList<>(); 
		this.isbn = isbn;
		this.title = title;
		this.summary = summary;
		this.year = year;
		this.language = language;
	}

	/**
	 * Gets the book id.
	 *  
	 * @return long  the id value of the book
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the book id.
	 *  
	 * @param long  the id value of the book
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the book isbn code.
	 *  
	 * @return String  the isbn code value of the book
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the book isbn code.
	 *  
	 * @param String  the isbn code value of the book
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the book title.
	 *  
	 * @return String  the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the book title.
	 *  
	 * @param String  the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the book summary.
	 *  
	 * @return String  the summary of the book
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the book summary.
	 *  
	 * @param String  the summary of the book
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Gets the publication year of the book.
	 *  
	 * @return String  the publication year of the book
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the publication year of the book.
	 *  
	 * @param String  the publication year of the book
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets the language of the book.
	 *  
	 * @return String  the language of the book
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language of the book.
	 *  
	 * @param String  the language of the book
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Gets all the writers of the book.
	 * 
	 * @return List<Writter>  all writers of the book
	 */
	public List<Writer> getWriters(){
		return writers; 
	}
	
	/**
	 * Add a writer to a book.
	 * 
	 * @param writer  the writer to add
	 */
	public void addWriter(Writer writer){
		this.writers.add(writer);
		
		// helpers method
		List<Book> books = writer.getBooks(); 
		books.add(this);
//		writer.setBook(this);
	}
	
	/**
	 * Remove a writer of a book.
	 * 
	 * @param writer  the writer to remove
	 */
	public void removeWriter(Writer writer){
		
		for (Writer w : writers){
			if (w.getId() == writer.getId())
				writers.remove(w); 
		}
		
		this.writers.remove(writer); 
		
		// helpers method
		List<Book> books = writer.getBooks(); 
		for(Book b: books)
			if(b.getId() == this.getId())
				books.remove(b); 
		
	}
	
	/**
	 * Add a category to a book.
	 * 
	 * @param category  the category to add
	 */
	public void addCategory(Category category){
		this.categories.add(category);
	}
	
	/**
	 * Remove a category of a book.
	 * 
	 * @param category  the category to remove
	 */
	public void removeCategory(Category category){
		
		for (Category c : categories){
			if (c.getId() == category.getId())
				writers.remove(c); 
		}
	}
	
	@Override
	public String toString() {
		String result = id + "-" + isbn + "-" + title;
		return result;
	}
}
