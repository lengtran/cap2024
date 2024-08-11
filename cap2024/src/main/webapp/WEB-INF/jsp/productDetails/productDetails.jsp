
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Product Details</h1>
<div class="product-details">
    <h2>${product.name}</h2>
    <p><strong>Price:</strong> ${product.price}</p>
    <p><strong>Description:</strong> ${product.description}</p>
    <c:if test="${not empty product.image}">
        <img src="${product.image}" alt="${product.name}">
    </c:if>
    <a class="btn btn-primary" href="/order/addToCart?productId=${product.id}">Add To Cart</a>
</div>

</body>
</html>
<jsp:include page="../include/footer.jsp"/>