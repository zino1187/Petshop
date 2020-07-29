<%@page import="com.pet.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Product> productList=(List)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<title>Pet Shop</title>
<meta charset="utf-8">
<link href="/css/style.css" rel="stylesheet" type="text/css">
<style>
#realtime{
	background:yellow;
	width:250px;
	height:300px;
	
}
</style>
<!--[if IE 6]><link href="css/ie6.css" rel="stylesheet" type="text/css"><![endif]-->
<!--[if IE 7]><link href="css/ie7.css" rel="stylesheet" type="text/css"><![endif]-->
</head>
<body>
<div id="header"> 
	<%@ include file="/include/main_navi.jsp" %>
</div>
<div id="body">
  <div class="banner">&nbsp;</div>
  <div id="content">
    <div class="content">
      <ul>
      	<%for(int i=0;i<productList.size();i++){%>
      	<%Product product =(Product)productList.get(i); %>
        <li> <a href="/shop/detail?product_id=<%=product.getProduct_id()%>"><img src="/data/<%=product.getFilename() %>" width="114" height="160" alt=""></a>
          <h2><%=product.getProduct_name() %></h2>
          <p><%=product.getBrand() %><a class="more" href="#">View all</a></p>
        </li>
        <%}%>
      </ul>
    </div>
    <div id="sidebar">
      	<div id="realtime">
      		<iframe frameborder="0px" width="250px" height="300px" src="http://192.168.0.16:3000/basic/client.html"></iframe>
		</div>		      
    </div>
  </div>
  <div class="featured">
    <ul>
      <li><a href="#"><img src="images/organic-and-chemical-free.jpg" width="300" height="90" alt=""></a></li>
      <li><a href="#"><img src="images/good-food.jpg" width="300" height="90" alt=""></a></li>
      <li class="last"><a href="#"><img src="images/pet-grooming.jpg" width="300" height="90" alt=""></a></li>
    </ul>
  </div>
</div>
<div id="footer">
  <%@ include file="/include/footer.jsp" %>
</div>
</body>
</html>
