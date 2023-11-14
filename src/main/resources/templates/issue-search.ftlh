<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>BUGTRAKER</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            max-width: 600px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>BUGTRAKER</h1>
    <hr>
    <h4>Найденные задачи</h4>
    <hr>
    <#list issues as issue>
    <#if issue??>
        <b>Название: </b>${issue.title?if_exists}<br>
        <b>Описание: </b>${issue.description?if_exists}<br>
        <b>Категория: </b>${issue.categoryId?if_exists}<br>
        <b>Статус: </b>${issue.status?if_exists}<br>
        <b>Версия продукта: </b>${issue.productVersion?if_exists}<br>
        <b>Приоритет: </b>${issue.priority?if_exists}<br>
        <b>Дата создания: </b>${issue.createdDate?if_exists}<br>
        <b>Дата закрытия: </b>${issue.closedDate?if_exists}<br>
        <b>Разработчик: </b>
        <#if issue.assignedDeveloper??>
            ${issue.assignedDeveloper}
        <#else>
            Нет данных
        </#if><br>
        <b>Тестировщик: </b>
        <#if issue.assignedTester??>
            ${issue.assignedTester}
        <#else>
            Нет данных
        </#if><br>
    <#else>
        <p>Issue not found or is null.</p>
    </#if>
    </#list>

    <hr>

    <a href="/" class="btn btn-primary mt-3">Назад...</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-eMNFi9LsIT9ZNY3raL3Jy9Hj8cxUL5jSftj9FYAV9qOXib/l1rNYoHfF0ZY41Miv" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JJ6yXebFmN+Y2EZ3AXMZBRTU8HE6zB4X2uKMPWMSF7dsi/pfDePaBGJ8E9YyuZ5Y" crossorigin="anonymous"></script>
</body>
</html>