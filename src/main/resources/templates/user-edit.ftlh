<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BUYSELL</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>BUYSELL</h1>
        <hr>
        <h3>Редактирование пользователя ${user.name}</h3>

        <form action="/admin/user/edit" method="post">
             <div class="form-group">
                <label for="name">Имя пользователя:</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
            </div>
            <div class="form-group">
                <label for="name">Роль в системе:</label>
                <select id="role" name="role" class="form-control">
                    <#list roles as r>
                        <option value="${r}" <#if user.role?seq_contains(r)>selected</#if> >${r}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="name">Логин:</label>
                <input type="text" class="form-control" id="login" name="login" value="${user.login}" required>
            </div>
            <div class="form-group">
                <label for="email">Эл. почта:</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            </div>

            <input type="hidden" value="${user.userId}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </div>

    <!-- Add Bootstrap JS and Popper.js scripts -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
