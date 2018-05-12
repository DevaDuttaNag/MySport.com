<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<style>
.itm{
width:70%;
margin: auto;
}

.show-on-hover:hover > ul.dropdown-menu {
    display: block; 
 }

</style>

<script>
var app = angular.module('myApp', []);

function Admincontrols($scope, $http) {

	  $scope.sortType     = 'catid'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchCategoryName   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonConC'
                }).success(function(data, status, headers, config) {
                        $scope.Category = data; 
                }).error(function(data, status, headers, config) {
                        
                });

        };
};
</script>

<title>Admin category</title>
</head>

<body>
<%@include file="header.jsp" %>
<br>
<br>
<br>
<br>
<div class="container" ng-app="myApp" ng-controller="Admincontrols">
  
  <form>
    <div class="form-group">
    
      <div class="input-group">
       
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        
        <input type="text" class="form-control" placeholder="Search Category" ng-model="searchCategory">
 
      </div>  
         
    </div>
        
  </form>
    
   <div ng-init="getDataFromServer();">
  <table class="table table-bordered table-striped">
    <thead>
   
      <tr>
     	 <td>
            <a href="#" ng-click="sortType = 'catid'; sortReverse = !sortReverse">
             <b>Category ID</b> 
             <span ng-show="sortType == 'catid' && !sortReverse" class="fa fa-caret-down"></span>
             <span ng-show="sortType == 'catid' && sortReverse" class="fa fa-caret-up"></span>
           </a>
        </td>
       
       <td>
          <a href="#" ng-click="sortType = 'catname'; sortReverse = !sortReverse">
          	<b>Category Name</b> 
            <span ng-show="sortType == 'catname' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'catname' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>        
      <td>
      <b>Edit</b>
      </td>   
       </tr>
      
    </thead>
        <tbody>
   
      <tr ng-repeat="cat in Category | orderBy:sortType:sortReverse | filter:searchCategory">
        <td>{{cat.catid}}</td>
        <td>{{cat.catname}}</td>
        <td><a href="updcat?id={{cat.catid}}" class="btn btn-default" role="button">Edit/Disable</a></td>
	  </tr>
  </tbody>
    
  </table>

</div>
</div>
</body>
</html>










