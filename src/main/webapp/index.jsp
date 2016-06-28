<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <jsp:include page="WEB-INF/tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
    <form class="panel panel-info" action="/user/allUsers">
        <div class="panel-heading">
            <h3 class="panel-title">Получить информацию о всех пользователях:</h3>
        </div>
        <div class="panel-body">
            <input class="bth bth-default" type="submit" value="В виде списка">
            <input class="bth bth-default" type="submit" value="В виде PDF" formaction="/user/pdfUsers">
        </div>
    </form>
    <form class="panel panel-info" action="/auditorium/allAuditoriums">
        <div class="panel-heading">
            <h3 class="panel-title">Получить информацию о всех аудиториях:</h3>
        </div>
        <div class="panel-body">
            <input class="bth bth-default" type="submit" value="В виде списка">
            <input class="bth bth-default" type="submit" value="В виде PDF" formaction="/auditorium/pdfAuditoriums">
        </div>
    </form>
</body>
</html>
