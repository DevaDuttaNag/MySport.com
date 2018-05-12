<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    border-collapse: collapse;
    width: 60%;
}

th, td,tr {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}
th{
background-color: #000000;
    color: white;
   
}

td:hover{background-color:#ffffff
color:#000000

}
</style>
<%@include file="bootstrap.jsp" %>
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
<center>
<div style="overflow-y:auto;">
<table>
<tr>
<th><center>X Id</center></th>
<th><center>Product Id</center></th>
<th><center>Category Id</center></th>
<th><center>Supplier Id</center></th>
<th><center>Stock</center></th>
<th><center>Size</center></th>
<th><center>Price</center></th>
<th><center>Image</center></th>
<th><center>Edit</center></th>
</tr>
<c:forEach items="${xdata}" var="x">
<tr>
<td>${x.xid}</td>
<td>${x.pid}</td>
<td>${x.catid}</td>
<td>${x.supid}</td>
<td>${x.stock}</td>
<td>${x.psize}</td>
<td>${x.price}</td>
<td><img src="resources/images/products/${x.xid}.jpg" alt="Cannot display" style="height:150px;width:150px;"></td>
<td><a href="updXdata?id=${x.xid}" class="btn btn-default" role="button">Edit/Disable</a></td>
</tr>
</c:forEach>
</table>
</div>
</center>

<form:form action="admin_addXdata" method="post" commandName="procatsup" enctype="multipart/form-data"> 
<Center>
<table>
<tr>
<th><center>Product Id</center></th>
<th><center>Category Id</center></th>
<th><center>Supplier Id</center></th>
<th><center>Stock</center></th>
<th><center>Size</center></th>
<th><center>Price</center></th>
<th>Browse Product Image</th>
</tr>
<tr>
<td><form:select path="pid" items="${pdata}"/></td>
<td><form:select path="catid" items="${cdata}"/></td>
<td><form:select path="supid" items="${sdata}"/></td>
<td><form:input type="text" path="stock"/></td>
<td><form:input type="text" path="psize"/></td>
<td><form:input type="text" path="price"/></td>
<td><form:input type="file" path="imagefile" placeholder="Browse"/></td>

</tr>
</table>
<%-- <label>Product Id</label>
<form:select path="pid" items="${pdata}"/>
<label>Category Id</label>
<form:select path="catid" items="${cdata}"/>
<label>Supplier Id</label>
<form:select path="supid" items="${sdata}"/>
<label>Stock</label>
<form:input type="text" path="stock"/>
<label>Price</label>
<form:input type="text" path="price"/>
 --%>

<input type="submit" value="Add Record">
</center>
</form:form>

 
 
</body>
</html>