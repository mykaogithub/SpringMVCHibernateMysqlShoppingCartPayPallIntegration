package com.kyanja.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

import com.kyanja.model.ShippingAddress;

public class ShippingAddressDto {

	/**
	 * Line 1 of the Address (eg. number, street, etc).
	 */
	private String line1;
	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 */
	private String line2;
	/**
	 * City name.
	 */
	private String city;
	/**
	 * 2 letter country code.
	 */
	private String countryCode;
	/**
	 * Zip code or equivalent is usually required for countries that have them. For
	 * list of countries that do not have postal codes please refer to
	 * http://en.wikipedia.org/wiki/Postal_code.
	 */
	private String postalCode;
	/**
	 * 2 letter code for US states, and the equivalent for other countries.
	 */
	private String state;
	/**
	 * BaseAddress normalization status, returned only for payers from Brazil.
	 */
	private String normalizationStatus;
	/**
	 * BaseAddress status
	 */
	private String status;

	/**
	 * Default Constructor
	 */

	/**
	 * Parameterized Constructor
	 */

	/**
	 * Line 1 of the Address (eg. number, street, etc).
	 */
	@java.lang.SuppressWarnings("all")
	public String getLine1() {
		return this.line1;
	}

	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 */
	@java.lang.SuppressWarnings("all")
	public String getLine2() {
		return this.line2;
	}

	/**
	 * City name.
	 */
	@java.lang.SuppressWarnings("all")
	public String getCity() {
		return this.city;
	}

	/**
	 * 2 letter country code.
	 */
	@java.lang.SuppressWarnings("all")
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * Zip code or equivalent is usually required for countries that have them. For
	 * list of countries that do not have postal codes please refer to
	 * http://en.wikipedia.org/wiki/Postal_code.
	 */
	@java.lang.SuppressWarnings("all")
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * 2 letter code for US states, and the equivalent for other countries.
	 */
	@java.lang.SuppressWarnings("all")
	public String getState() {
		return this.state;
	}

	/**
	 * BaseAddress normalization status, returned only for payers from Brazil.
	 */
	@java.lang.SuppressWarnings("all")
	public String getNormalizationStatus() {
		return this.normalizationStatus;
	}

	/**
	 * BaseAddress status
	 */
	@java.lang.SuppressWarnings("all")
	public String getStatus() {
		return this.status;
	}

	/**
	 * Line 1 of the Address (eg. number, street, etc).
	 * 
	 * @return this
	 */

	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 * 
	 * @return this
	 */

	/**
	 * City name.
	 * 
	 * @return this
	 */

	/**
	 * 2 letter country code.
	 * 
	 * @return this
	 */

	/**
	 * Zip code or equivalent is usually required for countries that have them. For
	 * list of countries that do not have postal codes please refer to
	 * http://en.wikipedia.org/wiki/Postal_code.
	 * 
	 * @return this
	 */

	/**
	 * 2 letter code for US states, and the equivalent for other countries.
	 * 
	 * @return this
	 */

	/**
	 * BaseAddress normalization status, returned only for payers from Brazil.
	 * 
	 * @return this
	 */

	/**
	 * BaseAddress status
	 * 
	 * @return this
	 */

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		result = result * PRIME + super.hashCode();
		final java.lang.Object $line1 = this.getLine1();
		result = result * PRIME + ($line1 == null ? 43 : $line1.hashCode());
		final java.lang.Object $line2 = this.getLine2();
		result = result * PRIME + ($line2 == null ? 43 : $line2.hashCode());
		final java.lang.Object $city = this.getCity();
		result = result * PRIME + ($city == null ? 43 : $city.hashCode());
		final java.lang.Object $countryCode = this.getCountryCode();
		result = result * PRIME + ($countryCode == null ? 43 : $countryCode.hashCode());
		final java.lang.Object $postalCode = this.getPostalCode();
		result = result * PRIME + ($postalCode == null ? 43 : $postalCode.hashCode());
		final java.lang.Object $state = this.getState();
		result = result * PRIME + ($state == null ? 43 : $state.hashCode());
		final java.lang.Object $normalizationStatus = this.getNormalizationStatus();
		result = result * PRIME + ($normalizationStatus == null ? 43 : $normalizationStatus.hashCode());
		final java.lang.Object $status = this.getStatus();
		result = result * PRIME + ($status == null ? 43 : $status.hashCode());
		return result;
	}

	public ShippingAddressDto(String line1, String line2, String city, String countryCode, String postalCode,
			String state, String normalizationStatus, String status) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.state = state;
		this.normalizationStatus = normalizationStatus;
		this.status = status;
	}

	public ShippingAddressDto() {
		super();
	}



	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setNormalizationStatus(String normalizationStatus) {
		this.normalizationStatus = normalizationStatus;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShippingAddressDto [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", countryCode="
				+ countryCode + ", postalCode=" + postalCode + ", state=" + state + ", normalizationStatus="
				+ normalizationStatus + ", status=" + status + ", countryName=" + countryName + "]";
	}

	
//	createShippingAddressDto from ShippingAddress
	
	public ShippingAddressDto createShippingAddressDto(ShippingAddress shippingAddress) {
		
		
		
		ShippingAddressDto shippingAddressDto = new ShippingAddressDto();
		
		shippingAddressDto.setCity(shippingAddress.getCity());
		shippingAddressDto.setCountryCode(shippingAddress.getCountryCode());
		shippingAddressDto.setLine1(shippingAddress.getLine1());
		shippingAddressDto.setLine2(shippingAddress.getLine2());
		shippingAddressDto.setPostalCode(shippingAddress.getPostalCode());

		
	
		return shippingAddressDto ;
		
		
	}
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	private String countryName;
	
	
	/**
	 * getCountryCodeByCountryName.
	 */
	public String getCountryCodeByCountryName(String countryName) {

	    // Get all country codes in a string array.
	    String[] isoCountryCodes = Locale.getISOCountries();
	    Map<String, String> countryMap = new HashMap<>();
	    Locale locale; 
	    String name;

	    // Iterate through all country codes:
	    for (String code : isoCountryCodes) {
	        // Create a locale using each country code
	        locale = new Locale("", code);
	        // Get country name for each code.
	        name = locale.getDisplayCountry();
	        // Map all country names and codes in key - value pairs.
	        countryMap.put(name, code);
	    }

	    // Return the country code for the given country name using the map.
	    // Here you will need some validation or better yet 
	    // a list of countries to give to user to choose from.
	    return countryMap.get(countryName); // "NL" for Netherlands.
	}
	
	
}
