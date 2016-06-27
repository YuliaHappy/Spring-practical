<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Добавление пользователя</h3>
    </div>
    <div class="panel-body">
        <form method="POST" action="/user/userSave">
            <div class="form-group">
                <label for="name">Имя</label>
                <input type="text" class="form-control" id="name" placeholder="Имя" name="name"/>
            </div>
            <br>
            <div class="form-group">
                <label for="email">Электронная почта</label>
                <input type="email" class="form-control" id="email" placeholder="Электронная почта" name="email"/>
            </div>
            <br>
            <div class="form-group">
                <label for="birthday">Дата рождения</label>
                <input type="date" class="form-control" id="birthday" placeholder="Дата рождения" name="birthday"/>
            </div>
            <br>
            <button type="submit" class="bth bth-default btn-xs">Сохранить</button>
            <input class="bth bth-default btn-xs" type="submit" value="Отмена" formmethod="GET" formaction="/user/allUsers"/>
        </form>
    </div>
</div>
</body>
</html>
