<%--
  Created by IntelliJ IDEA.
  User: sleipnir
  Date: 20.1.17
  Time: 0.07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Просмотр</title>
</head>
<body>
    <jsp:useBean id="book" class="by.zhukovski.elibrary.bean.Book" />
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="navbar-header">
            <div class="container">
                <a class="navbar-brand" href="/IndexServlet">ELib</a>
                <ul class="nav">
                    <li class="pull-left">
                        <a href="/IndexServlet">Главная</a>
                    </li>
                    <li class="pull-left">
                        <a href="/addBook">Добавить книгу</a>
                    </li>
                    <li class="pull-left">
                        <a href="/CookiesList">Просмотренные книги</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row">
        <div class="col-md-2 col-md-offset-1">
            <h4 class="h4">Название: </h4>
        </div>
        <div class="col-md-8">
        ${requestScope.book.title}
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-1">
            <h4 class="h4">Автор: </h4>
        </div>
        <div class="col-md-8">
            ${requestScope.book.author}
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-1">
            <h4 class="h4">Год издания: </h4>
        </div>
        <div class="col-md-8">
            ${requestScope.book.year}
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-1 desc">
            <h4 class="h4">Описание: </h4>
        </div>
        <div class="col-md-8 desc">
            ${requestScope.book.description}
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-1">
            <form class="form-inline" action="Controller">
                <input type="hidden" name="command" value="download">
                <input type="hidden" name="filename" value="${requestScope.book.content}">
                <button type="submit" class="btn btn-success btn-block">Скачать</button>
            </form>
        </div>
        <div class="col-md-2 col-md-offset-1">
            <form class="form-inline" action="Controller">
                <input type="hidden" name="command" value="show">
                <input type="hidden" name="page" value="edit">
                <input type="hidden" name="idBook" value="${requestScope.book.id}">
                <button type="submit" class="btn btn-warning btn-block">Редактировать</button>
            </form>
        </div>
        <div class="col-md-2 col-md-offset-1">
            <form class="form-inline" action="Controller">
                <input type="hidden" name="command" value="delete">
                <input type="hidden" name="id" value="${requestScope.book.id}">
                <input type="hidden" name="content" value="${requestScope.book.content}">
                <button type="submit" class="btn btn-danger btn-block">Удалить</button>
            </form>
        </div>
    </div>

</body>
</html>
