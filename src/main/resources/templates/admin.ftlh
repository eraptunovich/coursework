<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BUGTRAKER</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>BUGTRAKER</h1>
        <hr>
        <h4>Панель администратора</h4>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Логин</th>
                    <th>Почта</th>
                    <th>Активность</th>
                    <th>Роли</th>
                    <th>Бан</th>
                    <th>Редактирование</th>
                    <th>Подробная информация</th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.email}</td>
                        <td><#if user.active>true<#else>false</#if></td>
                        <td><#list user.role as role>${role}</#list></td>
                        <td>
                            <form action="/admin/user/ban/${user.userId}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button type="submit" class="btn btn-danger">Бан</button>
                            </form>
                        </td>
                        <td><a href="/admin/user/edit/${user.userId}" class="btn btn-primary">Редактирование</a></td>
                        <td><a href="/user/${user.userId}" class="btn btn-info">Подробная информация</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>

        <a href="/category/create" class="btn btn-primary mt-3">Добавить категорию</a>

        <#if users?size == 0>
            <h3>Пользователей нет</h3>
        </#if>
    </div>

    <!-- Add Bootstrap JS and Popper.js scripts -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
