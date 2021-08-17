<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Categories</h1>
            <p>Add categories</p>
         </div>
      </div>
   </section>
   <section class="container">
     	
    <form:form modelAttribute="category" action="saveCategory" method="post"
		enctype="multipart/form-data">
         <fieldset>
            <legend>Add new category</legend>

            <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="id"><spring:message code="addCategory.form.categoryId.label"/></label>
               <div class="col-lg-10">
                  <form:input id="id" path="id" type="text" class="form:input-large"/>
               </div>
            </div>
            
             <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addCategory.form.name.label"/></label>
               <div class="col-lg-10">
                  <form:input id="name" path="name" type="text" class="form:input-large"/>
               </div>
            </div>
           
      
            <div class="form-group">
               <div class="col-lg-offset-2 col-lg-10">
                  <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
               </div>
            </div>
         </fieldset>
      </form:form>
   </section>
</body>
</html>