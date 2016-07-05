<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о всех работах</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все работы:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Срок выполнения</th>
                <th>Описание</th>
                <th>ID назначенного работника</th>
                <th>Действия</th>
            </tr>
            </thead>
            <c:forEach var="job" items="${jobs}">
                <tr>
                    <td><a href="/job/jobAbout/${job.id}" role="button">${job.id}</a></td>
                    <td>${job.deadline}</td>
                    <td>${job.description}</td>
                    <td>${job.employee.id}</td>
                    <td>
                        <a class="btn btn-default" role="button" href="/job/jobDelete/${job.id}">Удалить</a>
                        <c:if test="${job.employee == null}">
                            <a class="btn btn-default" role="button" href="/job/jobAppoint/${job.id}">Назначить работника</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-default" href="/job/jobSave" role="button">Добавить работу</a>
    </div>
</div>
</body>
</html>
