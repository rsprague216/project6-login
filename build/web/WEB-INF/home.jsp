<%-- 
    Document   : home
    Created on : Apr 10, 2018, 7:10:00 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="/project6/css/homeCSS.css">
    <body>
        <h1>This is the home page!</h1>
        
        <c:choose>
            <c:when test="${user != null}">
                <h2>
                    <img src="pictures/genericPic.jpg" />
                    <p class="loginMessage">Logged in as <b><c:out value="${user.getName()}" /></b></p>
                </h2>
                <nav>
                    <a href="/project6/newpost">new post</a> | 
                    <a href="/project6/logout">logout</a>
                </nav>
                
                
                    <c:forEach var="userComment" items="${userComments}">
                        <div class="comments">
                            <b><c:out value="${user.getName()}" /></b>
                            <div class="commentBody"><c:out value="${userComment}" /></div>
                        </div>
                    </c:forEach>
                
                

            </c:when>
            <c:otherwise>
                <h2>Not logged in!</h2>
                <form method="GET" action="/project6/login">
                    <input type="submit" value="Login" />
                </form>
                <nav>
                    <a href="/project6/signup">new user?</a>
                </nav>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
