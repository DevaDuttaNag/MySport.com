<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="bootstrap.jsp"%>
<title>Insert title here</title>
<style>
div.details,div.address,div.mail
{
border: 1px solid black;
    border-radius: 8px;
	margin-left:50px;
	margin-right:50px;
	margin-top:50px;
	margin-bottom:50px;
	padding-left:20px;
	padding-right:20px;
	padding-top:30px;
	padding-bottom:30px;
background-color:white;

}

</style>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>
<div class="container">
<form:form action="registeruser" method="post" commandName="userDetails"  modelAttribute="userDetails"  enctype="multipart/form-data"> <!-- -->
<div class="details">
    <div class="row">
       	<div class="col-xs-5">
        	  <label for="fname">First Name</label>
           		<form:input class="form-control" path="fname"/>
      	</div>
      	<div class="col-xs-6">
        	<label for="sname">Secound Name</label>
        	<form:input class="form-control" path="sname"/>
     	 </div>
    </div><br>
	<div class="row">
    	  <div class="col-xs-3">
        	<label for="gender">Gender</label><br>
       			<div class="radio-inline">
  				<form:radiobutton path="gender" value="Male"/>Male
				</div> 
				<div class="radio-inline">
  				<form:radiobutton path="gender" value="Female"/>Female
				</div>
			</div>
			<div class="col-xs-4">
			<label for="imagefile">Upload your image</label><br>
			<form:input type="file" class="form-group" path="imagefile" placeholder="Browse"/>
      		</div>	
    	  <div class="col-xs-4">
        		<label for="phone">Phone</label>
        		<form:input class="form-control" path="phone"/>
      		</div>
     </div><br>
     </div>
     		 <div class="address">
      				<div class="row">
      						<div class="col-xs-4">
      	 						 	<label for="hno">House no.</label>
        							<form:input class="form-control" path="hno"/>
     						 </div>
   				  			 <div class="col-xs-4">
     	   							<label for="street">Street/Lane</label>
        							<form:input class="form-control" path="street"/>
      						</div>
         					<div class="col-xs-4">
      		 						 <label for="loc">Locality/Colony</label>
       						 		<form:input class="form-control" path="loc"/>
      						</div>
      				</div><br>
		   			<div class="row">
      							<div class="col-xs-4">
        								<label for="area">Area/Landmark</label>
        								<form:input class="form-control" path="area"/>
      							</div>
      							<div class="col-xs-4">
        								<label for="city">City</label>
        								<form:input class="form-control" path="city"/>
      							</div>
      							<div class="col-xs-4">
        								<label for="state">State</label>
       							 		<form:input class="form-control" path="state"/>
      							</div>
      				</div><br>
      		  </div>
      <div class="mail">
      		 <div class="row">
       			<div class="col-xs-4">
        			<label for="mid">Enter Your Mail ID</label>
        			<form:input class="form-control" path="mid"/>
      			</div>
     		 	<div class="col-xs-3">
        			<label for="password">Enter Password</label>
        			<form:password class="form-control" path="password"/>
    			  </div>
      			<div class="col-xs-4">
        			<label for="password">Re-enter Password</label>
        			<form:password class="form-control" path="repassword"/>
      			</div>
   			 </div>
  		</div>
  		<div>
 	<center><input type="submit" class="btn btn-success" value="Register"><!-- Register <span class="glyphicon glyphicon-ok-sign"></span></button></center> --> 
  </center></div>
  </form:form>
</div>
<!-- <center><button type="Button" class="btn btn-success">Register <span class="glyphicon glyphicon-ok-sign"></span></button></center> -->
<%@include file="footer.jsp" %>
<br>
<br>
</body>
</html>