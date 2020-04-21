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
        th {
            font-size: 20px;
            font-weight: bold;
            padding-left: 5px;
            align-content: center;
            padding-bottom: 3px;
        }
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
<h3 align="center" style="font-size:40px;">List of players</h3>

<p style="color: red;">${errorString}</p>

<div>
    <table align="center" width="1000px">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Birth date</th>
            <th scope="col">Transfer cost</th>
            <th scope="col">Goals</th>
            <th scope="col">Club ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${players}" var="player">
            <tr>
                <td scope="col">${player.player_id}</td>
                <td scope="col">${player.name}</td>
                <td scope="col">${player.birth_date}</td>
                <td scope="col">${player.transfer_cost}</td>
                <td scope="col">${player.goals}</td>
                <td scope="col">${player.club_id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>