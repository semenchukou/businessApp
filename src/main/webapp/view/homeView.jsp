<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
        <style>
            li {
                margin-bottom: 20px;
            }
            li:last-child {
                margin-bottom: 0px;
            }
            input[type=submit]
            {
                width: 20em;  height: 2em;
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
        <h3 align="center" style="font-size:30px;"><%=session.getAttribute("fio")%>, <%=session.getAttribute("course")%> курс,
            <%=session.getAttribute("group")%> группа, <%=session.getAttribute("year")%> год</h3>
        <p align="center" style="color: red;">${errorString}</p>
        <table border="0" cellspacing="5" cellpadding="10" name="main" align="center">
            <tr>
                <td >
                    <ul style="list-style: none;">
                        <li style="font-size:30px;">
                            Dictionary:
                        </li>
                        <li>
                            <select style="font-size:25px;" name="dict" form="forward">
                                <option style="font-size:25px;" value="players">Players</option>
                                <option style="font-size:25px;" value="clubs">Clubs</option>
                            </select>
                        </li>
                    </ul>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/?command=router" method="post" id="forward">
                        <ul style="list-style: none;">
                            <li>
                                <input type="submit" name="bt" value="add" style="font-size:25px;"/>
                            </li>
                            <li>
                                <input type="submit" name="bt" value="watch" style="font-size:25px;"/>
                            </li>
                            <li>
                                <input type="submit" name="bt" value="edit" style="font-size:25px;"/>
                            </li>
                            <li>
                                <input type="submit" name="bt" value="delete" style="font-size:25px;"/>
                            </li>
                        </ul>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>