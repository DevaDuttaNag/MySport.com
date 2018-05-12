

<html>
<head>
<%@include file="bootstrap.jsp"%>
<link href="resources/css/first.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<style>

.show-on-hover:hover > ul.dropdown-menu {
    display: block; 
 }


</style>


</head>
<body>


<c:if test="${pageContext.request.userPrincipal.name==null}">


<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="Container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="hom" alt="Header"><span class="glyphicon glyphicon-home"></span> MySport.COM</a>
</div>
<ul class="nav navbar-nav">
<li><a href="log"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
<li><a href="reg"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
<li><a href="shop">Shop</a></li>
<li><a href="abt">About Us</a></li>
<li><a href="http://www.facebook.com"><span class="glyphicon glyphicon-facebook">F</span></a></li>
<li><a href="https://twitter.com/"><span class="glyphicon glyphicon-twitter"></span></a></li>
<li><a href="https://www.instagram.com/"><span class="glyphicon glyphicon-instagram"></span></a></li>
</ul></div>
</nav>

</c:if>

<c:if test="${pageContext.request.userPrincipal.name!=null}">


<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="Container-fluid">
<div class="navbar-header">

<security:authorize access="hasAnyRole('ROLE_ADMIN')">
<a class="navbar-brand" href="adminhom" alt="Header"><span class="glyphicon glyphicon-home"></span> MySport.COM</a>
</security:authorize>
 <security:authorize access="hasAnyRole('ROLE_USER')">
<a class="navbar-brand" href="userhom" alt="Header"><span class="glyphicon glyphicon-home"></span> MySport.COM</a>
</security:authorize> 
</div>
<ul class="nav navbar-nav">


<security:authorize access="hasAnyRole('ROLE_ADMIN')">
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
 
 
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_USER')">

<li class="dropdown show-on-hover">
        <a class="dropdown-toggle">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="shop">Basketball</a></li>
          <li><a href="dissup">Cricket</a></li>
        </ul>
 </li>
<li class="dropdown show-on-hover">
        <a class="dropdown-toggle">Brand
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addsup">Cosco</a></li>
          <li><a href="dissup">Cricket</a></li>
        </ul>
 </li>
<li class="dropdown show-on-hover">
        <a class="dropdown-toggle">Price
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addsup">0-1000</a></li>
          <li><a href="dissup">1000-2000</a></li>
          <li><a href="dissup">2000-5000</a></li>
          <li><a href="dissup">5000-10000</a></li>
          <li><a href="dissup">10,000 and More</a></li>
          </ul>
 </li>
 
<li><a href="abt">About Us</a></li>
 </security:authorize> 
 </ul>


 <ul class="nav navbar-nav navbar-right">
 
 <li><a href="user_cart">Cart <span class="glyphicon glyphicon-shopping-cart"></span></a></li>
 <li><a href="j_spring_security_logout">Log out</a></li>      
</ul>
   </div>
</nav>
</c:if>
</body>
</html>