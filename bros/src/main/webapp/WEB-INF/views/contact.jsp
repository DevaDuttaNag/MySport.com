<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="bootstrap.jsp" %>
<title>Insert title here</title>
</head>
<body>s
<%@include file="header.jsp" %>
<br>
<br><br><br>
<div class="container">

  <h2>Media Object</h2>
  <p>Use the "media-left" class to left-align a media object. Text that should appear next to the image, is placed inside a container with class="media-body".</p>
  <p>Tip: Use the "media-right" class to right-align the media object.</p><br>
  
  <!-- Left-aligned media object -->
<c:forEach var="x" items="${comments}">
  <div class="media">
    <div class="media-left">
      <img src="resources/images/users/${x.mid}.jpg" alt="cannot display" class="media-object" style="width:60px">
    </div>
    <div class="media-body">
      <h4 class="media-heading">${x.mid}</h4>
      <p>${x.comment}</p>
    </div>
  </div>
</c:forEach>
<c:if test="${pageContext.request.userPrincipal.name!=null}">
 <security:authorize access="hasAnyRole('ROLE_USER')">
<form:form action="pagereview" method="post">
	<label for="rating">WRITE A REVIEW</label>
<div class="radio-inline">
  				<form:radiobutton path="rating" value="1"/>
</div>
<div class="radio-inline">
  				<form:radiobutton path="rating" value="2"/>
</div>
<div class="radio-inline">
				<form:radiobutton path="rating" value="3"/>
</div>
<div class="radio-inline">
  				<form:radiobutton path="rating" value="4"/>
</div>
<div class="radio-inline">
  				<form:radiobutton path="rating" value="5"/>
</div>
				<p><textArea path="comment"></textArea></p>
				<input type="submit" class=""btn btn-success" value="Add Review">
</form:form>
</security:authorize> 
</c:if>
<%@include file="footer.jsp" %>
</body>
</html>