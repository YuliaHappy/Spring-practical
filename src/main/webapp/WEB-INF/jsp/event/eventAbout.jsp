<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о событии</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Информация о событии:</h3>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>Название: </td>
                <td>${event.name}</td>
            </tr>
            <tr>
                <td>Дата и время начала: </td>
                <td>${event.dateTime}</td>
            </tr>
            <tr>
                <td>Статус: </td>
                <td>${event.rating}</td>
            </tr>
            <tr>
                <td>Базовая стоимость билета: </td>
                <td>${event.basePriceTicket}</td>
            </tr>
            <tr>
                <td>Базовая стоимость билета для vip-мест: </td>
                <td>${event.vipPriceTicket}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
