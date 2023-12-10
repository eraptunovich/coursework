<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BUGTRAKER</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        .card-nav {
            border: 1px solid rgba(0, 0, 0, 0.125);
            border-radius: 0.25rem;
            margin: 0.25rem;
        }

        .card-nav .card-body {
            padding: 0.75rem;
        }

        .card-nav .nav-link {
            padding: 0.5rem 1rem;
            border-bottom: 1px solid rgba(0, 0, 0, 0.125);
        }

        .card-nav .nav-link:last-child {
            border-bottom: none;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">BUGTRAKER</a>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <div class="card card-nav">
                    <div class="card-body">
                        <a class="nav-link" href="/create-task">Создать задачу</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <div class="card card-nav">
                    <div class="card-body">
                        <a class="nav-link" href="/profile">Профиль</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <div class="card card-nav">
                    <div class="card-body">
                        <a class="nav-link" href="/logout">Выйти из профиля</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>

<!-- Остальной контент вашей страницы будет идти здесь -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-aZR5MPzzA1CjoJ90J3TU5fbhM4+oyg4j60uLeE2D1moGwRCD8WiE2L6F2I3IyZl"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>


