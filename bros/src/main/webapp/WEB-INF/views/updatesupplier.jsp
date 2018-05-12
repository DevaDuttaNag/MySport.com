<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="bootstrap.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %><%-- 
<%@include file="adminheader.jsp" %> --%>
<br>
<br>
<br>
<br>
<form:form action="updsupplier" method="post" commandName="usup" >
<Center>

<label>Supplier ID</label><br>
<form:input type="text" path="supid" readonly="true"/><br>
<label>Supplier Name</label><br>
<form:input type="text" path="supname"/><br>
<label>Supplier contact</label><br>
<form:input type="text" path="supcontact"/><br>
<label>Supplier address</label><br>
<form:input type="text" path="supaddress"/><br>
<label>Supplier email</label><br>
<form:input type="text" path="supemail"/><br>
<label>Supplier products</label><br>
<form:input type="text" path="listproducts"/><br>
<label>supplier status</label><br>
<form:input type="text" path="status"/><br>
<input type="submit" value="Update Supplier"></Center>
</form:form>




</body>
</html>