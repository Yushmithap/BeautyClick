<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Carousel_images</title>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 75%;
      margin: auto;
    
  }
  </style>
</head>
<body>
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    	<div class="item active">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic05.jpg" alt="Chania" width="600" height="500">
      </div>
      <div class="item active">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic06.jpg" alt="Chania" width="600" height="500">
      </div>
      <div class="item active">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic07.jpg" alt="Chania" width="600" height="500">
      </div>
    
      <div class="item active">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic01.jpg" alt="Chania" width="460" height="345">
      </div>

      <div class="item">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic02.jpg" alt="Chania" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic03.jpg" alt="Flower" width="460" height="345">
      </div>

      <div class="item">
        <img src="C:\Users\Manisha\Desktop\BeautyClick\ShopGirl\src\main\webapp\img\Cosmetic04.jpg" alt="Flower" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>



</body>
</html>