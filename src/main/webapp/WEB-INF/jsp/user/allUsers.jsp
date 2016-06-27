<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация обо всех пользователях</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все зарегистрированные пользователи:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Почта</th>
                <th>Дата рождения</th>
                <th>Действия</th>
            </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><a href="/user/userAbout/${user.id}" role="button">${user.id}</a></td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.birthday}</td>
                    <td><a class="btn btn-default" role="button" href="/user/userDelete/${user.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-default" href="/user/userSave" role="button">Добавить пользователя</a>
    </div>
</div>
</body>
</html>
