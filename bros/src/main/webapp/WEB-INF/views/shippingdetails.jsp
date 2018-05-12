<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="bootstrap.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function showData(){
	  var x = document.getElementById('info');
	    if (x.style.visibility === 'hidden') {
	        x.style.visibility = 'visible';
	    }
}
</script>
<style>
form#info
{
	
    border: 1px solid black;
    border-radius: 8px;
	margin-left:30px;
	margin-right:30px;
	margin-top:20px;
	margin-bottom:20px;
	padding-left:50px;
	padding-right:50px;
	padding-top:30px;
	padding-bottom:30px;
	background-color:white;
}

</style>
</head>

<body>
<%@include file="header.jsp" %>
<br>
<br>
<br>
<br>
<button type="button" onclick="showData()">Ship to</button>

<form action="user_placeorder" id="info" method="post" style="visibility:hidden;">
<center>
<h2><center>Select Shipping Address</center></h2>
<label ><h3>Phone</h3></label><br>
<input type="text" id="phone" value="${shippingdetails.phone} "/><br>

<label><h3>Address</h3></label><br>
<label ><h5>H.No.</h5></label>
<input type="text" id="hno" value="${shippingdetails.hno} "/><br>
<label ><h5>Street</h5></label>
<input type="text" id="street" value="${shippingdetails.street}"/><br>
<label><h5>Location</h5></label>
<input type="text" id="loc" value="${shippingdetails.loc}"/><br>
<label ><h5>Area</h5></label>
<input type="text" id="area" value="${shippingdetails.area}"/><br>
<label ><h5>City</h5></label>
<input type="text" id="city" value="${shippingdetails.city}"/><br>
<label ><h5>State</h5></label>
<input type="text" id="state" value="${shippingdetails.state}"/><br><br>
<input type="submit" class="btn btn-success"  value="PLACE ORDER"></center>
</form>

</body>
</html>