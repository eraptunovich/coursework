<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BUGTRAKER</title>
    <!-- Подключение Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .cards-wrapper {
          display: flex;
          justify-content: center;
        }
        .card img {
          max-width: 100%;
          max-height: 100%;
        }
        .card {
          margin: 0 0.5em;
          box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);
          border: none;
          border-radius: 0;
          width: 600px;
        }
        .carousel-inner {
          padding: 1em;
        }
        .carousel-control-prev,
        .carousel-control-next {
          background-color: #e1e1e1;
          width: 5vh;
          height: 5vh;
          border-radius: 50%;
          top: 50%;
          transform: translateY(-50%);
        }
        @media (min-width: 768px) {
          .card img {
            height: 11em;
          }
        }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <!-- Поиск по названию задачи -->
        <form class="form-inline mb-4" action="/search" method="get" id="searchForm">
                    <div class="input-group mx-auto">
                        <input type="text" class="form-control" id="title" name="title" placeholder="Поиск по названию задачи">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">Поиск</button>
                        </div>
                    </div>
        </form>

        <script>
                    document.getElementById('searchForm').addEventListener('submit', function(event) {
                        // Получить значение из поля ввода title
                        var titleValue = document.getElementById('title').value;

                        // Обновить action с учетом значения title
                        this.action = "/search/" + encodeURIComponent(titleValue);
                    });
        </script>

        <hr>

        <!-- Форма создания задачи -->
        <div class="text-center">
            <h3>Создать задачу</h3>
            <form action="/issue/create" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="issueTitle">Название задачи</label>
                    <input type="text" class="form-control" id="issueTitle" name="title">
                </div>
                <div class="form-group">
                    <label for="description">Описание задачи</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <div class="form-group">
                    <label for="categoryId">Категория</label>
                    <input type="text" class="form-control" id="categoryId" name="categoryId">
                </div>
                <div class="form-group">
                    <label for="productVersion">Версия Продукта</label>
                    <input type="text" class="form-control" id="productVersion" name="productVersion">
                </div>
                <div class="form-group">
                    <label for="priority">Приоритет</label>
                    <input type="text" class="form-control" id="priority" name="priority">
                </div>
                <div class="form-group">
                    <label for="deadlineDate">Дедлайн</label>
                    <input type="date" class="form-control" id="deadlineDate" name="deadlineDate">
                </div>
                <div class="form-group">
                    <label for="assignedDeveloper">Назначить разработчика</label>
                    <input type="number" class="form-control" id="assignedDeveloper" name="assignedDeveloper">
                </div>
                <div class="form-group">
                    <label for="assignedTester">Назначить тестировщика</label>
                    <input type="number" class="form-control" id="assignedTester" name="assignedTester">
                </div>

                <div class="form-group">
                                    <label for="file1">Первая фотография</label>
                                    <input type="file" class="form-control" id="file1" name="file1">
                                </div>

                                <div class="form-group">
                                    <label for="file2">Вторая фотография</label>
                                    <input type="file" class="form-control" id="file2" name="file2">
                                </div>

                                <div class="form-group">
                                    <label for="file3">Третья фотография</label>
                                    <input type="file" class="form-control" id="file3" name="file3">
                                </div>
                <button type="submit" class="btn btn-success btn-block">Создать задачу</button>
            </form>
        </div>

        <!-- Карусель для отображения задач -->
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <#list issues as issue>
                                <div class="carousel-item <#if issue_index == 0> active </#if>">
                                    <div class="cards-wrapper">

                                        <div class="card">

                                            <div class="card-body">
                                                <h5 class="card-title">${issue.title}</h5>
                                                <p class="card-text">${issue.description}</p>
                                                <p>${issue.issueId}</p>
                                                <a th:href="@{/issue/${(issue.issueId}}" class="btn btn-primary">Подробнее</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>


                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                 </div>

    <!-- Подключение Bootstrap JavaScript (необходимо для некоторых компонентов) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

