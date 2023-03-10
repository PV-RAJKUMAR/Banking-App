<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account List</title>
<style>

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b>Mahindra Bank</b><br>  <font size="1"><i>Established in 1906</i></font></a></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
</div>

<div class="form">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
                <a class="nav-link" href="dashBoard"><b>Home</b> <span class="sr-only">(current)</span></a>
              </li>
      </ul>
    </div>
  </nav>
</div>

<c:if test="${not empty loan}">
    <div class="alert alert-primary" role="alert">
     <b> Select Account to continue:</b>
    </div>
</c:if>

<c:if test="${empty loan}">
    <div class="alert alert-primary" role="alert">
 <h3><b> User Account List:</b></h3>
</div>
</c:if>

<div class="alert alert-dark" role="alert">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Account Id</th>
      <th scope="col">Account No</th>
      <th scope="col">Account Type</th>
      <th scope="col">Branch</th>
      <th scope="col">Balance Amount</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${accountModelList}">
    <tr>
      <th scope="row">${list.accountId}</th>
      <td>${list.accountNo}</td>
      <td>${list.accountType}</td>
      <td>${list.branch}</td>
      <td>${list.balanceAmount}</td>
      <c:if test="${not empty loan}">
          <td><a href="loanReqForm?accId=${list.accountId}&&userId=${user.userId}" button type="button" class="btn btn-primary btn-sm">Apply For Loan</button></td>
      </c:if>
      <c:if test="${empty loan}">
      <td><a href="depositForm?accId=${list.accountId}&&userId=${user.userId}" button type="button" class="btn btn-primary btn-sm">Deposit amount</button></td>
      <td><a href="withdrawFrom?accId=${list.accountId}&&userId=${user.userId}" button type="button" class="btn btn-primary btn-sm">Withdraw amount</button></td>
    </c:if>
    </tr>
</c:forEach>
</tbody>
    </table>
    </div>
<div class="alert alert-primary" role="alert">
 <h5><b> Transaction Details:</b></h5>
</div>
    <div class="alert alert-dark" role="alert">
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">Transaction Id</th>
          <th scope="col">Transaction Type</th>
          <th scope="col">Account No</th>
          <th scope="col">Transaction Amount</th>
          <th scope="col">Transaction Date</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="list" items="${transactionModelList}">
        <tr>
          <th scope="row">${list.trscId}</th>
          <td>${list.mode}</td>
          <td>${list.accountModel.accountNo}</td>
          <td>${list.transactAmt}</td>
          <td>${list.transactDate}</td>
        </tr>
    </c:forEach>
    </tbody>
        </table>
        </div>
    </div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>