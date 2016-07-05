<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Назначение работника</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Назначение работника</h3>
    </div>
    <div class="panel-body">
        <form method="POST" action="/job/jobAppoint">
            <label>Работа: ${jobId}</label>
            <input type="hidden" name="idJob" value="${jobId}" />
            <div class="form-group">
                <label>Работники</label>
                <select name="idEmployee">
                    <c:forEach var="employee" items="${employees}">
                        <option value="${employee.id}">${employee.name} (${employee.id})</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="bth bth-default">Сохранить</button>
            <input class="bth bth-default" type="submit" value="Отмена" formmethod="GET" formaction="/job/allJobs"/>
        </form>
    </div>
</div>
</body>
</html>
