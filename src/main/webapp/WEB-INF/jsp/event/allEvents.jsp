<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о всех событиях</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все зарегистрированные события:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>Название</th>
                <th>Дата и время начала</th>
                <th>Статус</th>
                <th>Базовая цена билета</th>
                <th>Базовая цена билета для vip-мест</th>
            </tr>
            </thead>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td><a href="/event/eventAbout/${event.name}" role="button">${event.name}</a></td>
                    <td>${event.dateTime}</td>
                    <td>${event.rating}</td>
                    <td>${event.basePriceTicket}</td>
                    <td>${event.vipPriceTicket}</td>
                    <td><a class="btn btn-default" role="button" href="/event/eventDelete/${event.name}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
