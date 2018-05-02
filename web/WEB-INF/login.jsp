<%-- 
    Document   : login
    Created on : Apr 10, 2018, 7:18:09 PM
    Author     : rspra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>log in</title>
    </head>
    <body>
        <h1>This is the login page</h1>
    <c:if test = "${not empty error}">
        <c:out value = "${error}" />
    </c:if>
        <form method="POST" action="/project6/login">
            <input type="text" name="username" placeholder="Username" />
            <br /><br />
            <input type="password" name="password" placeholder="Password" />
            <br /><br />
            <input type="submit" name="loginInfo" value="Submit" /> 
        </form>
    </body>
</html>
