<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

                    <form action="${pageContext.request.contextPath}/products/save" method="POST" enctype="multipart/form-data">

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label text-muted fw-bold">Product Name</label>
                                <input type="text" name="productName" class="form-control bg-light" placeholder="e.g. Wireless Mouse" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label text-muted fw-bold">Manufacturer</label>
                                <input type="text" name="manufacturer" class="form-control bg-light" placeholder="e.g. Logitech" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Price ($)</label>
                                <input type="number" step="0.01" name="price" class="form-control bg-light" placeholder="0.00" required>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Initial Stock</label>
                                <input type="number" name="stock" class="form-control bg-light" placeholder="0" required>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label text-muted fw-bold">Expiry Date</label>
                                <input type="date" name="expiryDate" class="form-control bg-light">
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label text-muted fw-bold">Product Image</label>
                            <input class="form-control bg-light" type="file" name="productImage" accept="image/png, image/jpeg">
                            <div class="form-text">Please upload a valid PNG or JPEG image file.</div>
                        </div>

                        <div class="d-flex justify-content-end mt-4 pt-3 border-top">
                            <button type="reset" class="btn btn-outline-secondary me-2 px-4">Clear</button>
                            <button type="submit" class="btn btn-success px-5" style="background-color: #55A663; border: none;">Save Product</button>
                        </div>

                    </form>
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