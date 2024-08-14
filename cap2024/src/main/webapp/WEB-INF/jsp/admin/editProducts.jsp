<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp" />

<h2>Edit Product</h2>

<form action="/admin/editProductSubmit" method="post">
    <input type="hidden" name="id" value="${product.id}"> <%-- not using form bean --%>

    <div class="form-group">
        <label for="name">Product Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${product.name}" required>
    </div>

    <div class="form-group">
        <label for="price">Price</label>
        <input type="number" class="form-control" id="price" name="price" value="${product.price}" required>
    </div>

    <div class="form-group">
        <label for="image">Image URL</label>
        <input type="text" class="form-control" id="image" name="image" value="${product.image}">
    </div>

    <div class="form-group">
        <label for="description">Description</label>
        <textarea class="form-control" id="description" name="description" required>${product.description}</textarea>
    </div>

    <button type="submit" class="btn btn-primary">Save Changes</button>

</form>

<hr/>

<%-- Delete Product --%>
<form action="/admin/deleteProduct" method="post" style="display:inline;">
    <input type="hidden" name="productId" value="${product.id}">
    <button type="submit" class="btn btn-danger">Delete</button>
</form>



<jsp:include page="../include/footer.jsp" />
