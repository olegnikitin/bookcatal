<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главная</title>
</head>
<style>
    <%@include file="../resources/css/styles.css" %>
</style>
<body>
<div id="footer">
    <h1>Книжный каталог</h1>
</div>
<div id="container">
    <div id="path">
        <a href="main_page">Главная</a> >
        <a href="list_of_books">Список книг</a> >
        Список книг автора
    </div>
    <div id="logout"><a href="/">Logout</a></div>
</div>
<div id="main">
    <form:form commandName="book">
    <h2>Список книг</h2><br>
    <!-- установить проверку и сообщение об ошибке -->
    <table style="width: 100%">
        <tr style="background-color: gray">
            <td>Название</td>
            <td>Краткое описание</td>
            <td>Год издания</td>
            <td>Авторы</td>
        </tr>
        <tr>
            <td>${nameOfBook}</td>
            <td>${shortDescription}</td>
            <td>${yearOfPublishing}</td>
            <td>авторы</td>
        </tr>
    </table>
    </form:form>
</div>
</body>
</html>