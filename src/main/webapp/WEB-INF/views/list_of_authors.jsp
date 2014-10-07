<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список авторов</title>
    <style>
        <%@include file="../resources/css/styles.css" %>
    </style>
</head>
<body>
<div id="footer">
    <p align="center"><h1>Книжный каталог</h1></p>
</div>
<div id="container">
    <div id="path"><a href="main_page">Главная</a> > Список авторов </div>
    <div id="logout"><a href="">Logout</a></div>
</div>
<div id="main">
    <h2>Список авторов</h2>
    <p align="right"><input type="button" value="Создать автора" onClick='location.href="create_author"'></p>
    <c:if test="${!empty authorsList}">
    <table style="width: 100%" border="1">
        <tr style="background-color: gray">
            <td>Фамилия</td>
            <td>Имя</td>
            <td>Actions</td>
        </tr>
        <c:forEach items="${authorsList}" var="author">
        <tr>
            <td>${author.lastName}</td>
            <td>${author.firstName}</td>
            <td><a href="update_author=${author.id}">Модифицировать</a>
                <a href="delete_author=${author.id}">Удалить</a>
                <a href="books_of_author=${author.id}">Список книг</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
</body>
</html>