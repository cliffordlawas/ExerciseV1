<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${ product['name']}</title>
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<style>body{background:url(https://www.toptal.com/designers/subtlepatterns/patterns/photography.png)}body,html{height:100%}.btn-primary-custom{background-color:#3c3c3c;border-color:#3c3c3c}.btn-primary-custom:focus,.btn-primary-custom:hover{background-color:#6d6b6b;border-color:#6d6b6b}.container-custom{background:#fff;border:1px solid #f1ecec;padding:38px;-webkit-box-shadow:0 0 22px -6px rgba(0,0,0,.11);-moz-box-shadow:0 0 22px -6px rgba(0,0,0,.11);box-shadow:0 0 22px -6px rgba(0,0,0,.11);border-top:0;height:100%}</style>
</head>
<body>
	<div class='container container-custom'>
	 	<br/>
	<h5>
		<c:if test="${type == 'edit'}">
			Edit ${ product['name']}
		</c:if>
		<c:if test="${type != 'edit'}">
			Add New Product
		</c:if>
	</h5>
	 <form method='POST' action = '${baseURL}${action}${ product['id']}'>
	    <div class="form-group">
	     <input type="hidden" class="form-control" name='id' id='id' value='${ product['id']}'/>
	      <label for="name">Product Name:</label>
	      <input type="text" class="form-control" name='name' id='name' value='${ product['name']}' required>
	    </div>
	    <div class="form-group">
	      <label for="price">Price:</label>
	      <input type="number" class="form-control" name='price' id='price' value='${ product['price']}' required>
	    </div>
	    <div class='form-group'>
	    	 <label for="ctrgy">Choose Categories:</label>
			  <select class="form-control" id="categorypath" name='categorypath'>
			     <c:forEach items="${category}" var="ctrgy">
			     	<option value=${ctrgy['category_id']}
			     	${ctrgy['category_id'] == product['categoryPath'] ? 'selected="selected"' : ''}>${ctrgy['category_name']}</option>
				</c:forEach>
			  </select>
	    </div>
	    <div class="form-group">
	      <label for="price">Availability:</label><br/>
	      <label class="radio-inline"><input type="radio" value='true' name="available" ${product['available'] == true ? 'checked="checked"' : ''}> Available</label> &nbsp;
		  <label class="radio-inline"><input type="radio" value='false' name="available"  ${product['available'] == false ? 'checked="checked"' : ''}> Not Available</label>
	    </div>
	    <button type='submit' class='btn btn-primary'>SUBMIT</button>
	     <a href='${baseURL}/products'  class='btn btn-primary btn-primary-custom'>Cancel</a>
	  </form>
	
	
</div> 
</body>
</html>