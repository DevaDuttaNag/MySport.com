<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="bootstrap.jsp"%>
<title>Update product</title>
</head>
<body>
<%@include file="header.jsp" %><%-- 
<%@include file="adminheader.jsp" %> --%>
<br>
<br>
<br>
<br>
<form:form action="updproduct" method="post" commandName="upro" > 
<%-- 
<c:forEach var="prd" items="upro"></c:forEach>
<table>
<tr><td>
 --%>
 <center>
 <label>Product ID</label><br>
<form:input type="text" path="pid" readonly="true" /><br>
 <label>Product Name</label><br>
<form:input type="text" path="pname" /><br><!-- </td></tr>
<tr><td> -->
<label>Product Category</label><br>
<form:select path="pcat" items="${categories}"/><br>
<input type="submit" value="Update"><br>
<input type="button" value="Cancel"></center><!-- </td></tr>
</table> -->
</form:form>

</body></html>




