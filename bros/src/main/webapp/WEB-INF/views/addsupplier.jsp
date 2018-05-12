<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<form:form action="addsupplier" method="post" commandName="supplier" >
<Center>
<label>Enter Supplier Name</label><br>
<form:input path="supname"/><br>
<label>Enter Supplier contact</label><br>
<form:input path="supcontact"/><br>
<label>Enter Supplier address</label><br>
<form:input path="supaddress"/><br>
<label>Enter Supplier email</label><br>
<form:input path="supemail"/><br>
<label>Enter Supplier products</label><br>
<form:input path="listproducts"/><br>
<label>Enter supplier status</label><br>
<form:input path="status"/><br>
<input type="submit" value="Add Supplier"></Center>
</form:form>



</body>
</html>