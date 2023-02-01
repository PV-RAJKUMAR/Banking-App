<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT PAGE</title>
<style>
.form
{
    margin-left: 2%;
    margin-right: 2%;
    text-align: justify;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:#E8E9EA;">
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b>Mahindra Bank</b><br>  <font size="1"><i>Established in 1906</i></font></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="http://localhost:8080/Banking-App">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Dropdown
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</div>

<div class="form">
<c:choose>
    <c:when test="${address.firstLine!=null}">
<div class="alert alert-secondary" role="alert">
 <b>ADDRESS EDIT :</b>
</div>
</c:when>
<c:otherwise>
<div class="alert alert-secondary" role="alert">
 <b>ADD ADDRESS:</b>
</div>
</c:otherwise>
</c:choose>
<div class="alert alert-secondary" role="alert">
      <form:form method="post" modelAttribute="address" action="addressSave?addressId=${address.addressId}&&userId=${user.userId}">
   <div class="form-group row">
    <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="firstLine"><b><i>Address line 1</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputEmail3" placeholder="Address line 1" path="firstLine"/>
    </div>
  </div>
  <div class="form-group row">
      <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="lastLine"><b><i>Address line 2</i></b></form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="inputEmail3" placeholder="Address line 2" path="lastLine"/>
      </div>
    </div>
  <div class="form-group row">
        <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="city"><b><i>City</i></b></form:label>
        <div class="col-sm-10">
          <form:input type="text" class="form-control" id="inputEmail3" placeholder="City" path="city"/>
        </div>
      </div>
  <div class="form-group row">
          <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="state"><b><i>State</i></b></form:label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputEmail3" placeholder="State" path="state"/>
          </div>
        </div>
  <div class="form-group row">
              <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="zipCode"><b><i>ZipCode</i></b></form:label>
              <div class="col-sm-10">
                <form:input type="text" class="form-control" id="inputEmail3" placeholder="ZipCode" path="zipCode"/>
              </div>
            </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Save</button>
    </div>
  </div>
</form:form>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>