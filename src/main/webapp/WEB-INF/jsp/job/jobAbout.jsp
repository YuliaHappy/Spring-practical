<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о работе</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Информация о работе:</h3>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>Id: </td>
                <td>${job.id}</td>
            </tr>
            <tr>
                <td>Дата выполнения: </td>
                <td>${job.deadline}</td>
            </tr>
            <tr>
                <td>Описание: </td>
                <td>${job.description}</td>
            </tr>
            <tr>
                <td>ID назначенного работника: </td>
                <td>${job.employee.id}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
