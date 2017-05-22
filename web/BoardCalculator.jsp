<%-- 
    Document   : BoardCalculator
    Created on : May 21, 2017, 6:28:14 PM
    Author     : Krebons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter the following data:</h1>
        <form method="POST" action="boardCalculator">
            <div class="form-element">  
            <label for="height">Height </label>                  
            <input value="<%=(request.getParameter("height")!=null)?request.getParameter("height"):""%>" type="text" class="normal" placeholder="Enter your height in cm" id="height" name="height" required aria-required="true" aria-describedby="name-format" />                    
            </div>
    
    <div class="form-element">                    
        <input type="submit" class="btn" value="Submit" onclick='formValidator()'>  
    </div>
            </form>
    </body>
</html>