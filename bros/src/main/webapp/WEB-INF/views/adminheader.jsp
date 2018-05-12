<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%@include file="bootstrap.jsp"%>
<link href="resources/css/first.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

.show-on-hover:hover > ul.dropdown-menu {
    display: block; 
 }


</style>


</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="Container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="hom" alt="Header"><span class="glyphicon glyphicon-home"></span> MySport.COM</a>
</div>
<ul class="nav navbar-nav">


 <li class="dropdown show-on-hover">
        <a class="dropdown-toggle" >Products
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addprods">Add Product</a></li>
          <li><a href="disprods">Display products</a></li>
        </ul>
 </li>
 
 <li class="dropdown show-on-hover">
        <a class="dropdown-toggle">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addcat">Add Category</a></li>
          <li><a href="discat">Display Category</a></li>
        </ul>
 </li>
 
 
 <li class="dropdown show-on-hover">
        <a class="dropdown-toggle">Supplier
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addsup">Add Supplier</a></li>
          <li><a href="dissup">Display Supplier</a></li>
        </ul>
 </li>
 
<li><a href="admin_Xmapdata">'X'Data</a></li>      
 
</ul>
 <ul class="nav navbar-nav navbar-right">
 <li><a href="j_spring_security_logout">Log out</a></li>      
</ul>
    </div>
</nav>
<br>
<br>
<center><h1>Welcome ${name}</h1></center>
</body>
</html> --%>