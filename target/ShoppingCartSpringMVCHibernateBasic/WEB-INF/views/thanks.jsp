<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<title>Checkout Shopping Summary Cart</title>
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

</head>
<body>
	<form
		action="${pageContext.request.contextPath}/shoppingcart/authorize_customer_payment"
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


		<div class="jumbotron text-center">
			<h1 class="display-3">Thank You for your order!</h1>
			<p class="lead">
				<strong>Please confirm</strong> your order by completing the
				payment.
			</p>
			<hr>
			<p>
				Please click on checkout button<a> to confirm your payment </a> <input
					type="submit" value="Checkout" />
			</p>
			<p class="lead">
				<a class="btn btn-primary btn-sm"
					href="${pageContext.request.contextPath}/product/productlist.html"
					role="button">Continue Shopping</a>
			</p>
		</div>

		<table>
			<tr>
				<td>Product/Service:</td>
				<td><input type="text" name="product" value="Next iPhone" /></td>
			</tr>
			<tr>
				<td>Sub Total:</td>
				<td><input type="text" name="subtotal" value="100" /></td>
			</tr>
			<tr>
				<td>Shipping:</td>
				<td><input type="text" name="shipping" value="10" /></td>
			</tr>
			<tr>
				<td>Tax:</td>
				<td><input type="text" name="tax" value="10" /></td>
			</tr>
			<tr>
				<td>Total Amount:</td>
				<td><input type="text" name="total" value="120" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Checkout" /></td>
			</tr>
		</table>
	</form>
</body>
</html>