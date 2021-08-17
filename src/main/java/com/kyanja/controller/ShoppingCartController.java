package com.kyanja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kyanja.dto.CustomerDto;
import com.kyanja.dto.OrderDetailDto;
import com.kyanja.dto.OrderDto;
import com.kyanja.dto.ShippingAddressDto;
import com.kyanja.model.Customer;
import com.kyanja.model.Items;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;
import com.kyanja.model.OrderStatus;
import com.kyanja.model.Product;
import com.kyanja.model.ShippingAddress;
import com.kyanja.service.ICustomerService;
import com.kyanja.service.IOrderDetailService;
import com.kyanja.service.IOrderService;
import com.kyanja.service.IProductService;
import com.kyanja.service.impl.PaymentServices;
import com.paypal.api.payments.Item;
import com.paypal.base.rest.PayPalRESTException;

@Controller
@RequestMapping(value = "/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private IProductService pm;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IOrderDetailService orderDetailsService;

	@Autowired
	private PaymentServices paymentServices;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ordernow/{id}", method = RequestMethod.GET)
	public String ordernow(@PathVariable(value = "id") Integer id, ModelMap mm, HttpSession session) {

		if (session.getAttribute("myCart") == null) {
			List<Items> cart = new ArrayList<Items>();
			cart.add(new Items(this.pm.findProductById(id), 1));
			session.setAttribute("myCart", cart);
		} else {
			List<Items> cart = (List<Items>) session.getAttribute("myCart");

			// using method isExisting here
			int index = isExisting(id, session);
			if (index == -1)
				cart.add(new Items(this.pm.findProductById(id), 1));
			else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}

			session.setAttribute("myCart", cart);
		}

		return "cart"; // page name
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") int id, HttpSession session) {

		List<Items> cart = (List<Items>) session.getAttribute("myCart");

		int index = isExisting(id, session);
		cart.remove(index);
		session.setAttribute("myCart", cart);
		return "cart";
	}

	@SuppressWarnings("unchecked")
	private int isExisting(Integer id, HttpSession session) {

		List<Items> cart = (List<Items>) session.getAttribute("myCart");

		for (int i = 0; i < cart.size(); i++)

			if (cart.get(i).getProduct().getId() == id)
				return i;

		return -1;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Integer idProd) throws IOException {

		Product p = pm.findProductById(idProd);
		File f = new File(System.getProperty("java.io.tmpdir") + "/PROD_" + idProd + "_" + p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@SuppressWarnings("unchecked")

	@RequestMapping(value = "/update", method = RequestMethod.POST)

	String updateMyCartQuantity(HttpServletRequest request, HttpSession session)

	{

		if (session.getAttribute("myCart") != null) {
			List<Items> cart = (List<Items>) session.getAttribute("myCart");
			System.out.println("getCartInSession is:============================================" + cart);
			String[] quantity = request.getParameterValues("quantity");
			System.out.println(
					"quantity array in cart session before update  is:============================================"
							+ quantity.toString());
			for (int i = 0; i < cart.size(); i++) {
				cart.get(i).setQuantity(Integer.parseInt(quantity[i]));

				System.out.println("quantity after update:============================================" + quantity[i]);
			}

			session.setAttribute("myCart", cart);

		}

		return "cart";

	}

	@SuppressWarnings("unchecked")

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)

	String checkoutMyCart()

	{

		return "checkout";

	}

	@SuppressWarnings("unchecked")

	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	@ResponseBody

	ModelAndView placeMyOrderCart(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			ModelMap model, @ModelAttribute("customer") Customer customer, BindingResult result)
			throws ServletException, IOException, ParseException

	{

		List<Items> cart = (List<Items>) session.getAttribute("myCart");

//      Create  a New Shipping address

		ShippingAddress address = new ShippingAddress();
		address.setCity(request.getParameter("city"));
		address.setCountryCode(request.getParameter("countryCode"));
		address.setLine1(request.getParameter("line1"));
		address.setLine2(request.getParameter("line2"));
		address.setPostalCode(request.getParameter("postalCode"));
		address.setCountryName(request.getParameter("countryName"));

//      Create  a New Customer

//		Customer customer = new Customer();

		customer.setFirstName(request.getParameter("firstName"));
		System.out.println("firstName====================================================================="
				+ request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		System.out.println("lastName====================================================================="
				+ request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		System.out.println("email====================================================================="
				+ request.getParameter("email"));
		customer.setPhone(request.getParameter("phone"));
		System.out.println("phone====================================================================="
				+ request.getParameter("phone"));
		String str = request.getParameter("birthDate");
		System.out.println("birthDate originale as tring=======================================" + "\t" + str);
		
		try {

			Date customerBirthdate = new SimpleDateFormat("yyyy-mm-dd")
					.parse(request.getParameter("dateOfBirth"));
//			customer.setBirthDate(customerBirthdate);
			
			customer.setDateOfBirth(customerBirthdate);

			System.out.println(request.getParameter("dateOfBirth") + "\t" + customerBirthdate);
//			System.out.println(request.getParameter("birthDate") + "\t" + customer.getBirthDate());
			System.out.println(request.getParameter("dateOfBirth") + "\t" + customer.getDateOfBirth());

		} catch (ParseException e) {
			e.printStackTrace();
		}
     
		

		
	

		customer.setShippingDetail(address);

		customerService.addCustomer(customer);

		System.out.println(
				"cusmtomer has been saved=================================================" + customer.toString());

//        Create  a New Order

		Order myOrder = new Order();

		myOrder.setCustomer(customer);

		myOrder.setPurchaseDate(new Date());

		myOrder.setOrderAmount(getTotalPrice(session));

		myOrder.setOrderStatus(OrderStatus.INPROGRESS);

		String orderNumber = orderService.addOrder(myOrder);

		System.out.println(
				"your order confirmation has been generated saved==============================================================="
						+ orderNumber);

		System.out.println("your order has been saved==============================================================="
				+ myOrder.toString());

		System.out.println("orderNumber====================================================" + orderNumber);

		model.addAttribute("orderNumber", orderNumber);

		double totalpriceCart = 0;
		for (int i = 0; i < cart.size(); i++) {

//	        Create  Order details

			OrderDetail newOrderDetail = new OrderDetail();

			newOrderDetail.setOrderLineNumber(Long.toString(cart.get(i).getProduct().getId()));

			newOrderDetail.setPriceEach((float) (cart.get(i).getProduct().getPrice()));

			newOrderDetail.setQuantityOrdered(cart.get(i).getQuantity());

			newOrderDetail.setProductName(cart.get(i).getProduct().getName());

			newOrderDetail.setSubtotal((float) (cart.get(i).getQuantity() * cart.get(i).getProduct().getPrice()));

//			newOrderDetail.setTotal((float) getTotalPrice(session));

			newOrderDetail.setOrder(myOrder);

			orderDetailsService.addOrderDetails(newOrderDetail);

			System.out.println("fetch orderDetails by OrderLineNumber=============================================="
					+ orderDetailsService.findOrderDetailById(newOrderDetail.getId()).toString());

//			session.removeAttribute("myCart");

			System.out.println("orderDetails has been saved============================================"
					+ newOrderDetail.toString());

		}
		return new ModelAndView("confirmation", model);

	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String checkout(Model model) {

		return "cart";

	}

	@RequestMapping(value = "/checkout1", method = RequestMethod.GET)

	String testMycheckoutMyCart()

	{

		return "checkout";

	}

	@RequestMapping(value = "/authorize_payment", method = RequestMethod.POST)
	public ModelAndView authorizePayment(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			HttpSession session 
    ) throws ServletException, IOException {

		System.out.println("authorizePayment called======================================================");

		ModelAndView mav = new ModelAndView();
		String product = request.getParameter("product");

		System.out.println("product input value is======================================================" + product);
		String subtotal = request.getParameter("subtotal");
		System.out.println("subtotal input value is======================================================" + subtotal);
		String shipping = request.getParameter("shipping");
		System.out.println("shipping input value is======================================================" + shipping);
		String tax = request.getParameter("tax");
		System.out.println("tax input value is======================================================" + tax);
		String total = request.getParameter("total");
		System.out.println("total input value is======================================================" + total);

		String orderNumber = request.getParameter("orderNumber");

		System.out.println(
				"confirmationNumber value in the session cart is: ======================================================"
						+ orderNumber);

		double totalPrice = getTotalPrice(session);

		System.out.println(
				"totalPrice value in the session cart is: ======================================================"
						+ totalPrice);

		mav.addObject("product", product);
		mav.addObject("subtotal", subtotal);
		mav.addObject("shipping", shipping);
		mav.addObject("tax", tax);
		mav.addObject("total", total);
		mav.addObject("orderNumber", orderNumber);

		ShippingAddressDto shippingAdressDto = new ShippingAddressDto();

		OrderDto orderDto = new OrderDto();

		orderDto.setOrderNumber(orderNumber);

		CustomerDto customerDto = new CustomerDto();

		Customer customer = orderService.findCustomerByOrderId(orderNumber);

//		customerDto.createCustomerDto(customer);
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setPhone(customer.getPhone());
		customerDto.setPhoneType(customer.getPhoneType());
		customerDto.setPayerId(customer.getPayerId());
		customerDto.setCountryCode(customer.getCountryCode());

//		customerDto.setBirthDate(getStringFromDate(customer.getBirthDate()));
		
		customerDto.setBirthDate(getStringFromDate(customer.getDateOfBirth()));

//		System.out
//				.println("customer birth date from databse============================================================"
//						+ customer.getBirthDate());
		
		System.out
		.println("customer birth date from databse============================================================"
				+ customer.getDateOfBirth());

		System.out
				.println("customerDTo birth date as String============================================================"
						+ customerDto.getBirthDate());

		shippingAdressDto.setCity(customer.getShippingDetail().getCity());

		shippingAdressDto.setLine1(customer.getShippingDetail().getLine1());
		shippingAdressDto.setLine2(customer.getShippingDetail().getLine2());
		shippingAdressDto.setPostalCode(customer.getShippingDetail().getPostalCode());
		shippingAdressDto.setCountryName(customer.getShippingDetail().getCountryName());
		shippingAdressDto.setCountryCode(
				customer.getShippingDetail().getCountryCodeByCountryName(shippingAdressDto.getCountryName()));

		customerDto.setShippingAdressDto(shippingAdressDto);

		orderDto.setCustomerDto(customerDto);

		OrderDetailDto orderDetailDto = new OrderDetailDto();

		@SuppressWarnings("unchecked")
		List<Items> cart = (List<Items>) session.getAttribute("myCart");

		List<Item> items = new ArrayList<Item>();

		for (Items cartItem : cart) {

			Item item = new Item();

//	        Create  OrderDto details

			orderDetailDto.setOrderDto(orderDto);

			orderDetailDto.setOrderLineNumber(Long.toString(cartItem.getProduct().getId()));

			orderDetailDto.setPriceEach((float) (cartItem.getProduct().getPrice()));

			orderDetailDto.setQuantityOrdered(cartItem.getQuantity());

			orderDetailDto.setProductName(cartItem.getProduct().getName());

			orderDetailDto.setSubtotal((float) (getTotalPrice(session)));

			System.out.println(
					"subtotal value ============================================================================================"
							+ orderDetailDto.getSubtotal());

			orderDetailDto.setShipping(Float.parseFloat(shipping));

			orderDetailDto.setTax(Float.parseFloat(tax));

			orderDetailDto
					.setTotal((float) (getTotalPrice(session)) + Float.parseFloat(shipping) + Float.parseFloat(tax));

			System.out.println(
					"total value ================================================================================================="
							+ orderDetailDto.getTotal());

			orderDetailDto.setOrderLineNumber(orderDetailDto.getOrderLineNumber());

			// Adding item to our list

			item.setName(orderDetailDto.getProductName())
					.setQuantity(Integer.toString(orderDetailDto.getQuantityOrdered())).setCurrency("USD")
					.setPrice(orderDetailDto.getPriceEach());

			items.add(item);

			System.out.println(
					"items orderd =============================================================" + items.toString());

		}

		try {

			String approvalLink = paymentServices.authorizePayment(orderDetailDto, items);

			response.sendRedirect(approvalLink);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();

			return new ModelAndView("error", model);
		}

		model.addAttribute("attribute", "authorize_payment");

		return new ModelAndView("review", model);

	}

	// Get the total price of items in the cart session
	public double getTotalPrice(HttpSession session) {

		System.out.println("getTotalPrice called====================================================");

		@SuppressWarnings("unchecked")
		List<Items> cart = (List<Items>) session.getAttribute("myCart");
		double result = 0;
		for (int i = 0; i < cart.size(); i++) {
			result += cart.get(i).getQuantity() * cart.get(i).getProduct().getPrice();
		}
		return result;
	}

	String getStringFromDate(Date date) {

		String pattern = "yyyy-mm-dd";

		// Create an instance of SimpleDateFormat used for formatting
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);

		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String dateAsString = df.format(date);

		// Print the result!
		System.out.println(
				"Date as String is============================================================: " + dateAsString);

		return dateAsString;

	}
}
