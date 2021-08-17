<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
<div class="errors">${exception}</div>
<div id="formProd" class="cadre">
	<f:form modelAttribute="product" action="saveProd" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit</td>
				<td><f:input path="id" /></td>
				<td><f:errors path="id" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:input path="description" /></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Categorie</td>
				<td><f:select path="categorie.idcategorie"
						items="${categories}" itemValue="idcategorie" 
 						itemLabel="nomCategorie"></f:select></td> 
               <td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><f:input path="price" /></td>
				<td><f:errors path="price" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Quantit�</td>
				<td><f:input path="quantity" /></td>
				<td><f:errors path="quantity" cssClass="errors"></f:errors></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>S�leclionner?</td> -->
<%-- 				<td><f:checkbox path="selected" /></td> --%>
<%-- 				<td><f:errors path="selected" cssClass="errors"></f:errors></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>Photo</td>
				<td><c:if test="${product.id!=null}">
						<img src="photoProd?idProd=${product.id }" />
					</c:if>
					</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="tabProduits" class="cadre">
	<table class="tab1">
		<tr>
			<th>ID</th>
			<th>D�signation</th>
			<th>Description</th>
			<th>cat�gorie</th>
			<th>Prix</th>
			<th>Quantit�</th>
			<th>Selected</th>
			<th>Photo</th>
		</tr>
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.idProduit }</td>
				<td>${p.designation }</td>
				<td>${p.description }</td>
				<td>${p.categorie.nomCategorie }</td>
				<td>${p.prix }</td>
				<td>${p.quantite }</td>
				<td>${p.selected }</td>
				<td><img src="photoProd?idProd=${p.idProduit }" /></td>
				<td><a href="suppProd?idProd=${p.idProduit }">Supp</a></td>
				<td><a href="editProd?idProd=${p.idProduit }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>