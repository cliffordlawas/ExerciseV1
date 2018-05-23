<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Product Management</title>
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
      
   </head>
   <style>
   .btn-primary-custom {background-color: #3c3c3c;border-color: #3c3c3c;}
	.btn-primary-custom:hover, .btn-primary-custom:focus { background-color: #6d6b6b;border-color: #6d6b6b;}
   	body {background: url("https://www.toptal.com/designers/subtlepatterns/patterns/photography.png");}
   	html,body{height:100%;}
   	thead {
   		 background-color: #fafafa;
    	padding: 10px;
   	}
   	thead > tr > td {
   		padding-top: 14px!important;
    	padding-bottom:14px!important;
   	}
   	td {
   		padding-left: 10px!important;
   		padding-right: 10px!important;
   	}
   	
   	.container-custom {background: white;border: 1px solid #f1ecec;padding: 38px;-webkit-box-shadow: 0px 0px 22px -6px rgba(0,0,0,0.11); -moz-box-shadow: 0px 0px 22px -6px rgba(0,0,0,0.11);box-shadow: 0px 0px 22px -6px rgba(0,0,0,0.11);border-top: 0;height: 100%;}
   	.title { position:relative;text-align:  center;padding-bottom: 14px;padding-top: 14px;}
   </style>
   <body>
   <div class='container container-custom'>
  		 <br/>
  		<h5 class='title' >Product Management 
  		<a class='btn btn-success pull-right btn-sm ' style=" position: absolute; right: 0; right: 0;top: 11px;" href='${baseURL}/product/add-new'>+ Add Product</a>
  		<a class='btn btn-primary pull-right btn-sm btn-primary-custom' style=" position: absolute;  left: 0;top: 11px;" href='${baseURL}/j_spring_security_logout'>< Log out</a>
  		</h5>

      <table class="table table-hover table-sm table-borderless">
           <thead>
         <tr>
            <td>Product Name</td>
            <td>Price</td>
            <td>Category</td>
            <td>Availability</td>
            <td style='text-align: center;'>Action</td>
         </tr>
          </thead>
         <tbody>
          <c:forEach items="${product}" var="s">
            <tr>
               <td>${s.product['name']}</td>
               <td>${s.product['price']}</td>
               <td>${s.category['category_name']}</td>
				<td><c:if test="${s.product['available'] != true}"><c:out value="Not Available"/></c:if> <c:if test="${s.product['available'] == true}"><c:out value="Available"/></c:if></td>
               	<td style='text-align: center;'>
               	<div class="row">
               	<div class="col-xs-12 col-sm-6" style='padding-right: 6px;'><a class='btn btn-danger btn-sm btn-block' href="${baseURL}/product/delete/${s.product['id']}"> Delete </a>   	</div>
               	<div class=" col-xs-12  col-sm-6"  style='padding-left: 6px;'><a class='btn btn-warning btn-sm btn-block' href="${baseURL}/product/edit/${s.product['id']}"> Edit </a> 	</div>
               	</div>
               	</td>
              
            </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
   </body>
</html>