package com.kyanja.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.kyanja.model.Customer;
import com.paypal.api.payments.ShippingAddress;

public class CustomerDto {

	private String firstName;

	private String lastName;

	private String email;

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

	private String birthDate;
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

	private ShippingAddressDto shippingAdressDto;

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

	/**
	 * Create CustomerDto from CustomerOrder
	 */

	public CustomerDto createCustomerDto(Customer customer) {

		CustomerDto customerDto = new CustomerDto();

		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
//    	customerDto.setBirthDate(getStringFromDate(customer.getBirthDate()));
    	customerDto.setBirthDate(getStringFromDate(customer.getDateOfBirth()));
		customerDto.setCountryCode(customer.getCountryCode());
		customerDto.setPayerId(customer.getPayerId());
		customerDto.setPhone(customer.getPhone());
		customerDto.setPhoneType(customer.getPhoneType());

		return customerDto;

	}

	public ShippingAddressDto getShippingAdressDto() {
		return shippingAdressDto;
	}

	public void setShippingAdressDto(ShippingAddressDto shippingAdressDto) {
		this.shippingAdressDto = shippingAdressDto;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

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

	@Override
	public String toString() {
		return "CustomerDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", suffix="
				+ suffix + ", payerId=" + payerId + ", phone=" + phone + ", phoneType=" + phoneType + ", birthDate="
				+ birthDate + ", taxId=" + taxId + ", taxIdType=" + taxIdType + ", countryCode=" + countryCode
				+ ", shippingAdressDto=" + shippingAdressDto + "]";
	}

	String getStringFromDate(Date date) {

		String pattern = "YYYY-MM-DD";

		// Create an instance of SimpleDateFormat used for formatting
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern,Locale.ENGLISH);

		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String dateAsString = df.format(date);

		// Print the result!
		System.out.println("Date as String is: " + dateAsString);

		return dateAsString;

	}

}
