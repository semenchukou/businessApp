<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Requests List</title>
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
<h3 align="center" style="font-size:40px;">Edit player</h3>

<p style="color: red;">${errorString}</p>

<form action="${pageContext.request.contextPath}/?command=editChosen" method="post">
    <table border="0" cellspacing="5" cellpadding="10" align="center">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${player.name}" style="font-size:20px;"/><input type="hidden" name="player_id" value="${player.player_id}"></td>
        </tr>
        <tr>
            <td>Transfer cost:</td>
            <td><input type="number" min="1" step="0.1" value="${player.transfer_cost}" name="transfer" style="font-size:20px;"/></td>
        </tr>
        <tr>
            <td>Goals:</td>
            <td><input type="number" min="1" step="1" value="${player.goals}" name="goals" style="font-size:20px;"/></td>
        </tr>
        <tr>
            <td>Club:</td>
            <td>
                <select name="club_id" style="font-size:20px;">
                    <c:forEach items="${clubs}" var="club">
                        <option value="${club.idClub}" style="font-size:20px;">${club.name}</option>
                    </c:forEach>
                </select>
            </td>
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