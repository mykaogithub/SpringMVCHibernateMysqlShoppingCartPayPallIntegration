<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



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

</head>
<body>
	<fieldset>

		<legend>Cuctomer Information</legend>


		<!-- 		<form name="cartForm" method="post" -->
		<%-- 			action="${pageContext.request.contextPath}/shoppingcart/placeorder.html"> --%>
		<form:form
			action="${pageContext.request.contextPath}/shoppingcart/placeorder.html"
			method="post" commandName="cartForm">
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
						<h1>Please enter your order information</h1>

					</div>


					<div class="col-lg-12 pl-3 pt-3">

						<table class="table table-hover border bg-white">

							<tr>

								<div class="form-group row">
									<label for="firstName" class="col-sm-2 col-form-label">First
										Name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="firstName"
											value="firstName">
									</div>
								</div>

								<div class="form-group row">
									<label for="lastName" class="col-sm-2 col-form-label">Last
										Name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="lastName"
											value="lastName">
									</div>
								</div>

								<div class="form-group row">
									<label for="email" class="col-sm-2 col-form-label">Email</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="email"
											value="email">
									</div>
								</div>


								<div class="form-group row">
									<label for="phone" class="col-sm-2 col-form-label">Phone
										Number</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="phone"
											value="phone">

									</div>
								</div>


								<div class="form-group row">
									<label for="birthDate" class="col-sm-2 col-form-label">
										Birthday :</label>
									<div class="col-sm-10">

										<input id= "dateOfBirth"  type="date" class="form-control" name="dateOfBirth"
											value="dateOfBirth">

										<!-- 										<input type="date" class="form-control" -->
										<!-- 											name="birthDate" value="birthDate"> -->



									</div>



								</div>


								<div class="form-group row">
									<label for="line1" class="col-sm-2 col-form-label">Address
										line 1</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="line1"
											value="line1">
									</div>
								</div>
								<div class="form-group row">
									<label for="line2" class="col-sm-2 col-form-label">Address
										line 2(optional)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="line2"
											value="line2">
									</div>
								</div>
								<div class="form-group row">
									<label for="postalCode" class="col-sm-2 col-form-label">Postal
										code (optional)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="postalCode"
											value="postalCode">
									</div>
								</div>
								<div class="form-group row">
									<label for="city" class="col-sm-2 col-form-label">City
										/ Town / Village</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="city"
											value="city">
									</div>
								</div>
								<div class="form-group row">
									<label for="countryName" class="col-sm-2 col-form-label">Country</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="countryName"
											value="countryName">
									</div>
								</div>






								<div class="form-group row">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-primary">Place
											Order</button>
									</div>
								</div>




							</tr>


						</table>
					</div>
					<!-- 		</form> -->
		</form:form>
	</fieldset>
</body>
</html>