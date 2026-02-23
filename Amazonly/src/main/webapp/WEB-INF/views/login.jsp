<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Amazonly - Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="col-md-6 col-lg-4">

        <div class="login-wrap p-4 p-md-5 shadow-sm bg-white rounded">

            <div class="d-flex align-items-center justify-content-center mb-4">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png" style="width: 180px; height: auto;">
            </div>

            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger text-center py-2 mb-3">${errorMessage}</div>
            </c:if>

            <form action="${pageContext.request.contextPath}/login" method="post" class="login-form">
                <div class="form-group mb-3">
                    <input name="username" type="text" class="form-control" placeholder="Username" required>
                </div>
                <div class="form-group mb-4">
                    <input name="password" type="password" class="form-control" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary w-100 py-2 rounded" style="background-color: #1089ff; border: none;">Login</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>