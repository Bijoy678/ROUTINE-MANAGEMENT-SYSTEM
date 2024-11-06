<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body style="background-color:powderblue;">
        <center>
        <h1> Teacher Login </h1> 
            <form action="LoginSevlet" method="post">
                <table>
                    <tr><td>Enter user id</td> <td><input type="text" placeholder="name" name ="name" required></td></tr>
                    <tr><td>Password</td><td><input type="password" placeholder="password" name ="password" required></td></tr>
                    <tr><td>Pintu ok </td><td><input type="submit" value="Login"></td></tr>
                </table>
            </form>
        </center>
    </body>
</html>
    