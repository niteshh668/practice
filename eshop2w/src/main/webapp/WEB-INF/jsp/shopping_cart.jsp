<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
Here is your cart

<table>
<tr><th>Name</th><th>Type</th><th>Price</th></tr>
<c:forEach items="${ShoppingCart}" var="product">
		<tr>
			<td>${product.name}</td>
			<td>${product.type}</td>
			<td>${product.price}</td>
		</tr>	
	</c:forEach></table></body>
	
	<h2>Your Total Cost is </h2>
	<h2>Do u want to shop more  please <a href="/eshop2w/">click here  </a></h2>
<h2>	IF you  want to checkout please <a href="/eshop2w/checkout">click here  </a></h2>
</html>