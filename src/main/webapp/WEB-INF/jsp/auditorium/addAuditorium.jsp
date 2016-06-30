<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление аудитории</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавление аудитории</h3>
    </div>
    <div class="panel-body">
        <form method="POST" action="/auditorium/auditoriumSave">
            <div class="form-group">
                <label for="name">Название</label>
                <input type="text" class="form-control" id="name" placeholder="Название" name="name"/>
            </div>
            <br>
            <div class="form-group">
                <label for="count">Количество посадочных мест</label>
                <input type="number" class="form-control" id="count" placeholder="Количество посадочных мест" name="countOfSeats"/>
            </div>
            <br>
            <button type="submit" class="bth bth-default btn-xs">Сохранить</button>
            <input class="bth bth-default btn-xs" type="submit" value="Отмена" formmethod="GET" formaction="/auditorium/allAuditoriums"/>
        </form>
    </div>
</div>
</body>
</html>
