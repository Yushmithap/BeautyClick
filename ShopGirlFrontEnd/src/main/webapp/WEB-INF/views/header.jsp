<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<style>
body{
	text-color: RosyBrown;
}
a:link,a:visited {
	color: RosyBrown;
	padding: 13px 13px;
	text-align: center;
	display: inline-block;
	}
a:hover {
	text-decoration: none;
}

span {
	margin-left: 3px;
}

div {
	margin: auto;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-sm-offset-9">
				<h1>
					<span class="glyphicon glyphicon-bitcoin" style="color: RosyBrown;"></span><cite
						style="color: RosyBrown; font-family: fantasy; font-size: 30px">BeautyClick.com</cite>
				</h1>

			</div>
		</div>
	</div>
	
	

	<c:if test="${empty loggedInUser}">
		<table>
			<tr>
				<td>
				<a href="loginHere" style="test-decoration: none;"><b>LOGIN</b></a></td>
				<td><a href="registerHere"><b>SIGN UP</b></a></td>
			</tr>
		</table>
	</c:if>

	
	<c:if test="${!empty loggedInUser}">
		<table>
			<tr>
				<td style="color: RosyBrown;"><span class="glyphicon glyphicon-user" style="text-color: RosyBrown;"></span>${user.getName()}</td>
			</tr>
		</table>
	</c:if>


	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-10">
				<c:if test="${!empty loggedInUser}">
					
						<table>
							<tr>
							<c:if test="${isAdmin==false || showMyCart==true}">
								<td><span class="glyphicon glyphicon-shopping-cart" style="color: RosyBrown;"></span><a
									href="myCart"><b>BAG</b></a><i class="fa fa-shopping-cart" style="color: RosyBrown;">${cartSize}</i></td>
									</c:if>
							</tr>
						</table>
					
				</c:if>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-10">
				<c:if test="${!empty loggedInUser}">
					<a href="logout"><b>Logout</b></a>
				</c:if>
			</div>
		</div>
	
	</div>
	</nav>
<hr>

	<nav class="navbar navbar-default">
	<div class="container-fluid">

		<ul class="nav nav-pills" role="tablist">
			<c:forEach items="${categoryList}" var="category">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><b> ${category.name}</b> <span
						class="caret"></span></a>


					<ul class="dropdown-menu" role="menu">
						<c:forEach items="${category.products}" var="product">
							<li><a href="manageProductGet/${product.productID}">${product.name}</a></li>
						</c:forEach>
					</ul></li>
			</c:forEach>

		</ul>
	</div>
	${category.products}
</nav>
	
	

</body>
</html>