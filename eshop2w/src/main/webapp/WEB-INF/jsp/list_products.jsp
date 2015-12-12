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
Following are list of products available in the store
<table>
<tr><th>Name</th><th>Type</th><th>Price</th><th>add</th><th>delete</th></tr>
<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.name}</td>
			<td>${product.type}</td>
			<td>${product.price}</td>
			<td><a href="/eshop2w/cart?productId=${product.id}">Add To Cart</a></td><td><a href="/eshop/delete?productId=${product.id}">delete To Cart</a></td>
		</tr>	
	</c:forEach></table>
	
	
</body>
</html>