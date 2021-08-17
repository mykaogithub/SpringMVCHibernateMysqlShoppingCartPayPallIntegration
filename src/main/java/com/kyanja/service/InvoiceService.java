package com.kyanja.service;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import com.kyanja.model.Invoice;
import com.kyanja.model.Order;

public interface InvoiceService {
	
	public File generateInvoiceFor(Order order, Locale locale) throws IOException;
	
	String addInvoice(Invoice i);

	void updateOrder(Invoice i);

	void deleteInvoice (String invoiceNumber);

	Invoice findInvoiceById(String invoiceNumber);
	

}
