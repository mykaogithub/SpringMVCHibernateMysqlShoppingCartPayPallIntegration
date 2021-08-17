<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<title>Checkout Shopping Cart</title>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
	
</script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/custom.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/paypall.css">

</head>
<body>
	<fieldset>

		<legend>Customer Order Information</legend>


		<form name="cartForm" method="post"
			action="${pageContext.request.contextPath}/shoppingcart/authorize_payment.html">
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Products</a>
					</div>
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Home</a>
					</div>
					<div class="navbar-header">
						<a class="navbar-brand" href="#">About</a>
					</div>
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Contact</a>
					</div>
				</div>
			</nav>


			<div class="jumbotron">
				<div class="container">
					<h1>${title}</h1>
					<p>
						<c:if test="${not empty msg}">
        About: ${msg}
      </c:if>
					</p>
					<p>
						<a class="btn btn-primary btn-lg"
							href="${pageContext.request.contextPath}/shoppingcart/cart"
							role="button">Modify your order by Adding other products to
							your Shopping Cart ? </a>
					</p>
				</div>
			</div>

			<div class="container main-section">
				<div class="row">
					<div class="col-lg-12 pb-2">
						<h1>Order Submitted Successfully!</h1>
						<p>
							Thank you for your order. Your order confirmation number is: <br>
						<pre>
							<strong><input type="text" name="orderNumber"
								value="${orderNumber}"></strong>
						</pre>



						<p>Please proceed with payment in order to complete your
							order.
					</div>
				</div>
				<div class="col-lg-12 pl-3 pt-3">

					<table class="table table-hover border bg-white">


						<thead>


							<th>
								<h4>
									<b> Order Summary </b>
								</h4>
							</th>
							<th>
								<h4>
									<b> Price 
								</h4> <b>
							</th>
							<th style="width: 10%;">
								<h4>
									<b> Quantity <b>
								</h4>
							</th>
							<th>
								<h4>
									<b> Subtotal <b>
								</h4>
							</th>



							</tr>
						</thead>
						<tbody>

							<c:set var="total" value="0"></c:set>
							<c:forEach var="item" items="${sessionScope.myCart}">
								<c:set var="total"
									value="${total+ item.product.price * item.quantity}"></c:set>
								<tr>
									<td>

										<div class="row">
											<div class="col-lg-2 Product-img">
												<img
													src="${pageContext.request.contextPath}/shoppingcart/photoProd?idProd=${item.product.id}"
													alt="..." class="img-responsive" />
											</div>

											<div class="col-lg-10">
												<h5 class="nomargin">
													<b> ${item.product.name} </b>
												</h5>
												<p>${item.product.description}</p>
											</div>
										</div>
									</td>
									<td><strong>${item.product.price} USD<strong></td>
									<td><strong> ${item.quantity}<strong></td>
									<td><strong> ${item.product.price * item.quantity}
											USD<strong></td>
								</tr>
							</c:forEach>
							<tr>

								<td colspan="2" class="hidden-xs"></td>

								<td class="hidden-xs text-center" style="width: 10%;"
									data-th="subtotal"><strong>Total Price USD: <input
										type="text" name="subtotal" class="form-control text-center"
										value="${total}">
								</strong></td>

							</tr>

							<tr>

								<td colspan="2" class="hidden-xs"></td>


								<td class="hidden-xs text-center" style="width: 10%;"
									data-th="tax"><strong>Tax USD: <input type="text"
										name="tax" class="form-control text-center" value="${5.00}">
								</strong></td>
							</tr>

							<tr>

								<td colspan="2" class="hidden-xs"></td>

								<td class="hidden-xs text-center" style="width: 10%;"
									data-th="shipping"><strong>Shipping USD: <input
										type="text" name="shipping" class="form-control text-center"
										value="${5.00}">
								</strong></td>


							</tr>
							<tr>

								<td colspan="2" class="hidden-xs"></td>

								<td class="hidden-xs text-center" style="width: 10%;"
									data-th="total"><strong>Total Amount USD: <input
										type="text" name="total" class="form-control text-center"
										value="${total + 5.00 + 5.00}">
								</strong></td>
							</tr>
						</tbody>
						<div class="payment-secure-logo">
							<img class="img-thumbnail"
								src="${pageContext.request.contextPath}/resources/images/paypal-logo.png"
								alt="PayPal Credit" /> </a>


						</div>
						<div class="payment-secure-logo">

							<table border="0" cellpadding="10" cellspacing="0" align="center">
								<tr>
									<td align="center"></td>
								</tr>
								<tr>
									<td align="center"><a
										href="https://www.paypal.com/webapps/mpp/paypal-popup"
										title="How PayPal Works"
										onclick="javascript:window.open('https://www.paypal.com/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes,resizable=yes, width=1060, height=700'); return false;"><img
											src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_SbyPP_mc_vs_dc_ae.jpg"
											border="0" alt="PayPal Acceptance Mark"></a></td>
								</tr>




							</table>

						</div>
						<tfoot>



							<td><button class="btn btn-info btn-large" type="submit">
									Checkout <i class="fa fa-edit-o"> </i>
								</button></td>
							</tr>
							<td><a type="button"
									href="${pageContext.request.contextPath}//invoice/generator/forms"
									class="btn btn-info btn-large"> <span
										class="fa fa-angle-right" aria-hidden="true"></span> Generate Invoice 
										
								</a>
							</td>

						</tfoot>
		</form>
	</fieldset>
</body>
</html>