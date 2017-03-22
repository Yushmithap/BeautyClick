<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
input[type=text] {
	width: 28%;
	font-size: 13px;
}
</style>
<body>
<div class="container">
 	<div class="row">
 		<div class="col-sm-12 col-sm-offset-5">
  <h4>Enter your Billing Address</h4>
  <form:form role="form" action="${flowExecutionUrl}&_eventId=submitBillingAddress"  commandName="billingAddress" method="post">
  	<div class="form-group">
      <label for="line1">Address Line1</label>
      <input type="text" class="form-control" name="line1">
    </div>
    <div class="form-group">
      <label for="line2">Address Line2</label>
      <input type="text" class="form-control" name="line2">
    </div>
    <div class="form-group">
      <label for="city">City</label>
      <input type="text" class="form-control" name="city">
    </div>
    <div class="form-group">
      <label for="State">State</label>
      <input type="text" class="form-control" name="state">
    </div>
    <div class="form-group">
      <label for="country">Country</label>
      <input type="text" class="form-control" name="country">
    </div>
    <div class="form-group">
      <label for="zipCode">ZipCode</label>
      <input type="text" class="form-control" name="zipCode">
    </div>
    
    <div class="form-actions">
       <button type="Submit" class="btn btn-lg btn-info "
       name="_eventID_submitBillingAddress" style="margin-right: 44px; margin-left: 0px;color: white;background-color: grey">Next</button>
       <a href="${flowExecutionUrl}&_eventId=cancel" class="btn btn-lg btn-default" name="_eventId_cancel" type="button">Cancel</a>
     </div>
   
  </form:form>
</div>
</div>
</div>
</body>
</html>