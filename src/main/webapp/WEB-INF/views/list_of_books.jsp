<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список книг</title>
    <style>
        <%@include file="../resources/css/styles.css" %>
    </style>
</head>
<body>
<div id="footer">
    <h1>Книжный каталог</h1>
</div>
<div id="path"><a href="main_page">Главная</a> > Список книг </div>
<div id="logout"><a href="/">Logout</a></div>
<div id="search_div">
    <form action="books_of_author?searched_book_name=">Введите название книги <input type="text" name="searched_book_name">
        <input type="submit" value="Искать книгу"></form>
</div>
<div id="main">
    <h2>Список книг</h2>
    <p align="right"><input type="button" value="Создать книгу" onClick='location.href="create_book"'></p><br>
    <c:if test="${!empty listBook}">
    <table style="width: 100%" border="1">
        <tr style="background-color: gray">
            <td>Название</td>
            <td>Краткое описание</td>
            <td>Год издания</td>
            <td>Авторы</td>
            <td>Actions</td>
        </tr>
        <c:forEach items="${listBook}" var="book">
        <tr>
            <td>${book.nameOfBook}</td>
            <td>${book.shortDescription}</td>
            <td>${book.yearOfPublishing}</td>
            <td>author_set_join</td>
            <td><a href="book_modify=${book.id}">Модифицировать</a>
                <a href="delete_book=${book.id}">Удалить</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
</body>
</html>