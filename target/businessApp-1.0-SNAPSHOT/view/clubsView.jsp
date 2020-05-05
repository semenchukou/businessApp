<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Clubs List</title>
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
<h3 align="center" style="font-size:40px;">List of clubs</h3>

<p style="color: red;">${errorString}</p>

<div>
    <table align="center" width="1000px">
        <thead >
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Foundation year</th>
                <th scope="col">Coach</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${clubs}" var="club" >
            <tr>
                <td scope="col">${club.club_id}</td>
                <td scope="col">${club.name}</td>
                <td scope="col">${club.foundation_year}</td>
                <td scope="col">${club.coach}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>