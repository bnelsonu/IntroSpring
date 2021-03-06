<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Product</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Products</h1>
					<p>Add products</p>
				</div>
			</div>
		 </section>
		 <section class="container">
		 	<form:form modelAttribute="newProduct" class="form-horizontal" action="/products/add">
		 		<fieldset>
		 			<legend>Add new Product</legend>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="productoId"><spring:message code="addProduct.form.productId.label"/></label>
		 				<div class="col-lg-10">
		 					<form:input id="productoId" path="productoId" type="text" class="form:input-large"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="productoId">Name</label>
		 				<div class="col-lg-10">
		 					<form:input id="name" path="name" type="text" class="form:input-large"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>
		 				<div class="col-lg-10">
		 					<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
		 				<div class="col-lg-10">
		 					<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
		 				<div class="col-lg-10">
		 					<form:input id="category" path="category" type="text" class="form:input-large"/>
		 				</div>
		 			</div><div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="productoId">Units in Stock</label>
		 				<div class="col-lg-10">
		 					<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
		 				</div>
		 			</div>
		 			<!-- Similary bind form:input  tag or name, unitPrice, manufacturer, category, unitsInStock and unitsInOrder-->
		 			<div class="form-group">
		 				<label class="control-label col-lg-2" for="description">Description</label>
		 				<div class="col-lg-10">
		 					<form:textarea id="description" path="description" rows="2"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2"  for="condition">Condition</label>
		 				<div class="col-lg-10">
		 					<form:radiobutton path="condition" value="New"/>New
		 					<form:radiobutton path="condition" value="Old"/>Old
		 					<form:radiobutton path="condition" value="Refurbished"/>Refurbished
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<div class="col-lg-offset-2 col-lg-10">
		 					<input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
		 				</div>
		 			</div>
				</fieldset>
			</form:form>		 	
		 </section>
	</body>
</html>