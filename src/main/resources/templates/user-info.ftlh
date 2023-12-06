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
        .avatar {
            max-width: 100px; /* Регулируйте размер аватара по вашему усмотрению */
        }
        .card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>BUGTRAKER</h1>
    <hr>
    <div class="card">
        <div class="card-body">
            <div class="d-flex align-items-center">

                <h3 class="ml-3">${user.name}</h3>
            </div>
        </div>
    </div>

    <h4>Созданные задачи ${user.name}</h4>
    <div class="row">
        <#list issues as issue>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${issue.title}</h5>
                        <p class="card-text">${issue.description}</p>
                        <#if issue.previewImageId??>
                            <p><img src="/images/${issue.previewImageId?c}" height="60px"></p>
                        </#if>
                        <a href="/issue/${issue.issueId?c}" class="btn btn-primary">Подробнее</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-eMNFi9LsIT9ZNY3raL3Jy9Hj8cxUL5jSftj9FYAV9qOXib/l1rNYoHfF0ZY41Miv" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JJ6yXebFmN+Y2EZ3AXMZBRTU8HE6zB4X2uKMPWMSF7dsi/pfDePaBGJ8E9YyuZ5Y" crossorigin="anonymous"></script>
</body>
</html>

