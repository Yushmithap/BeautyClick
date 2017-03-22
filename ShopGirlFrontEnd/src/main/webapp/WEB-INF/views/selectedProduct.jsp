
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<c:set var="imageFolder" value="C:\\Users\\Manisha\\Desktop\\BeautyClick\\ShopGirl\\src\\main\\webapp\\img\\" />
<c:url   var="getAction" value='manageProductGet/${product.productID}' />
	<form:form action="${getAction}" commandName="product">
	<table>
		<tr>
			<td><img alt="${selectedProduct.name}"
				src="${imageFolder}${selectedProduct.productID}.jpg"></td>
		</tr>
		
		<tr>
			<td> ${selectedProduct.name}</td>
		</tr>
		<tr>
			<td>Product Code : ${selectedProduct.productID}</td>
		</tr>
		
		<tr>
			<td>Product Details : ${selectedProduct.description}</td>
		</tr>
		<tr>
			<td>Price : Rs.${selectedProduct.price}</td>
		</tr>
		<tr>
			<td>Size: ${selectedProduct.size}</td>
		</tr>
		<tr>
			<td>Stock: ${selectedProduct.stock}</td>
		</tr>
		
		<tr>
			<td><a class="icon-shopping-cart"
				href="myCartAdd/${selectedProduct.productID}">Add To Cart </a></td>
		</tr>
		
		<tr>
		<td><a class="col-xs-offset-1 btn btn-lg btn-success"
				href="cart_checkout">Checkout </a></td>
		</tr>		
	
	</table>
	</form:form>


</body>
</html>