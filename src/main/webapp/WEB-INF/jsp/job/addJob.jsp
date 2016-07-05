<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление работы</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавление работы</h3>
    </div>
    <div class="panel-body">
        <form method="POST" action="/job/jobSave">
            <div class="form-group">
                <label for="deadline">Дата сдачи</label>
                <input type="date" class="form-control" id="deadline" placeholder="Дата сдачи" name="deadline"/>
            </div>
            <br>
            <div class="form-group">
                <label for="description">Описание</label>
                <input type="text" class="form-control" id="description" placeholder="Описание" name="description"/>
            </div>
            <br>
            <br>
            <button type="submit" class="bth bth-default">Сохранить</button>
            <input class="bth bth-default" type="submit" value="Отмена" formmethod="GET" formaction="/job/allJobs"/>
        </form>
    </div>
</div>
</body>
</html>
