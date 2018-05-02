<%-- 
    Document   : signup
    Created on : Apr 13, 2018, 10:08:25 PM
    Author     : rspra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body>
        <h1>Sign Up page</h1>
        <c:if test="${not empty error}">
            <c:out value="${error}" />
        </c:if>
        <form method="POST" action="/project6/signup">
            <input type="text" name="username" placeholder="Username" />
            <br /><br />
            <input type="password" name="password" placeholder="Password" />
            <br /><br />
            <input type="password" name="confirmPW" placeholder="Confirm Password" />
            <br /><br />
            <input type="submit" name="submit" value="submit" />
        </form>
    </body>
</html>
