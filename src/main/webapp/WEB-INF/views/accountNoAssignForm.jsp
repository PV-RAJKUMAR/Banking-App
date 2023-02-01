<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account No Assignment Form</title>
<style>
.form
{
    margin-left: 1%;
    margin-right: 1%;
    text-align: justify;
}
.wrap{
    left      : 80%;
    top       : 50%;
    position  : absolute;
    transform : translate(-50%, -50%);
    color     : blue;
}
body {
  background-color:lightblue;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="alert alert-primary" role="alert">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b>Mahindra Bank</b><br>  <font size="1"><i>Established in 1906</i></font></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    </div>
  </nav>
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

  <div class="form">
<div class="alert alert-secondary" role="alert">
<form:form method="post" modelAttribute="account" action="assign?accId=${account.accountId}&&userId=${user.userId}">
  <div class="form-group row">
    <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="user.firstName"><i><b>First Name</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputEmail3" placeholder="First Name" path="user.firstName" disabled="true"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="user.lastName"><i><b>Last Name</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputPassword3" placeholder="Last Name" path="user.lastName" disabled="true"/>
    </div>
  </div>
  <div class="form-group row">
      <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="user.userName"><i><b>User Name</i></b></form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="inputPassword3" placeholder="User Name" path="user.userName" disabled="true"/>
      </div>
    </div>
    <div class="form-group row">
          <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="user.age"><i><b>Age</i></b></form:label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputPassword3" placeholder="Age" path="user.age" disabled="true"/>
          </div>
        </div>
         <div class="form-group row">
                  <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="user.gender"><i><b>Gender</i></b></form:label>
                  <div class="col-sm-10">
                    <form:input type="text" class="form-control" id="inputPassword3" placeholder="Gender" path="user.gender" disabled="true"/>
                  </div>
                </div>
 <div class="form-group row">
 <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="accountNo"><i><b>Account No</i></b></form:label>
 <div class="col-sm-10">
 <form:input type="text" class="form-control" id="inputPassword3" placeholder="Account No" path="accountNo"/>
 </div>
 </div>
 <div class="form-group row">
 <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="accountType"><i><b>Account Type</i></b></form:label>
 <div class="col-sm-10">
 <form:input type="text" class="form-control" id="inputPassword3" placeholder="Account Type" path="accountType" readonly="true"/>
 </div>
 </div>
 <div class="form-group row">
  <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="branch"><i><b>Branch</i></b></form:label>
  <div class="col-sm-10">
  <form:input type="text" class="form-control" id="inputPassword3" placeholder="Branch" path="branch" readonly="true"/>
  </div>
  </div>
<div class="form-group row">
  <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="bankName"><i><b>Bank Name</i></b></form:label>
  <div class="col-sm-10">
  <form:input type="text" class="form-control" id="inputPassword3" placeholder="Bank Name" path="bankName" readonly="true"/>
  </div>
  </div>
  <div class="form-group row">
      <div class="col-sm-10">
        <button type="submit" class="btn btn-primary">Submit</button>
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