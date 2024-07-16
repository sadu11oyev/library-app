<%--
  Created by IntelliJ IDEA.
  User: Бахтиёр Садуллоев
  Date: 23.04.2024
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Register new User</h3>
                </div>
                <div class="card-body">
                    <form action="/user/add" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Save user</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
