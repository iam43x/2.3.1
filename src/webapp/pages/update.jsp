<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Редактирование данных</title>
    </head>
    <body>
        <h1 style="text-align: center">Изменить информацию о пользователе</h1>
        <hr>
        <form style="text-align: center" method="post">
            ${user.getId()}
            <input type="text" name="firstName" value="${user.getFirstName()}">
            <input type="text" name="lastName" value="${user.getLastName()}">
            <input type="hidden" name="id" value="${user.getId()}">
            <input type="submit" value="Сохранить" formaction="/updt">
        </form>
    </body>
</html>
