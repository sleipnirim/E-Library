<%--
  Created by IntelliJ IDEA.
  User: sleipnir
  Date: 17.1.17
  Time: 23.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf8" contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Добавить книгу</title>
</head>
<body>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="navbar-header">
            <div class="container">
                <a class="navbar-brand" href="/IndexServlet">ELib</a>
                <ul class="nav">
                    <li class="pull-left">
                        <a href="/IndexServlet">Главная</a>
                    </li>
                    <li class="active pull-left">
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
        <div class="col-md-4 col-md-offset-1">
            <h3 class="h2">Добавить книгу</h3>
        </div>
    </div>
    <div class="row">
        <form action="UploadServlet" class="form-horizontal" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
            <div class="col-md-6 col-md-offset-1 form-group">
                <input type="hidden" name="command" value="add">
                <div class="control-group">
                    <label class="col-md-3 col-md-offset-1 control-label" for="title">Название</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="title" name="title" required pattern="([A-Za-zА-Яа-я0-9 ]+)" placeholder="Название">
                    </div>
                </div>
                <div class="control-group">
                    <label class="col-md-3 col-md-offset-1 control-label" for="author">Автор</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="author" name="author" required pattern="([A-Za-ZА-Яа-я ]+)" placeholder="Автор">
                    </div>
                </div>
                <div class="control-group">
                    <label class="col-md-3 col-md-offset-1 control-label" for="description">Описание</label>
                    <div class="col-md-8">
                        <textarea class="form-control" id="description"  maxlength="255" rows="4" name="description" required pattern="([A-Za-zа-яА-Я0-9 -.,]+)" placeholder="Описание"></textarea>
                    </div>
                </div>
                <div class="control-group">
                    <label class="col-md-3 col-md-offset-1 control-label" for="year">Год издания</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="year" name="year" required pattern="([\d]+)" placeholder="Год издания">
                    </div>
                </div>
                <div class="control-group">
                    <label class="col-md-3 col-md-offset-1 control-label" for="file">Файл книги</label>
                    <div class="col-md-8">
                        <input type="file" class="form-control" id="file" name="file">
                    </div>
                </div>
                <div class="col-md-offset-4 col-md-4">
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
