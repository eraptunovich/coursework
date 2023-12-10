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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">BUGTRAKER</a>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <span class="navbar-text">
                    Добро пожаловать, ${user.name} |
                </span>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/issues">  Задачи |</a>
            </li>
            <#if user.isAdmin()>
            <li class="nav-item">
                <a class="nav-link" href="/admin">Панель администратора |</a>
            </li>
            <#else>
            <li class="nav-item">
                <a class="nav-link" href="/profile">  Профиль |</a>
            </li>
            </#if>

            <li class="nav-item">
                <a class="nav-link" href="/logout">Выйти из профиля</a>
            </li>

            <!-- Search Form -->
            <li class="nav-item">
                <form class="form-inline mb-4" action="/search" method="get" id="searchForm">
                    <div class="input-group mx-auto">
                        <input type="text" class="form-control" id="title" name="title" placeholder="Название...">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">Поиск</button>
                        </div>
                    </div>
                </form>

                <script>
                    document.getElementById('searchForm').addEventListener('submit', function (event) {
                        // Получить значение из поля ввода title
                        var titleValue = document.getElementById('title').value;

                        // Обновить action с учетом значения title
                        this.action = "/search/" + encodeURIComponent(titleValue);
                    });
                </script>
            </li>
        </ul>
    </div>
</nav>
    <div class="container mt-5">
        <#if user.login??>
        <!-- Форма создания задачи -->
        <div class="text-center">
            <h3>Создать задачу</h3>
            <hr>
            <form action="/issue/create" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="issueTitle">Название задачи</label>
                    <input type="text" class="form-control" id="issueTitle" name="title">
                </div>
                <div class="form-group">
                    <label for="description">Описание задачи</label>
                    <input type="textarea" class="form-control" id="description" name="description">
                </div>
                <div class="form-group">
                    <label for="categoryId">Категория</label>
                    <select class="form-control" id="categoryId" name="categoryId">
                        <#list categories as category>
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </#list>
                    </select>
                </div>

                <div class="form-group">
                    <label for="productVersion">Версия Продукта</label>
                    <input type="text" class="form-control" id="productVersion" name="productVersion">
                </div>
                <div class="row">
                    <div class="col-md-6">
                            <div class="form-group">
                                <label for="assignedDeveloper">Назначить разработчика</label>
                                <select class="form-control" id="assignedDeveloper" name="assignedDeveloper" required>

                                    <#list users as user>
                                        <#list user.role as role>
                                        <#if role == "PROGRAMMER">
                                            <option value="${user.userId}">${user.login}</option>
                                        </#if>
                                        </#list>
                                    </#list>
                                </select>
                            </div>
                        </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="assignedTester">Назначить тестировщика</label>
                            <select class="form-control" id="assignedTester" name="assignedTester" required>
                                <#list users as user>
                                    <#list user.role as role>
                                    <#if role == "TESTER">
                                        <option value="${user.userId}">${user.name}</option>
                                    </#if>
                                    </#list>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="file1">Первая фотография</label>
                            <input type="file" class="form-control" id="file1" name="file1">
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="file2">Вторая фотография</label>
                            <input type="file" class="form-control" id="file2" name="file2">
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="file3">Третья фотография</label>
                            <input type="file" class="form-control" id="file3" name="file3">
                        </div>
                    </div>
                </div>

                <input type="hidden" name="_csrf" value=${_csrf.token}>
                <button type="submit" class="btn btn-success btn-block">Создать задачу</button>
            </form>
            <hr>
        </div>
        </#if>
        <#if issues?size != 0>
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

                                                <#if issue.previewImageId??><p><img src="/images/${issue.previewImageId?c}" height="60px"></p></#if>
                                                <a href="/issue/${issue.issueId?c}" class="btn btn-primary">Подробнее</a>
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
        </#if>
    <!-- Подключение Bootstrap JavaScript (необходимо для некоторых компонентов) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

