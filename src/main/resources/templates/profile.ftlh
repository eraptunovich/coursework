<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>User Profile</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>

    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h2>User Profile</h2>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-4">
                            <!-- Display user avatar -->

                        </div>
                        <div class="col-md-8">
                            <!-- Display user information -->
                            <h4>${user.name}</h4>
                            <p>Email: ${user.email}</p>
                            <p>Login: ${user.login}</p>

                            <p>Registration Date: ${user.dateOfCreated}</p>
                            <!-- You can add more user details as needed -->

                            <!-- Add a button/link to edit profile -->
                            <a href="/edit-profile" class="btn btn-primary">Edit Profile</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and other scripts if needed -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
