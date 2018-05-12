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
<%@include file="adminheader.jsp"%> --%>
<br>
<br>
<br>
<br>
<form:form action="admin_updXdata" method="post" commandName="uxdata">
<center>
<label>XData Id</label><br>
<form:input type="text" path="xid" readonly="true"/><br>
<label>Product Id</label><br>
<form:select path="pid" items="${pdata}"/><br>
<label>Category Id</label><br>
<form:select path="catid" items="${cdata}"/><br>
<label>Supplier Id</label><br>
<form:select path="supid" items="${sdata}"/><br>
<label>Stock</label><br>
<form:input type="text" path="stock"/><br>
<label>Price</label><br>
<form:input type="text" path="price"/><br>
<label>Size</label><br>
<form:input type="text" path="psize"/><br>

  	<form:radiobutton path="status" value="Available"/>Available<br>
  	<form:radiobutton path="status" value="Not available"/>Not available
<br>
<input type="submit" value="Update Record"></center>
</form:form>
</body>
</html>