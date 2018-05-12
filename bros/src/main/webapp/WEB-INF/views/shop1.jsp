
<html lang="en">
<%@include file="bootstrap.jsp" %>
<head>

<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

  <title>Bootstrap Example</title>


<script>
var app = angular.module('myApp', []);

function UserController($scope, $http) {

	  $scope.sortType     = 'xid'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchUserData   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonConData'
                }).success(function(data, status, headers, config) {
                        $scope.UserData = data; 
                }).error(function(data, status, headers, config) {
                        
                });

        };
};

/* function bigImg(x) {
    x.style.height = "300px";
    x.style.width = "300px";
}

function normalImg(x) {
    x.style.height = "200px";
    x.style.width = "200px";
}
 */
</script>
<style>
 div#userdisplay{
 border: 1px solid black;
    border-radius: 5px;
	padding-left:2px;
	padding-right:2px;
	padding-top:2px;
	padding-bottom:2px; 
} 

</style>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>
<br>
<br>
<div class="container" ng-app="myApp" ng-controller="UserController">

  <form>
    <div class="form-group">
    
      <div class="input-group">
       
        <div class="input-group-addon"><i class="fa fa-search"><Span class="glyphicon glyphicon-search"></Span></i></div>
        
        <input type="text" class="form-control" placeholder="Search Product" ng-model="searchUserData">
 
      </div>  
         
    </div>
        
  </form>
    
   <div ng-init="getDataFromServer();">

<div class="container">
  <h2>Image Gallery</h2>
  <p>The .thumbnail class can be used to display an image gallery.</p>

  <div class="row" >
<div class="col-md-3" ng-repeat="x in UserData  | filter:searchUserData">
    
        <!-- <a href="proview" > -->
          <div id="userdisplay" >
<%--          <c:url var="url" value="{{x.xid}}"/> 
 --%>          		<form action="user_addprod?id={{x.xid}}" method="post">
          <img onmouseover="bigImg(this)" onmouseout="normalImg(this)" src="resources/images/products/{{x.xid}}.jpg" alt="problem displaying" style="width:100%"> 
        	<center>
        	<b>Best Price : {{x.price}}  {{x.xid}}</b><br>
           {{x.pname}}<br>
           Brand : {{x.supname}}<br>
            Category : {{x.catname}} <br>
					Stock : {{x.stock}} <br>     
					<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
           Size : {{x.psize}}<br>       
           <input type="submit" value="add to cart"><span class="glyphicon glyphicon-shopping-cart"></span></input>
         <!-- <a class="btn btn-success" href="user_addprod?id={{x.xid}}">Add to <span class="glyphicon glyphicon-shopping-cart"></span> </a> -->
        </center>
        </form>
          </div>
	      
    </div>  
    </div>

    </div>
    </div>
   </div>
</body>
</html>


