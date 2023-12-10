<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать категорию</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Create Category</h2>
    <form action="/category/create" method="post" class="mt-4">
        <div class="form-group">
            <label for="categoryName">Название категории</label>
            <input type="text" class="form-control" id="categoryName" name="categoryName" required>
        </div>
         <input type="hidden" name="_csrf" value=${_csrf.token}>
        <button type="submit" class="btn btn-primary">Добавить категорию</button>
    </form>
</div>

<!-- Include Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
