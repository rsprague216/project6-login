<%-- 
    Document   : newPost
    Created on : Apr 13, 2018, 11:46:31 PM
    Author     : rspra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Post</title>
    </head>
    <body>
        <h1>New Post</h1>
        <form method="POST" action="/project6/newpost">
            <input type="text" name="comment" placeholder="Have something to say?" />
            <br /><br />
            <input type="submit" name="submit" value="submit" />
        </form>
    </body>
</html>
