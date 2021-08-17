<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html> 
<head>  
    <title> Gahinga Shopping Cart  </title>  
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
  ${message}
 
<c:url value="/j_spring_security_logout" var="logoutUrl" />
Log Out
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
					<a class="btn btn-primary btn-lg" href="#" role="button">
						Kyanja Products</a>
				</p>
			</div>
		</div>
</div>
    <div class="container main-section">  
        <div class="row">  
           
            <div class="col-lg-12 pl-3 pt-3">  
                <table class="table table-hover border bg-white">  
                    <thead>  
                        <tr>  
                           
                           <th> <h4> <b>  Product Details </b> </h4> </th>  
                            <th> <h4> <b> Price  </b> </h4> </th>  
                           
                          
                            <th> <h4> <b> Action </b> </h4> </th>  
                        </tr> 
                  
                    </thead>  
                    <tbody>  
                       <c:forEach var="p" items="${listproduct}">
                        <tr>  
                           <td>  
                         
                                <div class="row">  
                                    <div class="col-lg-2 Product-img">  
                                        <img src="photoProd?idProd=${p.id}" alt="..." class="img-responsive" />  
                                    </div>  
                                    <div class="col-lg-10">  
                                        <h5 class="nomargin"> <b> ${p.name} </b> </h5>  
                                        <p>${p.description} </p>  
                                    </div>  
                                </div>  
                            </td>  
                            <td> <strong> ${p.price} USD 
                            </strong> </td>  
                            <td> <a href="${pageContext.request.contextPath}/shoppingcart/ordernow/${p.id}.html" class="actions" data-th="" style="width:10%;">  
                                <button class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-shopping-cart"> </span> </button>  
                                                            
                             </a> </td> 
                             <td> <a href="${pageContext.request.contextPath}/product/details?id=${p.id}" class="actions" data-th="" style="width:10%;">  
                                  <button class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-info">Details </span> </button>  
                               
                          
                                                            
                             </a> </td> 
                         
             
                            	
                   
                         	</c:forEach>
                    </tbody>  
                    <tfoot>  
                        <tr>  
                            	<td><a href="${pageContext.request.contextPath}/product/productlist.html"
								class="btn btn-info btn-large "> <span class="fa fa-angle-left"> </span>
									Continue Shopping
							   </a>
							
							</td> 
                          
                        </tr>  
                    </tfoot>  
                </table>  
            </div>  
        </div> 
         <hr>
         

  <footer>
    <p>&copy; kyanja 2021</p>
  </footer>
    </div>  
</body>  
</html>  