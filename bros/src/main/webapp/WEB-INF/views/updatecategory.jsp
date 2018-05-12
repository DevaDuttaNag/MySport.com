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
<form:form action="updcategory" method="post" commandName="ucat" > 
<Center>
<label>Category ID</label><br>
<form:input type="text" path="catid" readonly="true" /><br>
<label>Category Name</label><br>
<form:input type="text" path="catname"/><br>
<input type="submit" value="Update Category"></Center>
</form:form>





</body>
</html>