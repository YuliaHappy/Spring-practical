<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о всех работах для работника</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все работы для работника ${idEmployee}:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Срок выполнения</th>
                <th>Описание</th>
            </tr>
            </thead>
            <c:forEach var="job" items="${jobs}">
                <tr>
                    <td><a href="/job/jobAbout/${job.id}" role="button">${job.id}</a></td>
                    <td>${job.deadline}</td>
                    <td>${job.description}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
