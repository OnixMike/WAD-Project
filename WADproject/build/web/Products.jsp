<%-- 
    Document   : Products
    Created on : May 15, 2017, 2:49:00 PM
    Author     : student
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<h3>Here you have a list of our products. If you are not sure which size you require click <a href="SizeCalculator.jsp">here</a></h3>   
            <div>
                <table>
                   <tr>
                       <th>Name</th>
                       <th>Type</th>
                       <th>Size</th>
                       <th>Unit price</th>
                       <th>Quantity</th>
                   </tr> 
                   <c:forEach var="products" items="${applicationScope.products}">
                   
                       <tr>
                           <td> ${products.name} </td>
                           <td> ${products.type} </td>
                           <td> ${products.size} </td>
                           <td> ${products.price} </td>
                           <td> ${products.qty} </td>
                       </tr>
                       
                   </c:forEach>
        
                </table>
</div>
</html>