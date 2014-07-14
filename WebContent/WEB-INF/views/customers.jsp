<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Products</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Products</h1>
					<p>All the available products in our store</p>
				</div>
			</div>
		 </section>
		 <section class="container">
		 	<div class="row">
	 			<c:forEach items="${customers}" var="customer"> 
		 		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
		 			<div class="thumbnail">
		 				<div class="caption">
		 					<h3>${customer.customerId}</h3>
		 					<p>${customer.name}</p>
		 					<p>Address: ${customer.address}</p>
		 					<p>Orders Made: ${customer.noOfOrdersMade}</p>
		 				</div>
		 			</div>
		 		</div>
		 		</c:forEach>
		 	</div>	
		 </section>
	</body>
</html>