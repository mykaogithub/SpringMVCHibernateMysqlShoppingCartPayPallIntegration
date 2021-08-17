package com.kyanja.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.dao.InvoiceDao;
import com.kyanja.model.Invoice;
import com.kyanja.model.Order;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {

	/* Get the class name to be printed on */
	private static final Logger logger = LoggerFactory.getLogger(InvoiceDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Override
	public String addInvoice(Invoice i) {


		sf.getCurrentSession().saveOrUpdate(i);
		
		System.out.println("invoice number generated===================================================="+ i.getInvoiceNumber());

		return i.getInvoiceNumber();
	}

	@Override
	public void updateOrder(Invoice i) {

		sf.getCurrentSession().update(i);

	}

	@Override
	public void deleteInvoice(String invoiceNumber) {

		Invoice i = (Invoice) sf.getCurrentSession().load(Invoice.class, invoiceNumber);

		if (i != null) {

			sf.getCurrentSession().delete(i);
		}

	}

	@Override
	public Invoice findInvoiceById(String invoiceNumber) {

		System.out.println("findInvoiceById in dao layer called==================================");
		System.out.println("invoiceNumber in dao layer called==================================" + invoiceNumber);

		Session session = sf.getCurrentSession();

		Invoice invoice = null;

		try {


			invoice = (Invoice) session.load(Invoice.class, invoiceNumber); 
		      System.out.println("customer firstname invoice===========================================" +invoice.getCustomer().getFirstName()); 

		} catch (Exception e) {
			e.printStackTrace();

		}

		return invoice;
	}

}
