<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW USER REG PAGE</title>
<style>
.form
{
    margin-left: 1%;
    margin-right: 1%;
    text-align: justify;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:#E8E9EA;">
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><b>Mahindra Bank</b><br>  <font size="1"><i>Established in 1906</i></font></a></a>
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
<form:form method="post" modelAttribute="user" action="save">
  <div class="form-group row">
    <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="firstName"><i><b>First Name</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputEmail3" placeholder="First Name" path="firstName"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="lastName"><i><b>Last Name</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputPassword3" placeholder="Last Name" path="lastName"/>
    </div>
  </div>
  <div class="form-group row">
      <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="userName"><i><b>User Name</i></b></form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="inputPassword3" placeholder="User Name" path="userName"/>
      </div>
    </div>
    <div class="form-group row">
          <form:label for="inputPassword3" class="col-sm-2 col-form-label" path="age"><i><b>Age</i></b></form:label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputPassword3" placeholder="Age" path="age"/>
          </div>
        </div>
  <fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0"><i><b>Gender</i></b></legend>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="gridRadios1" value="male" checked>
          <label class="form-check-label" for="gridRadios1">
            Male
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="gridRadios2" value="female">
          <label class="form-check-label" for="gridRadios2">
            Female
          </label>
        </div>
      </div>
    </div>
  </fieldset>

  <div class="form-group row">
      <form:label for="inputPassword3" class="col-sm-2 col-form-label"  path="password"><b><i>Password</i></b></form:label>
      <div class="col-sm-10">
      <form:input type="password" class="form-control" id="inputPassword3" placeholder="Password" path="password"/>
      </div>
      </div>

<h4><b>Address Details:</b></h4>
      <form:form method="post" modelAttribute="address">
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
          <form:input type="text" class="form-control" id="inputEmail3" placeholder="city" path="city"/>
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
                <form:input type="text" class="form-control" id="inputEmail3" placeholder="Country" path="zipCode"/>
              </div>
            </div>
            <h4><b>Account Details:</b></h4>
  <form:form method="post" modelAttribute="account">
     <div class="form-group row">
      <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="accountNo"><b><i>Account No</i></b></form:label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="inputEmail3" placeholder="Account No" path="accountNo"/>
      </div>
    </div>
    <div class="form-group row">
        <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="accountType"><b><i>Account Type</i></b></form:label>
        <div class="col-sm-10">
         <form:select id="inputAccount" class="form-control" path="accountType">
                       <option selected>Choose...</option>
                       <option value="savings">Savings account</option>
                       <option value="current">Current account</option>
                       <option value="salary">Salary account</option>
                     </form:select>
        </div>
      </div>
    <div class="form-group row">
          <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="branch"><b><i>Branch</i></b></form:label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputEmail3" placeholder="Branch" path="branch"/>
          </div>
        </div>
    <div class="form-group row">
      <div class="col-sm-10">
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
    </div>
    <p>${message}</p>
 </form:form>
</form:form>
</form:form>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>