package com.kyanja.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;
	private String firstName;
	private String lastName;

	@Column(name = "customer_email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shippingAddress_id")
	private ShippingAddress shippingDetail;

	/**
	 * Suffix of the payer.
	 */
	private String suffix;
	/**
	 * PayPal assigned encrypted Payer ID.
	 */
	private String payerId;
	/**
	 * Phone number representing the payer. 20 characters max.
	 */
	private String phone;
	/**
	 * Phone type
	 */
	private String phoneType;
	/**
	 * Birth date of the Payer in ISO8601 format (yyyy-mm-dd).
	 */

	/*
	 * handles data-binding (parsing) and display if spring form tld or spring:eval
	 */

//	private Date birthDate;
	
	private Date dateOfBirth;
	/**
	 * Payer’s tax ID. Only supported when the `payment_method` is set to
	 * `paypal`.
	 */
	private String taxId;
	/**
	 * Payer’s tax ID type. Allowed values: `BR_CPF` or `BR_CNPJ`. Only supported
	 * when the `payment_method` is set to `paypal`.
	 */
	private String taxIdType;
	/**
	 * Two-letter registered country code of the payer to identify the buyer
	 * country.
	 */
	private String countryCode;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> invoices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ShippingAddress getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingAddress shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

//	public Date getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getTaxIdType() {
		return taxIdType;
	}

	public void setTaxIdType(String taxIdType) {
		this.taxIdType = taxIdType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", shippingDetail=" + shippingDetail + ", suffix=" + suffix + ", payerId=" + payerId + ", phone="
//				+ phone + ", phoneType=" + phoneType + ", birthDate=" + birthDate + ", taxId=" + taxId + ", taxIdType="
//				+ taxIdType + ", countryCode=" + countryCode + ", orders=" + orders + "]";
//	}

	
}
