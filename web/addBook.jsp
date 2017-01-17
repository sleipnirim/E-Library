<%--
  Created by IntelliJ IDEA.
  User: sleipnir
  Date: 17.1.17
  Time: 23.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить книгу</title>
</head>
<body>
    <link href="WEB-INF/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <form action="Controller">
        <input type="hidden" name="command" value="add">
        <table align="center">
            <tr>
                <th align="right">Название:</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th align="right">Автор:</th>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <th align="right">Описание:</th>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <th align="right">Год издания:</th>
                <td><input type="text" name="year"></td>
            </tr>
            <tr>
                <td align="center"><input type="submit" value="Отправить"></td>
            </tr>
        </table>
    </form>
</body>
</html>
