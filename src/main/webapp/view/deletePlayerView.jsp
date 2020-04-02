<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Requests List</title>
    <style>
        tr:nth-child(even) {
            background-color: #f2f2f2;
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
<h3 align="center" style="font-size:40px;">Delete player</h3>

<p style="color: red;">${errorString}</p>

<form action="${pageContext.request.contextPath}/?command=delete" method="post">
    <p align="center" style="font-size:25px;">Choose player:
        <select name="player_id" style="font-size:20px;">
            <c:forEach items="${players}" var="player">
                <option value="${player.idPlayers}" style="font-size:20px;">${player.name}, goals: ${player.goals}, transfer cost: ${player.transfer_cost}</option>
            </c:forEach>
        </select>
        <input type='submit' value="Delete" style="font-size:20px;"/>
    </p>
</form>


</body>
</html>