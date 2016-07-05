<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление работника</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавление работника</h3>
    </div>
    <div class="panel-body">
        <form method="POST" action="/employee/employeeSave">
            <div class="form-group">
                <label for="name">Имя</label>
                <input type="text" class="form-control" id="name" placeholder="Имя" name="name"/>
            </div>
            <br>
            <button type="submit" class="bth bth-default btn-xs">Сохранить</button>
            <input class="bth bth-default btn-xs" type="submit" value="Отмена" formmethod="GET" formaction="/employee/allEmployees"/>
        </form>
    </div>
</div>
</body>
</html>
