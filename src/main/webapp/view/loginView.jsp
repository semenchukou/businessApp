<%--
  Created by IntelliJ IDEA.
  User: 37533
  Date: 31.03.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <style>
            td {
                font-size: 20px;
                padding-left: 5px;
                align-content: center;
                padding-bottom: 3px;
            }
        </style>
    </head>
    <body>
        <p style="color: red;">${errorString}</p>
        <h3 style="font-size:40px;" align="center">Ввод данных пользователя.</h3>
        <form action="${pageContext.request.contextPath}/?command=login" method="post">
            <table border="0" cellspacing="5" cellpadding="10" align="center">
                <tr>
                    <td>ФИО:</td>
                    <td><input type="text" name="fio" style="font-size:20px;"/></td>
                </tr>
                <tr>
                    <td>Курс:</td>
                    <td><input type="text" name="course" style="font-size:20px;"/></td>
                </tr>
                <tr>
                    <td>Группа:</td>
                    <td><input type="text" name="group" style="font-size:20px;"/></td>
                </tr>
                <tr>
                    <td>Год:</td>
                    <td><input type="text" name="year" style="font-size:20px;"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type='submit' style="font-size:20px;"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
