<%--
  Created by IntelliJ IDEA.
  User: Бахтиёр Садуллоев
  Date: 24.04.2024
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lust login</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Lust login</h3>
                </div>
                <div class="card-body">
                    <form action="/auth/login/lust" method="post">
                        <div class="form-group">
                            <label for="password">Enter sending password:</label>
                            <input name="password" type="password" class="form-control" id="password" placeholder="Enter your password" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
