<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<%-- <%@include file="adminheader.jsp" %>
 --%><br>
<br>
<br>
<br>
<form:form action="addproduct" method="post" commandName="products" > 
<Center>
<label>Enter Product Name</label><br>
<form:input path="pname"/><br>
<label>Enter Product Category</label><br>
<form:select path="pcat" items="${categories}"/><br>

<input type="submit" value="Add Product"></Center>
</form:form>

</body>
</html>