<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To ROUTINE TABLE</title>
</head>
<body>




<h1> SignUp page</h1>


            <form action="routine" method="post">
<table>

     <tr>
                <td><label for="stream">Stream:</label></td>
                <td>
                    <select id="stream" name="Stream" onchange="updateSubjectOptions()">
                        <option value="">Select Stream</option>
                        <option value="Arts">Arts</option>
                        <option value="Science">Science</option>
                        <option value="Commerce">Commerce</option>
                    </select>
                </td>
            </tr>



    <tr>
    <td>Submit </td>
    <td><input type="submit" value="Submit"></td>
    </tr>
</table>
            </form>



<!--  java code here  -->

</body>
</html>