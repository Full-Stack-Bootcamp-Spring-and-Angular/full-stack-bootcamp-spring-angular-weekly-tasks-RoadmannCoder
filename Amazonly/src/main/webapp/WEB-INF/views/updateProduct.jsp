<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Amazonly - Add Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="main-container d-flex">

    <jsp:include page="sidebar.jsp" />

    <div class="content">
        <nav class="navbar navbar-expand-md navbar-light bg-white shadow-sm d-md-none">
            <div class="container-fluid">
                <button class="btn px-1 py-0 open-btn me-2"><i class="fas fa-stream"></i></button>
                <a class="navbar-brand fw-bold text-success" href="#" style="color: #55A663 !important;">AMAZONLY</a>
            </div>
        </nav>

        <div class="dashboard-content px-4 pt-4">
            <h2 class="fs-4 mb-4 pb-2 border-bottom">Add New Product</h2>

            <div class="card shadow-sm border-0" style="max-width: 800px;">
                <div class="card-body p-4">

                    <form:form action="${pageContext.request.contextPath}/products/update?id=${id}" method="POST" modelAttribute="productDomain">

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label text-muted fw-bold">Product Name</label>
                                <form:input type="text" path="productName" class="form-control bg-light" value="${product.productName}"/>
                                <form:errors path="productName" cssClass="text-danger small mt-1 d-block" />

                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label text-muted fw-bold">Manufacturer</label>
                                <form:input type="text" path="manufacturer" class="form-control bg-light" value="${product.manufacturer}"/>
                                <form:errors path="manufacturer" cssClass="text-danger small mt-1 d-block" />

                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Price ($)</label>
                                <form:input type="number" step="0.01" path="price" class="form-control bg-light" value="${product.price}"/>
                                <form:errors path="price" cssClass="text-danger small mt-1 d-block" />

                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Initial Stock</label>
                                <form:input type="number" path="stock" class="form-control bg-light" value="${product.stock}"/>
                                <form:errors path="stock" cssClass="text-danger small mt-1 d-block" />

                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Expiry Date</label>
                                <form:input type="date" path="expiryDate"  class="form-control bg-light" value="${product.expiryDate}"/>
                                <form:errors path="expiryDate" cssClass="text-danger small mt-1 d-block" />

                            </div>
                        </div>



                        <div class="d-flex justify-content-end mt-4 pt-3 border-top">
                            <button type="submit" class="btn btn-success px-5" style="background-color: #55A663; border: none;">Update Product</button>
                        </div>

                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
</body>
</html>