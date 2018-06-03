package ch.hevs.businessobject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 * The Writer class provides information about the book writer.
 */
@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name="nom")
	private String lastname;
	@Column(name="prenom")
	private String firstname;
	@Column(name="gender")
	private String genre;
	@Column(name="dateAnniversaire")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthday;
	@Column(name="biographie")
	private String biography;
	@Embedded
	private Address address;
	private String name; 
	
	// relations
	@ManyToMany(mappedBy="writers")
	private Set<Book> books;
	
	// constructors
	public Writer(){
		books = new HashSet(); 
	}
	public Writer(String lastname, String firstname, String genre, Date birthday, String biography) {
		books = new HashSet<>(); 
		this.lastname = lastname;
		this.firstname = firstname;
		this.genre = genre;
		this.birthday = birthday;
		this.biography = biography;
	}

	/**
	 * Gets the writer id.
	 *  
	 * @return long  the id value of the writer
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the writer id.
	 *  
	 * @param long  the id value of the writer
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the writer last name.
	 *  
	 * @return String  the last name of the writer
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the writer last name.
	 *  
	 * @param String  the last name of the writer
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the writer first name.
	 *  
	 * @return String  the first name of the writer
	 */
	public String getFirstname() {
		return firstname;
	}
	
	public String getName(){
		this.name = firstname +" "+ lastname;
		return name;
	}

	/**
	 * Sets the writer first name.
	 *  
	 * @param String  the first name of the writer
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the gender.
	 *  
	 * @return String  the gender of the writer
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the gender.
	 *  
	 * @param String  the gender of the writer
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the writers birthday  .
	 *  
	 * @return Date  the gender of the writer
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the writer birthday.
	 *  
	 * @param String  the birthday of the writer
	 */
	public void setBirthday(String birthday) {
		String someDate = birthday;
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
		Date date = new Date();
		try {
			date = sdf.parse(someDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.birthday = date;
	}

	/**
	 * Gets the writer biography.
	 *  
	 * @return String  the biography of the writer
	 */
	public String getBiography() {
		return biography;
	}

	/**
	 * Sets the writer biography.
	 *  
	 * @param String  the biography of the writer
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	/**
	 * Remove a writer of a book.
	 * 
	 * @param writer  the writer to remove
	 */
	public void removeBook(Book book){
		this.books.remove(book); 
		//book.removeWriter(this);

	}
	
	public void addBook(Book book){
		this.books.add(book);
		//book.addWriter(this);

	}
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
}
