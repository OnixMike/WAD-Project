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
<link rel="stylesheet" href="css/tablecss.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<h3>Here you have a list of our products. If you are not sure which size you require click <a href="SizeCalculator.jsp">here</a></h3> 
<c:choose>
    <c:when test="${empty sessionScope.user}">
            <div>
                <table>
                   <tr>
                       <th>Name</th>
                       <th>Type</th>
                       <th>Size</th>
                       <th>Unit price</th>
                   </tr> 
                   <c:forEach var="products" items="${applicationScope.products}">
                   
                       <tr>
                           <td> ${products.name} </td>
                           <td> ${products.type} </td>
                           <td> ${products.size} </td>
                           <td> ${products.price} </td>
                       </tr>
                       
                   </c:forEach>
                       </table>
         </c:when>   
                
        <c:otherwise>
    
        <form method="post" action="shoppingCartController" id="form-products">
            <h3>Products</h3>   
            <div>
                <table>
                    <tr>
                       <th>Name</th>
                       <th>Type</th> 
                       <th>Size</th>
                       <th>Quantity</th>
                    </tr> 
                    <c:forEach var="products" items="${applicationScope.products}">
                       <tr>
                           <td> ${products.name} </td>
                           <td> ${products.type} </td>
                           <td> ${products.size} </td>
                           <td> ${products.price} </td>
                           <td><input type="number" name="${products.id}" id="quantity"></td>
                       </tr>
                       
                    </c:forEach>
                </table>
            </div>
            <!--<input type="submit" value="Submit" name="sendOrder">-->
            <input type="submit" value="Buy" name="buyProduct">
	</form>
    </c:otherwise>
</c:choose>       
</div>
</html>