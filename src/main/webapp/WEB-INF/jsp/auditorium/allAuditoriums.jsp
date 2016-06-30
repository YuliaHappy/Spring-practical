<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о всех аудиториях</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все аудитории:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Количество посадочных мест</th>
                <th>Vip-места</th>
                <th>Действия</th>
            </tr>
            </thead>
            <c:forEach var="auditorium" items="${auditoriums}">
                <tr>
                    <td><a href="/auditorium/auditoriumAbout/${auditorium.id}" role="button">${auditorium.id}</a></td>
                    <td>${auditorium.name}</td>
                    <td>${auditorium.countOfSeats}</td>
                    <td>[
                        <c:forEach var="vipSeat" items="${auditorium.vipSeats}">
                          - ${vipSeat.toString()} -
                        </c:forEach>
                        ]
                    </td>
                    <td><a class="btn btn-default" role="button" href="/auditorium/auditoriumDelete/${auditorium.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-default" href="/auditorium/auditoriumSave" role="button">Добавить пользователя</a>
    </div>
</div>
</body>
</html>
