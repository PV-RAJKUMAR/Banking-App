<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
.wrap{
    position:fixed;
    bottom:10px;
    right:0px;
    height:20px;
    width:250px;
    background-color:#EEE009;
}
.target{
    left      : 80%;
    top       : 50%;
    position  : absolute;
    transform : translate(-50%, -50%);
    color     : blue;
}
body{
background-image: url(https://img.freepik.com/premium-photo/indian-rupee-inr-rupee-currency-monetary-currency-symbol-red-symbol_559531-21031.jpg?size=626&ext=jpg&ga=GA1.1.1626499490.1671532966);
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><b>Mahindra Bank</b><br>  <font size="1"><i>Established in 1906</i></font></a></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
</nav>
      <div class="d-flex" align="right">
        <div class="p-2"> <a href="user/dashBoard" button class="btn btn-primary btn-sm my-2 my-sm-0" >Login</a></button></div>
        <div class="p-2"><a href="showRegPage" button class="btn btn-primary btn-sm my-2 my-sm-0" >New User?Sign In</a></button></div>
        <div class="ml-auto p-2"><font ><i>About Us</i></font></div>
      </div>
</nav>
</div>
<div class="target">
<div class="alert alert-info" role="alert">
  Whats New?
  <div class="list-group">
    <a href="#" class="list-group-item list-group-item-action">
Performance Highlights-Q2 FY 2022-23
    </a>
    <a href="#" class="list-group-item list-group-item-action">Press Release Q3 FY 2022-22</a>
    <a href="#" class="list-group-item list-group-item-action">Notice-Revision in Debit Card Services Charges w.e.f 13.02.2023</a>
  </div>
</div>
</div>
<div class="wrap">
  <a href="admin/dashBoard">Click here for admin access>>></a>
  </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>