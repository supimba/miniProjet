package ch.hevs.businessobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The Writer class provides information about the book writer.
 */
@Entity
@Table(name="Writer")
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
	private Date birthday;
	@Column(name="biographie")
	private String biography;
	@Embedded
	private Address address;
	
	// relations
	@ManyToOne
	private Book book;
	
	// constructors
	public Writer(){
		
	}
	public Writer(String lastname, String firstname, String genre, Date birthday, String biography) {
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
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
}