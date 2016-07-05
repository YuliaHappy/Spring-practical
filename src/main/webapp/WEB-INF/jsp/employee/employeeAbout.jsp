<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о работнике</title>
    <jsp:include page="../../tags/tagStyle.jsp"/>
</head>
<body style="padding: 20px">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Информация о работнике:</h3>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>Id: </td>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <td>Имя: </td>
                <td>${employee.name}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
