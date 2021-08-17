<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html> 
<head>  
    <title> Gahinga product details  </title>  
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">  
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> </script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"> </script>  
      
  
    <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/customnew.css">
</head> 
<body>  
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Shopping with Kyanja</a>
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


<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Product details</h1>
			</div>
		</div>
</section>
	<section class="container">
		<div class="row">
		     <div class="col-lg-2 Product-img">  
                                        <img src="photoProd?idProd=${product.id}" alt="..." class="img-responsive" />  
                                    </div>  
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-info">${product.id}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${product.category.name}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.price}USD</h4>
				<p>
					<a href="${pageContext.request.contextPath}/product/productlist.html"
						class="btn btn-info"> <span
						class="glyphicon-hand-left glyphicon"></span> back
					</a> 
					<a href="${pageContext.request.contextPath}/shoppingcart/ordernow/${product.id}.html" class="btn btn-info btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>