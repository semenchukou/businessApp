<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit club</title>
    <style>
        td {
            font-size: 20px;
            padding-left: 5px;
            align-content: center;
            padding-bottom: 3px;
        }
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        li a:hover {
            background-color: #111;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/?command=home" method="post">
    <ul style="list-style-type: none; margin: 0; padding: 0; overflow: hidden; background-color: #333;">
        <li style="float: left;">
            <a style="font-size:30px;" href="${pageContext.request.contextPath}/?command=home">Home</a>
        </li>
    </ul>
</form>
<h3 align="center" style="font-size:40px;">Edit club</h3>

<p style="color: red;">${errorString}</p>

<form action="${pageContext.request.contextPath}/?command=editChosen" method="post">
    <table border="0" cellspacing="5" cellpadding="10" align="center">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${club.name}" style="font-size:20px;"/><input type="hidden" name="dict" value="clubs"></td>
        </tr>
        <tr>
            <td>Coach:</td>
            <td><input type="text" name="coach" value="${club.coach}" style="font-size:20px;"/><input type="hidden" name="club_id" value="${club.club_id}"></td>
        </tr>
        <tr>
            <td>Foundation year:</td>
            <td><input type="number" min="1000" step="1" max="2020" name="year" value="${club.foundation_year}" style="font-size:20px;"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type='submit' name="bt" value="Cancel" style="font-size:20px;"/>
                <input type='submit' name="bt" value="Edit" style="font-size:20px;"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>