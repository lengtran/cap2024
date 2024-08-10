<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<h1>This is the order detail</h1>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Order Details (${orderDetails.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Product Name</th>
                        <th>Quantity Ordered</th>
                        <th>Price Each</th>
                        <th>Line Item Total</th>
                        <th>Add to Cart</th> <!-- New column for Add to Cart -->
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderDetails}" var="detail">
                        <tr>
                            <td>${detail.order.id}</td>
                            <td>${detail.order.orderDate}</td>
                            <td>${detail.product.name}</td>
                            <td>${detail.qty}</td>
                            <td>${detail.product.price}</td>
                            <td>${detail.qty * detail.product.price}</td>
                            <td>

                                <a href="/order/addToCart?productId=${detail.product.id}" class="btn btn-primary">
                                    Add to Cart
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
