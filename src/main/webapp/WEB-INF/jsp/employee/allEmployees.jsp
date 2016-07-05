<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация обо всех работниках</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Все зарегистрированные работники:</h3>
    </div>
    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Действия</th>
            </tr>
            </thead>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><a href="/employee/employeeAbout/${employee.id}" role="button">${employee.id}</a></td>
                    <td>${employee.name}</td>
                    <td>
                        <a class="btn btn-default" role="button" href="/employee/employeeDelete/${employee.id}">Удалить</a>
                        <c:if test="${employee.jobs != null && employee.jobs.size() != 0}">
                            <a class="btn btn-default" role="button" href="/employee/allJobs/${employee.id}">Список работ</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-default" href="/employee/employeeSave" role="button">Добавить работника</a>
    </div>
</div>
</body>
</html>
