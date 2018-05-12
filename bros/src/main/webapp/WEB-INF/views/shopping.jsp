<html lang="en">
<%@include file="bootstrap.jsp" %>
<head>

  <title>Bootstrap Example</title>


<script>

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
<div class="container" >

  <h2>Image Gallery</h2>
  <p>The .thumbnail class can be used to display an image gallery.</p>
     <div class="row">
<c:forEach var="x" items="${udata}">
<div class="col-md-3" id="userdisplay">
          <form action="user_addprod?id=${x.xid}" method="post" >
          <img onmouseover="bigImg(this)" onmouseout="normalImg(this)" src="resources/images/products/${x.xid}.jpg" alt="problem displaying" style="width:100%"> 
        	<center>
        	<b>Best Price :${x.price}</b><br>
           ${x.pname}<br>
           Brand : ${x.supname}<br>
            Category : ${x.catname} <br>
					Stock : ${x.stock} <br>     
					<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
           Size : ${x.psize}<br>       
           <input type="submit" value="add to cart"><span class="glyphicon glyphicon-shopping-cart"></span></input>
 </center>
        </form>
</div>
</c:forEach>
</div>
</div>
</body></html>