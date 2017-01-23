<%--
  Created by IntelliJ IDEA.
  User: sleipnir
  Date: 22.1.17
  Time: 18.06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Недавно просмотренные</title>
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
                    <li class="active pull-left">
                      <a href="/CookiesList">Просмотренные книги</a>
                    </li>
                </ul>
          </div>
        </div>
    </nav>

    <h2 class="h2 text-center">Последние просмотренные книги</h2>
    <c:if test="${requestScope.status eq 1}">
        <table class="table table-responsive">
            <thead>
            <tr>
                <th>Название</th>
                <th>Автор</th>
                <th>Год издания</th>
                <th>Описание</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.books}" var="book">
                <tr>
                    <th>${book.title}</th>
                    <th>${book.author}</th>
                    <th>${book.year}</th>
                    <th>${book.description}</th>
                    <th>
                        <form action="/Controller" class="form-inline">
                            <input type="hidden" name="command" value="show">
                            <input type="hidden" name="page" value="show">
                            <input type="hidden" name="idBook" value="${book.id}">
                            <button type="submit" class="btn btn-primary">Просмотр</button>
                        </form>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${requestScope.status eq 2}">
        <c:out value="Нет просмотренных книг!" />
    </c:if>

</body>
</html>
