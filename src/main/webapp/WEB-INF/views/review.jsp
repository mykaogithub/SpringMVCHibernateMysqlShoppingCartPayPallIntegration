<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<title>Kyanja Review Shopping Cart</title>
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
	<div align="center">
		<form action="${pageContext.request.contextPath}/execute_payment"
			method="post">
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
							role="button">Review your order before proceeding with the payment ? </a>
					</p>
				</div>
			</div>


			<div class="col-lg-12 pl-3 pt-3">

				<table class="table table-hover border bg-white">


					<thead>
						<tr>
							<th>
								<h4>
									<b> Payment Details </b>
								</h4>
							</th>

						</tr>
					</thead>





					<tbody>
					<tbody>
						<tr>
							<td colspan="2"><b>Transaction Details:</b></td>
							<td><input type="hidden" name="paymentId"
								value="${param.paymentId}" /> <input type="hidden"
								name="PayerID" value="${param.PayerID}" /></td>
						</tr>
						<tr>
							<td>Description:</td>
							<td>${transaction.description}</td>
						</tr>
						<tr>
							<td>Subtotal:</td>
							<td>${transaction.amount.details.subtotal}USD</td>
						</tr>
						<tr>
							<td>Shipping:</td>
							<td>${transaction.amount.details.shipping}USD</td>
						</tr>
						<tr>
							<td>Tax:</td>
							<td>${transaction.amount.details.tax}USD</td>
						</tr>
						<tr>
							<td>Total:</td>
							<td>${transaction.amount.total}USD</td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td colspan="2"><b>Payer Information:</b></td>
						</tr>
						<tr>
							<td>First Name:</td>
							<td>${payer.firstName}</td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td>${payer.lastName}</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td>${payer.email}</td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td colspan="2"><b>Shipping Address:</b></td>
						</tr>
						<tr>
							<td>Recipient Name:</td>
							<td>${shippingAddress.recipientName}</td>
						</tr>
						<tr>
							<td>Line 1:</td>
							<td>${shippingAddress.line1}</td>
						</tr>
						<tr>
							<td>City:</td>
							<td>${shippingAddress.city}</td>
						</tr>
						<tr>
							<td>State:</td>
							<td>${shippingAddress.state}</td>
						</tr>
						<tr>
							<td>Country Code:</td>
							<td>${shippingAddress.countryCode}</td>
						</tr>
						<tr>
							<td>Postal Code:</td>
							<td>${shippingAddress.postalCode}</td>
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


						<tr>

						<tr>
							<td><button class="btn btn-info btn-large" type="submit">
								PAY NOW <i class="fa fa-edit-o"> </i>
							</button></td>
					</tr>
					
						
					</tfoot>
				</table>
			</div>

		</form>
	</div>
</body>
</html>