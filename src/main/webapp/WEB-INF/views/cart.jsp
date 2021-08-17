<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<title>Kyanja Shopping Cart</title>
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
	<form name="cartForm" method="post"
		action="${pageContext.request.contextPath}/shoppingcart/update.html">
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
					<a class="btn btn-primary btn-lg" href="#" role="button">Your
						Shopping Cart</a>
				</p>
			</div>
		</div>







		<div class="container main-section">
			<div class="row">
				<div class="col-lg-12 pb-2">
					<h2>Adding Product to your cart</h2>

				</div>


				<div class="col-lg-12 pl-3 pt-3">

					<table class="table table-hover border bg-white">


						<thead>

							<th>
								<h4>
									<b> Product Details </b>
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
							<th>
								<h4>
									<b> Action <b>
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
									<td><strong>${item.product.price} USD </strong></td>
									<td data-th="quantity"><b> <input type="text"
											name="quantity" class="form-control text-center"
											value="${item.quantity}">
									</b></td>
									<td><strong>${item.product.price * item.quantity}
											USD </strong></td>

									<td><a type="button"
										href="${pageContext.request.contextPath}/shoppingcart/remove/${item.product.id}"
										onclick="return confirm('Are you sure you want to remove this product from your shopping cart?')"
										class="btn btn-danger btn-sm"> <span
											class="glyphicon glyphicon-trash" aria-hidden="true"></span>
											Remove from Cart
									</a></td>
							</c:forEach>

						</tbody>

						<td><button class="btn btn-info btn-large" type="submit">
								Update My Cart <i class="fa fa-edit-o"> </i>
							</button></td>

						<tfoot>
							<tr>

								<td><a type="button"
									href="${pageContext.request.contextPath}/product/productlist.html"
									class="btn btn-info btn-large"> <span
										class="fa fa-angle-left" aria-hidden="true"></span> Continue
										Shopping
								</a></td>


								<td colspan="2" class="hidden-xs"></td>
								<td class="hidden-xs text-center" style="width: 10%;"><strong>
										Total Price : ${total} USD </strong></td>
								<td><a
									href="${pageContext.request.contextPath}/shoppingcart/checkout"
									class="btn btn-success btn-block"> Confirm your Order <i
										class="fa fa-angle-right"> </i>
								</a></td>
							</tr>
						</tfoot>

					</table>
				</div>
	</form>
</body>
</html>