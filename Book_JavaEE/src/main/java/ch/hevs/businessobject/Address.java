package ch.hevs.businessobject;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String postalCode;
	private String street;
	private String city;
		
	// constructors
	public Address(){
		
	}
	public Address(String postalCode, String street, String city) {
		this.postalCode = postalCode;
		this.street = street;
		this.city = city;
	}
	
	/**
	 * Get the postal code
	 * 
	 * @return postalCode postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Set the postal code
	 * 
	 * @param postalCode the postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get the street
	 * 
	 * @return the address street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set the Street
	 * 
	 * @param street 
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Get the city of the address
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set the city of the address
	 * 
	 * @param city the city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
