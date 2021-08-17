package com.kyanja.dao;

import com.kyanja.model.Invoice;

public interface InvoiceDao {
	
	
	

	String addInvoice(Invoice i);

	void updateOrder(Invoice i);

	void deleteInvoice (String invoiceNumber);

	Invoice findInvoiceById(String invoiceNumber);
	
	

}
