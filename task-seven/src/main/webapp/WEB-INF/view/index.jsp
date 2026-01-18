<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-light d-flex align-items-center justify-content-center vh-100">
<div class="container" style="max-width: 500px;">
    <h2 class="text-center mb-4 fw-normal">Employee Registeration Form</h2>

    <div class="card p-4 border shadow-sm">
        <form:form action="result" modelAttribute="user" >
            <div class="mb-3">
                <form:input type="text" class="form-control" path="username" placeholder="your username"/>
                <form:errors path="username" cssClass="alert-danger"/>
            </div>
            <div class="mb-3">
                <form:input type="text" class="form-control" path="email" placeholder="your email address"/>
                <form:errors path="email" cssClass="alert-danger"/>

            </div>
            <div class="mb-3">
                <form:input type="password" class="form-control" path="password" placeholder="your password"/>
                <form:errors path="password" cssClass="alert-danger"/>

            </div>
            <div class="mb-3">
                <form:input type="password" class="form-control" path="confirmPassword" placeholder="re enter your password"/>
                <form:errors path="confirmPassword" cssClass="alert-danger"/>

            </div>


            <button type="submit" class="btn btn-danger w-100 py-2">Submit</button>
        </form:form>
    </div>
</div>
</body>
</html>
