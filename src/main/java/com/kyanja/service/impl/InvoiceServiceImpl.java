package com.kyanja.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.controller.ShoppingCartController;
import com.kyanja.dao.InvoiceDao;
import com.kyanja.model.Invoice;
import com.kyanja.model.Order;
import com.kyanja.service.InvoiceService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.ui.jasperreports.JasperReportsUtils;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Value("${invoice.logo.path}")
	private String logo_path;

	@Value("${invoice.template.path}")
	private String invoice_template;
	
	@Autowired
	private InvoiceDao invoiceDao;

	public File generateInvoiceFor(Order order, Locale locale) throws IOException {
		
		System.out.println(" generateInvoiceFor called==================================================");
		System.out.println("order================================================================"+order.getOrderNumber());
		System.out.println("langage================================================================"+locale.toString());

		File pdfFile = File.createTempFile("my-invoice", ".pdf");

		logger.info(String.format("Invoice pdf path : %s", pdfFile.getAbsolutePath()));
		
		System.out.println("Invoice pdf path==================================================+"+String.format("Invoice pdf path : %s", pdfFile.getAbsolutePath()));

		try (FileOutputStream pos = new FileOutputStream(pdfFile)) {
			// Load invoice JRXML template.
			final JasperReport report = loadTemplate();

			// Fill parameters map.
			final Map<String, Object> parameters = parameters(order, locale);

			// Create an empty datasource.
			final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
					Collections.singletonList("Invoice"));

			// Render the invoice as a PDF file.
			JasperReportsUtils.renderAsPdf(report, parameters, dataSource, pos);

			// return file.
			return pdfFile;
		} catch (final Exception e) {
			logger.error(String.format("An error occured during PDF creation: %s", e));
			throw new RuntimeException(e);
		}
	}

	// Fill template order params
	private Map<String, Object> parameters(Order order, Locale locale) {
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("logo", getClass().getResourceAsStream(logo_path));
		parameters.put("order", order);
		parameters.put("REPORT_LOCALE", locale);
		return parameters;
	}

	// Load invoice JRXML template
	private JasperReport loadTemplate() throws JRException {

		logger.info(String.format("Invoice template path : %s", invoice_template));
		
		System.out.println("Invoice template path "+String.format("Invoice template path : %s", invoice_template));
		System.out.println(String.format("logo_path : %s", logo_path));

		final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template);
		final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

		return JasperCompileManager.compileReport(jasperDesign);
	}

	@Transactional
	public String addInvoice(Invoice i) {
		
		return invoiceDao.addInvoice(i);
	}

	@Transactional
	public void updateOrder(Invoice i) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteInvoice(String invoiceNumber) {
	
		invoiceDao.deleteInvoice(invoiceNumber);
		
	}

	@Transactional
	public Invoice findInvoiceById(String invoiceNumber) {
		
		return invoiceDao.findInvoiceById(invoiceNumber);
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	public String getInvoice_template() {
		return invoice_template;
	}

	public void setInvoice_template(String invoice_template) {
		this.invoice_template = invoice_template;
	}
	
	

}
