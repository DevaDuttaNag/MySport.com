<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@include file="bootstrap.jsp" %>
<title>Mysport.COM</title>
<style>
form#info
{
    border: 1px solid black;
    border-radius: 8px;
	margin-left:70px;
	margin-right:70px;
	margin-top:20px;
	margin-bottom:50px;
	padding-left:100px;
	padding-right:100px;
	padding-top:30px;
	padding-bottom:20px;
	background-color:white;
}

</style>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>
<div class="Container">
<br>
<br>
<div class="row" >
<div class="col-lg-6" id="text">
<br>
<br>
<center><h1>Any Sport,Any Item.</h1><center>
<center><h4>Shop now</h4></center>
</div>
<div class="col-lg-6">

<form action="j_spring_security_check" method="post" id="info"  >
<center><input type="text" class="form-control"  name="j_username" placeholder="Enter Id here"/></center><br>
<center><input type="password" class="form-control" name="j_password" placeholder="Enter Password here"/></center>
<center><h5><label><input type="checkbox"> Remember me</label></h5></center>
<center><button type="submit" class="btn btn-success btn-md"> Log In</button></center>	<!--  <span class="glyphicon glyphicon-ok-sign"></span> -->
<!-- <center><button type="button" class="btn btn-link">Forgot Password ?<span class="glyphicon glyphicon-circle-question-mark"></span></button></center> -->
 </form>
 </div>
</div>
</div> 
<%@include file="footer.jsp"%>

</body>
</html>
 