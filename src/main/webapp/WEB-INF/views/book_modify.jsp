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
        Модификация книги
    </div>
    <div id="logout"><a href="/">Logout</a></div>
</div>
<div id="main">
    <form:form method="post" modelAttribute="book">
        <h2>Заполните необходимые значения и нажмите кнопку</h2>
        <input type="submit" value="Применить"><br>
        <table>
            <tr>
                <td>
                    Название
                </td>
                <td>
                    <form:input path="nameOfBook" />
                </td>
            </tr>
            <tr>
                <td>
                    Краткое описание
                </td>
                <td>
                    <form:input path="shortDescription" />
                </td>
            </tr>
            <tr>
                <td>Год издания</td>
                <td>
                    <form:input path="yearOfPublishing" size="4" />
                </td>
            </tr>
            <tr>
                <td>Автор(ы)</td>
                <td>Список авторов</td>
            </tr>
        </table>
        </form:form>
</div>
</body>
</html>