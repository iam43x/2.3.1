<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Добавить пользователя</title>
    </head>
    <body>
        <h1 style="text-align: center">Добавьте пользователя</h1>
        <hr>
        <form style="text-align: center" method="post" action="/add">
            <label for="firstName">Имя:</label>
            <input id="firstName" type="text" name="firstName">
            <label for="lastName">Фамилия:</label>
            <input id="lastName" type="text" name="lastName">
            <input type="submit" value="Добавить">
        </form>
        <p>${message}</p>
        <form style="text-align: center" method="get" action="/">
        <input type="submit" value="К списку">
        </form>
    </body>
</html>