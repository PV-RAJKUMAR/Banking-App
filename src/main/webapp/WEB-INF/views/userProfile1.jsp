<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style>

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
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="dashBoard?userId=${user.userId}"><b>HOME</a>
      </li>
    </nav>
<b>PROFILE</b>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="row">FIRST NAME</th>
      <td>:${user.firstName}</td>
      </tr>
      <tr>
      <th scope="row">LAST NAME</th>
      <td>:${user.lastName}</td>
      </tr>
      <tr>
      <th scope="row">USER NAME</th>
      <td>:${user.userName}</td>
      </tr>
      <tr>
      <th scope="row">PASSWORD</th>
      <td>:${user.password}</td>
      </tr>
      <tr>
      <th scope="row">AGE</th>
      <td>:${user.age}</td>
      </tr>
      <tr>
      <th scope="row">GENDER</th>
      <td>:${user.gender}</td>
      </tr>
      </thead>
      </table>

      <b>ADDRESS</b>
      <table class="table table-dark">
        <thead>
          <tr>
          <th scope="col"></th>
            <th scope="col">ADDRESS LINE 1</th>
            <th scope="col">ADDRESS LINE 2</th>
            <th scope="col">CITY</th>
            <th scope="col">STATE</th>
            <th scope="col">PINCODE</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${addressModels}">
          <tr>
          <th scope="row">#</th>
            <th scope="row">${list.firstLine}</th>
            <td>${list.lastLine}</td>
            <td>${list.city}</td>
            <td>${list.state}</td>
            <td>${list.zipCode}</td>
          </tr>
      </c:forEach>
     </tbody>
</table>

<b>ACCOUNT INFO:</b>
      <table class="table table-dark">
        <thead>
          <tr>
          <th scope="col">ACCOUNT ID</th>
            <th scope="col">ACCOUNT NO</th>
            <th scope="col">ACCOUNT TYPE</th>
            <th scope="col">BRANCH</th>
            <th scope="col">BALANCE AMOUNT</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${user.accountModelList}">
          <tr>
          <th scope="row">${list.accountId}</th>
             <c:if test="${empty list.accountNo}">
                      <th scope="row">"Requires Approval.."</th>
                      </c:if>
                      <c:if test="${not empty list.accountNo}">
                        <th scope="row">${list.accountNo}</th>
                        </c:if>
            <td>${list.accountType}</td>
            <td>${list.branch}</td>
            <td>${list.balanceAmount}</td>
          </tr>
      </c:forEach>
 </tbody>
</table>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    </html>