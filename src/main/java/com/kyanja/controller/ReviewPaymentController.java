package com.kyanja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kyanja.service.impl.PaymentServices;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@Controller
@RequestMapping(value = "/PaypalTest")

public class ReviewPaymentController {

	@RequestMapping(value = "/review_payment", method = RequestMethod.GET)
	public ModelAndView reviewPayment(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");

		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.getPaymentDetails(paymentId);

			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);

			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

			System.out.println(
					"payerInfo===================================================================" + payerInfo);
			System.out.println(
					"shippingAddress===================================================================" + payment);
			System.out.println(
					"transaction===================================================================" + transaction);



			model.addAttribute("payer", payerInfo);
			model.addAttribute("transaction", transaction);
			model.addAttribute("shippingAddress", shippingAddress);

			String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;

			mav.addObject("url", url);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			mav.setViewName("error");
		}
		model.addAttribute("attribute", "review_payment");

		return new ModelAndView("review", model);
	}
}
