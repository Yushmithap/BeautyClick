<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
${message}
<c:set var="imageFolder" value="C:\\Users\\Manisha\\Desktop\\BeautyClick\\ShopGirl\\src\\main\\webapp\\img\\" />
<c:url   var="getAction" value="myCartAdd/${selectedProduct.productID}" />
<form:form action="${getAction}" commandName="cart">

	<table class="table table-striped" >
		<tr>
			<th align="left" width="80">Cart ID</th>
			<th align="left" width="120">Product Name</th>
			<th align="left" width="200">Date Added</th>
			<th align="left" width="80">Price</th>
			
			<th colspan="2" align="center" width="60">Action</th>
			

		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				<td align="left">${cart.id}</td>
				<td align="left">${cart.productName}</td>
				<td align="left">${cart.dateAdded}</td>
				<td align="left">${cart.price}</td>
				<td align="left">
				<a href="<c:url value='/myCartRemove/${cart.id}'/>">Delete</a>
				</td>
				<td>	
				<img alt="${cart.productName}" src="<c:url value="${imageFolder}${cart.productID}.jpg"></c:url>"/>
				</td>
			</tr>
		</c:forEach>

	</table>
</form:form>


	<h2>Total cost : ${totalAmount}</h2>
	<br>
	<a href="cart_checkout">Checkout</a>
	<br>
	<br> 


</body>
</html>