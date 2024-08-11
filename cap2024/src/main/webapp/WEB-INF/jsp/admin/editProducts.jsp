<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp" />

<h2>Edit Product</h2>

<c:forEach items="${products}" var="product">
    <div class="product">
        <h3>${product.name}</h3>
        <p>${product.description}</p>
        <p>Price: $${product.price}</p>
        <div>

<%--            <form action="editProduct" method="get" style="display:inline;">--%>
<%--                <input type="hidden" name="productId" value="${product.id}">--%>
<%--                <button type="submit" class="btn btn-primary">Edit</button>--%>
<%--            </form>--%>

    <%-- this is the delete --%>
            <form action="deleteProduct" method="post" style="display:inline;">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </div>
    <hr>
</c:forEach>

<jsp:include page="../include/footer.jsp" />
