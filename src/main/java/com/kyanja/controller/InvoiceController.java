package com.kyanja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyanja.model.Invoice;
import com.kyanja.model.Order;
import com.kyanja.service.IOrderService;
import com.kyanja.service.InvoiceService;
import com.kyanja.service.impl.MockOrderService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_PDF;

@Controller
@RequestMapping("/invoice/generator")
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Resource
	private MockOrderService mockOrderService;
	@Resource
	private InvoiceService invoiceService;
	
	@Autowired
	private IOrderService orderService;
	
	

	// display invoice generator : /resources/templates/forms.html
	@GetMapping("/forms")
	public String invoiceForms() {
		return "forms";
	}

	@GetMapping("/invoicetest")
	@ResponseBody
	public String invoiceTest(@RequestParam String orderNumber) {
		
		System.out.println("invoiceTest called======================================================");

		logger.info("Start invoice generation...");
		

		Order order = orderService.findOrderById(orderNumber);

		Invoice invoice = new Invoice();
		
		invoice.setOrder(order);
		
		invoice.setCustomer(order.getCustomer());

		String invoiceNumber = invoiceService.addInvoice(invoice);

		invoice.setInvoiceNumber(invoiceNumber);

		order.setInvoice(invoice);

	

		System.out.println(
				"invoice saved by invoice number: ==============================================================="
						+ invoiceNumber);

		try {
			invoiceService.generateInvoiceFor(order, Locale.FRANCE);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		logger.info("Invoice generated successfully...");
		return " OrderNumber: " + orderNumber;
	}

	// generate invoice pdf
	@PostMapping(value = "/generate", produces = "application/pdf")
	public ResponseEntity<InputStreamResource> invoiceGenerate(
			@RequestParam(name = "orderNumber") String orderNumber,
			@RequestParam(name = "lang", defaultValue = "en") String lang) throws IOException {
		System.out.println("Start invoice generation.................................................");
		final Order order = orderService.findOrderById(orderNumber);
		final File invoicePdf = invoiceService.generateInvoiceFor(order, Locale.forLanguageTag(lang));
		
		System.out.println("Invoice generated successfully..........................................");

		final HttpHeaders httpHeaders = getHttpHeaders(orderNumber, lang, invoicePdf);
		return new ResponseEntity<>(new InputStreamResource(new FileInputStream(invoicePdf)), httpHeaders, OK);
	}

	private HttpHeaders getHttpHeaders(String code, String lang, File invoicePdf) {
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentType(APPLICATION_PDF);
		respHeaders.setContentLength(invoicePdf.length());
		respHeaders.setContentDispositionFormData("attachment", format("%s-%s.pdf", code, lang));
		return respHeaders;
	}
}