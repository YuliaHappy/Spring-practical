<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о пользователе</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Информация о пользователе:</h3>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>Id: </td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>Имя: </td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Электронная почта: </td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Дата рождения: </td>
                <td>${user.birthday}</td>
            </tr>
            <tr>
                <td>Статус регистрации: </td>
                <td>${user.registered}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
