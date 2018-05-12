<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function showData(){
	document.getElementById("btn").style.visibility = "hidden";
	  var x = document.getElementById('info');
	    if (x.style.visibility === 'hidden') {
	        x.style.visibility = 'visible';
	    }
	    
}
</script>
<style>
table#set
{

width:80%;
margin: auto;
}
body
{
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}

table
{
    border-collapse: separate;
}

tr td:first-child:before
{
  counter-increment: Serial;      /* Increment the Serial counter */
  content:counter(Serial); /* Display the counter */
}
th,td
{
text-align:center;
vertical-align:center;
}
form#info
{
	
    border: 1px solid black;
    border-radius: 8px;
	margin-left:350px;
	margin-right:350px;
	margin-top:20px;
	margin-bottom:20px;
	padding-left:10px;
	padding-right:10px;
	padding-top:10px;
	padding-bottom:10px;
	background-color:white;
}
</style>
<%@include file="bootstrap.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
<br>
<br>
<br>
<br>
<a href="shop"  class="btn btn-primary" role="button" style="margin-left:100px;" >Continue Shopping</a>
<a href="user_clearcart"  class="btn btn-primary" role="button" style="margin-right:100px;" >Clear Cart</a>
<table id="set" class="table table-hover">
<tr>
<th><center>S.No.</center></th>
<th><center>Product</center></th>
<th><center>Brand</center></th>
<th><center>price</center></th> 
<th><center>size</center></th>
<th><center>Quantity</center></th>
<th><center>Image</center></th>
<th><center>remove</center></th>
</tr>
<form action="user_proceedtoorder" method="post" >
 <c:forEach var="u" items="${usercartitems}"> 
 <tr>
<td></td>
<td>${u.pname}</td>
<td>${u.supname}</td>
<td>${u.price}</td>
<td>${u.psize}</td>
<td>${u.quantity}</td> 
<td><img src="resources/images/products/${u.xid}.jpg" alt="problem displaying" style="width:250px;height:200px;"></td>
<td><a href="user_removeitem?id=${u.xid}"><span class="glyphicon glyphicon-remove"></span></a>
<%-- <a href="user_updateqty?id=${u.xid}"><span class="glyphicon glyphicon-ok"></span></a> --%>
</td>
</tr>
  </c:forEach>
  </form>
  
</table>
<br>
  <center><input type="submit" id="btn" onclick="showData()" class="btn btn-success" value="Ship to"></center>

<form:form action="user_placeorder" id="info" method="post" commandName="shippingdetails" style="visibility:hidden;">
<center>
<h2><center>Select Shipping Address</center></h2>
<label ><h3>Phone</h3></label><br>
<form:input type="text" id="phone"  path="phone"/><br>

<label><h3>Address</h3></label><br>
<label ><h5>H.No.</h5></label>
<form:input type="text" id="hno" path="hno"/><br>
<label ><h5>Street</h5></label>
<form:input type="text" id="street" path="street"/><br>
<label><h5>Location</h5></label>
<form:input type="text" id="loc" path="loc"/><br>
<label ><h5>Area</h5></label>
<form:input type="text" id="area" path="area"/><br>
<label ><h5>City</h5></label>
<form:input type="text" id="city" path="city"/><br>
<label ><h5>State</h5></label>
<form:input type="text" id="state" path="state"/><br>
<form:checkbox path="update" value="true"/>Use this as my default address<br>
<input type="submit" class="btn btn-success"  value="Proceed to Payment"/></center>
</form:form>

</body>
</html>