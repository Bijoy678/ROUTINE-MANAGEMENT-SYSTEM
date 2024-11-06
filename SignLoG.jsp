<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>SignUp page</title>
    </head>
    <body>
        <center>
        <h1> SignUp Page </h1> 
            <form action="SignUpLogin" method="post">
                <table>
                <!-- SignUp login table  -->
                    <tr><td>Enter user id</td> <td><input type="text" placeholder="UserID" name ="id" required></td></tr>
                    <tr><td>Password</td><td><input type="password" placeholder="Password" name ="pws" required></td></tr>
                 <tr><td>Shortname</td> <td><input type="text" placeholder="Shortname" name ="Shot" required></td></tr>
                 <tr><td>Enter Teacher Id</td> <td><input type="text" placeholder="TecherID" name ="Tech" required></td></tr>
                 
               
                 
                    
                    <tr><td>Submit </td><td><input type="submit" value="Submit"></td></tr>  <tr><td>   <input type="reset" value="Reset"> </td> </tr>
                </table>
            </form>
        </center>
    </body>
</html>
    