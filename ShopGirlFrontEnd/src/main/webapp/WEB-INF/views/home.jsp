<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Shopping Cart</title>

</head>
<body>
	
	<%@ include file="./header.jsp"%>
	



	<c:if test="${!empty logoutMessage}">
		<div class="alert alert-success">${logoutMessage}</div>
	</c:if>
	<c:if test="${!empty successMessage}">
		<div class="alert alert-success">${successMessage}</div>
	</c:if>
	<c:if test="${!empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	
	

	<c:if test="${homePage}">
		<%@ include file="./carousel_images.jsp"%>
	</c:if>
	
	<c:if test="${!empty selectedProduct}">
		<%@ include file="./selectedProduct.jsp"%>
	</c:if>


	<c:if
		test="${isUserClickedLoginHere==true || invalidCredentials==true}">
		<%@ include file="./login.jsp"%>
	</c:if>

	<c:if test="${isAdmin==true}">
		<%@ include file="./adminHome.jsp"%>
	</c:if>
	<c:if test="${isAdminClickedCategories==true}">
		<%@ include file="./adminHome.jsp"%>
		<%@ include file="./Category.jsp"%>
	</c:if>
	<c:if test="${isAdminClickedProducts==true}">
		<%@ include file="./adminHome.jsp"%>
		<%@ include file="./product.jsp"%>
	</c:if>
	<c:if test="${isAdminClickedSuppliers==true}">
		<%@ include file="./adminHome.jsp"%>
		<%@ include file="./supplier.jsp"%>
	</c:if>
	<c:if test="${isUserClickedRegisterHere==true}">
		<%@ include file="./registration.jsp"%>
	</c:if>

	<c:if test="${showMyCart}">
		<%@ include file="./cart.jsp"%>
	</c:if>
	
	

	

</body>
</html>