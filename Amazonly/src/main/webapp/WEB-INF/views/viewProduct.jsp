<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Amazonly - View Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-light">
<div class="main-container d-flex">

    <jsp:include page="sidebar.jsp" />

    <div class="content">
        <nav class="navbar navbar-expand-md navbar-light bg-white shadow-sm d-md-none">
            <div class="container-fluid">
                <button class="btn px-1 py-0 open-btn me-2"><i class="fas fa-stream"></i></button>
                <a class="navbar-brand fw-bold" href="#" style="color: #55A663 !important;">AMAZONLY</a>
            </div>
        </nav>

        <div class="dashboard-content px-4 pt-4">
            <h2 class="fs-4 mb-4 pb-2 border-bottom">Product Overview</h2>

            <div class="row">

                <%-- Loop through the list of products passed from the Controller --%>
                <c:forEach items="${productsList}" var="product">
                    <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                        <div class="card h-100 shadow-sm border-0">

                            <div class="text-center p-3 bg-white" style="border-bottom: 1px solid #f4f6f9;">
                                <img src="${pageContext.request.contextPath}/resources/img/placeholder.png"
                                     class="card-img-top"
                                     alt="Product Image"
                                     style="height: 180px; object-fit: contain;">
                            </div>

                            <div class="card-body">
                                <h5 class="card-title text-dark fw-bold mb-1">${product.productName}</h5>
                                <h6 class="card-subtitle text-muted mb-3"><small>${product.manufacturer}</small></h6>

                                <div class="d-flex justify-content-between align-items-center">
                                    <p class="card-text fs-5 fw-bold mb-0" style="color: #55A663;">$${product.price}</p>

                                    <span class="badge ${product.stock < 5 ? 'bg-danger' : ''}"
                                          style="${product.stock >= 5 ? 'background-color: #3186a1;' : ''}">
                                            In Stock: ${product.stock}
                                    </span>

                                </div>
                            </div>

                            <div class="card-footer bg-white border-0 pb-3 pt-0">
                                <div class="d-flex justify-content-between">
                                    <a href="${pageContext.request.contextPath}/products/edit?id=${product.id}" class="btn btn-outline-primary btn-sm w-100 me-2">
                                        <i class="fas fa-edit me-1"></i> Edit
                                    </a>
                                    <a href="${pageContext.request.contextPath}/products/delete?id=${product.id}" class="btn btn-outline-danger btn-sm w-100" onclick="return confirm('Are you sure you want to delete this product?');">
                                        <i class="fas fa-trash-alt me-1"></i> Delete
                                    </a>
                                </div>
                            </div>

                        </div>
                    </div>
                </c:forEach>

                <%-- Show a message if the database is empty --%>
                <c:if test="${empty productsList}">
                    <div class="col-12 text-center mt-5">
                        <h4 class="text-muted">No products found in inventory.</h4>
                        <a href="${pageContext.request.contextPath}/products/add" class="btn btn-success mt-3" style="background-color: #55A663; border: none;">Add Your First Product</a>
                    </div>
                </c:if>

            </div>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
</body>
</html>