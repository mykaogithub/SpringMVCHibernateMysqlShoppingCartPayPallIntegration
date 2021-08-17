package com.kyanja.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kyanja.dto.OrderDetailDto;
import com.kyanja.service.IOrderService;
import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Component
public class PaymentServices {
	private static final String CLIENT_ID = "ARsFQk_Eg7l_O1N4xDgVJlVZt5n8Qy6epDE_sQ4OCsmd04AQAmAQc_15pxF7inpv00vSkjDL_W6YbY94";
	private static final String CLIENT_SECRET = "EJsFmKYRBlRdOgZ6CskX4b3EE3UeoSkSBnn1gwCJ7HZtcU-tSGvoDHRcoNQtyHywBpK1nqkncIaPcmbI";
	private static final String MODE = "sandbox";

	@Autowired
	private IOrderService orderService;

	public String authorizePayment(OrderDetailDto orderDetailDto, List<Item> items) throws PayPalRESTException {

		Payer payer = getPayerInformation(orderDetailDto);
		RedirectUrls redirectUrls = getRedirectURLs();

		List<Transaction> listTransaction = getTransactionInformation(orderDetailDto, items);

		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		Payment approvedPayment = requestPayment.create(apiContext);

		return getApprovalLink(approvedPayment);

	}

	@SuppressWarnings("deprecation")
	private Payer getPayerInformation(OrderDetailDto orderDetailDto) {

		System.out.println("getPayerInformation called=================================================");

		Payer payer = new Payer();

		String firstname = orderDetailDto.getOrderDto().getCustomerDto().getFirstName();
		String lastname = orderDetailDto.getOrderDto().getCustomerDto().getLastName();
		String email = orderDetailDto.getOrderDto().getCustomerDto().getEmail();
		String phone = orderDetailDto.getOrderDto().getCustomerDto().getPhone();
		String birthDate= orderDetailDto.getOrderDto().getCustomerDto().getBirthDate();
     
		
		PayerInfo payerInfo = new PayerInfo();
		Address billingAddress = new Address();

		System.out.println("phone=================================" + phone);
		System.out.println("payerInfo=================================" + payerInfo.toString());
		System.out.println("payerInfo JSON=================================" + payerInfo.toJSON());

		System.out.println("Converted birthdate String:================================================================================ " + birthDate);
		payerInfo.setFirstName(firstname).setLastName(lastname).setEmail(email).setBirthDate(birthDate);

	


		
		
        

		System.out.println("payerInfo birthdate======================================================================" + payerInfo.getBirthDate());

		System.out.println("payerInfo BirthDate=================================" + payerInfo.getBirthDate());

		billingAddress.setCity(orderDetailDto.getOrderDto().getCustomerDto().getShippingAdressDto().getCity());
		billingAddress
				.setCountryCode(orderDetailDto.getOrderDto().getCustomerDto().getShippingAdressDto().getCountryCode());
		billingAddress
				.setPostalCode(orderDetailDto.getOrderDto().getCustomerDto().getShippingAdressDto().getPostalCode());
		billingAddress.setLine1(orderDetailDto.getOrderDto().getCustomerDto().getShippingAdressDto().getLine1());
		billingAddress.setLine2(orderDetailDto.getOrderDto().getCustomerDto().getShippingAdressDto().getLine2());
		billingAddress.setPhone(orderDetailDto.getOrderDto().getCustomerDto().getPhone());


		System.out.println("shippingAddress=================================" + billingAddress);

		payerInfo.setBillingAddress(billingAddress);

		payer.setPaymentMethod("paypal");
		payer.setPayerInfo(payerInfo);
		


		return payer;
	}

	private RedirectUrls getRedirectURLs() {

		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/ShoppingCartSpringMVCHibernateBasic/PaypalTest/cancel.html");
		redirectUrls
				.setReturnUrl("http://localhost:8080/ShoppingCartSpringMVCHibernateBasic/PaypalTest/review_payment");

		return redirectUrls;
	}

	private List<Transaction> getTransactionInformation(OrderDetailDto orderDetailDto, List<Item> items) {

		List<Transaction> listTransaction = new ArrayList<>();
		Details details = new Details();
		ItemList itemList = new ItemList();

		// Adding items to itemList

		itemList.setItems(items);

		System.out.println(
				"itemList orderd =============================================================" + itemList.toString());

		// Set payment details

		details.setShipping(orderDetailDto.getShipping());
		// itemOne cost: 5 itemTwo cost 15*2. So 5+30
		details.setSubtotal(orderDetailDto.getSubtotal());
		details.setTax(orderDetailDto.getTax());

		System.out.println(
				"details shipping=========================================================" + details.getShipping());
		System.out.println("details tax=========================================================" + details.getTax());
		System.out.println(
				"details subtotal=========================================================" + details.getSubtotal());

		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal. E.g. 1+35+1
		amount.setTotal(orderDetailDto.getTotal());
		amount.setDetails(details);

		System.out
				.println("ammount total=========================================================" + amount.getTotal());
		System.out.println(
				"ammount details=========================================================" + amount.getDetails());

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderDetailDto.getProductName());

		transaction.setItemList(itemList);

		System.out.println("transaction details========================================================="
				+ transaction.toString());

		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List

		listTransaction.add(transaction);

		System.out.println("listTransaction orderd ============================================================="
				+ listTransaction.toString());

		return listTransaction;
	}

	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;

		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}

		return approvalLink;
	}

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}

}