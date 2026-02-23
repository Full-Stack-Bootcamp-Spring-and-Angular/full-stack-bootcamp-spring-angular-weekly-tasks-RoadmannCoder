<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sidebar shadow" id="side_nav">
    <div class="header-box px-2 pt-3 pb-4 d-flex justify-content-between align-items-center">
        <h1 class="fs-4 m-0">
            <span class="bg-white rounded shadow px-2 py-1 me-2 d-inline-flex align-items-center">
                <img src="/resources/img/logo.png" style="width: 25px; height: 25px;">
            </span>
            <span class="text-logo">AMAZONLY</span>
        </h1>
        <button class="btn d-md-none d-block close-btn px-1 py-0 text-white"><i class="fas fa-stream"></i></button>
    </div>

    <ul class="list-unstyled px-2">
        <li class="<c:if test="${activePage == 'viewProducts'}">active</c:if>">
            <a href="${pageContext.request.contextPath}/products/view" class="text-decoration-none px-3 py-2 d-block">
                <i class="fas fa-box-open me-2"></i> View Products
            </a>
        </li>
        <li class="<c:if test="${activePage == 'addProduct'}">active</c:if> mt-2">
            <a href="${pageContext.request.contextPath}/products/add" class="text-decoration-none px-3 py-2 d-block">
                <i class="fas fa-cart-plus me-2"></i> Add Product
            </a>
        </li>
    </ul>
    <hr class="h-color mx-2">
</div>