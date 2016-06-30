<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация об аудитории</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Информация об аудитории:</h3>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>Id: </td>
                <td>${auditorium.id}</td>
            </tr>
            <tr>
                <td>Название: </td>
                <td>${auditorium.name}</td>
            </tr>
            <tr>
                <td>Количество посадочных мест: </td>
                <td>${auditorium.countOfSeats}</td>
            </tr>
            <tr>
                <td>Vip-места: </td>
                <td>[
                    <c:forEach var="vipSeat" items="${auditorium.vipSeats}">
                        - ${vipSeat.toString()} -
                    </c:forEach>
                    ]</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
