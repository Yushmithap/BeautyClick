<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>

input[type=text]{
	width: 28%;
	font-size: 13px;
}
input[type=password]{
	width: 28%;
	font-size: 13px;
}
input[type=radio]{
	padding: 5px;
}
a:hover{
	text-decoration: none;
}

</style>
</head>
<body>
 <div class="container">
 	<div class="row">
 		<div class="col-sm-12 col-sm-offset-5">
  <h4>SignUp with BeautyClick</h4>
  <form action="register" method="post" >
  	<div class="form-group">
      <label for="id">User ID</label>
      <input type="text" class="form-control" name="id" Placeholder="Your User ID">
    </div>
    <div class="form-group">
      <label for="name">User Name</label>
      <input type="text" class="form-control" name="name" Placeholder="Your User Name">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="text" class="form-control" name="email" Placeholder="Your Email Address">
    </div>
    <div class="form-group">
      <label for="pwd">Password</label>
      <input type="password" class="form-control" name="password" Placeholder="Choose Password">
    </div>
    <div class="form-group">
      <label for="pwd">Mobile</label>
      <input type="text" class="form-control" name="mobile" Placeholder="Mobile Number(For order status updates)">
    </div>
    <div class="button">
    <button type="submit" class="btn btn-default" style="font-size:18px;height:30px;">Register</button>
    </div>
  </form>
</div>
</div>
</div>


</body>
</html>