<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<h1>Order detail jsp</h1>

<section class="h-100 gradient-custom">
    <div class="container py-5">
        <div class="row d-flex justify-content-center my-4">
            <div class="col-md-8">
                <div class="card mb-4">
                    <div class="card-header py-3">
                        <h5 class="mb-0">Cart - ${orderDetails.size()} items</h5>
                    </div>
                    <div class="card-body">
                        <!-- Iterate through the order details to display each item -->
                        <c:forEach items="${orderDetails}" var="detail">
                            <div class="row mb-4">
                                <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                                    <!-- Image -->
                                    <div class="bg-image hover-overlay hover-zoom ripple rounded" data-mdb-ripple-color="light">
                                        <img src="${detail.product_image_url}" class="w-100" alt="${detail.product_name}" />
                                        <a href="#!">
                                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
                                        </a>
                                    </div>
                                </div>

                                <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                                    <!-- Data -->
                                    <p><strong>${detail.product_name}</strong></p>

                                    <!-- Warranty Options -->
                                    <p><strong>Warranty Options:</strong></p>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="warrantyOption${detail.product_id}" id="warranty1_${detail.product_id}" value="1-year" />
                                        <label class="form-check-label" for="warranty1_${detail.product_id}">
                                            1 Year Warranty
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="warrantyOption${detail.product_id}" id="warranty2_${detail.product_id}" value="2-years" />
                                        <label class="form-check-label" for="warranty2_${detail.product_id}">
                                            2 Years Warranty
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="warrantyOption${detail.product_id}" id="warranty3_${detail.product_id}" value="no-warranty" />
                                        <label class="form-check-label" for="warranty3_${detail.product_id}">
                                            No Warranty
                                        </label>
                                    </div>
                                    <!-- End Warranty Options -->

                                    <!-- Price and Quantity Section -->
                                    <div class="d-flex align-items-center justify-content-between">
                                        <!-- Price -->
                                        <p class="text-start text-md-center mb-0 me-3">
                                            <strong>$${detail.product_price}</strong>
                                        </p>

                                        <!-- Quantity -->
                                        <div class="d-flex align-items-center">
                                            <div data-mdb-input-init class="form-outline">
                                                <input id="form${detail.product_id}" min="0" name="quantity" value="${detail.quantity_ordered}" type="number" class="form-control" style="width: 80px;" />
                                                <label class="form-label" for="form${detail.product_id}">Quantity</label>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Price and Quantity Section -->

                                    <!-- Remove Product Button -->
                                    <form action="/order/remove" method="post" style="display:inline;">
                                        <input type="hidden" name="productId" value="${detail.product_id}">
                                        <button type="submit" class="btn btn-danger btn-sm mt-2" data-mdb-tooltip-init title="Remove Product">
                                            Remove Product
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <hr class="my-4" />
                        </c:forEach>
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-body">
                        <p><strong>Will Call or Curbside Pickup</strong></p>
                        <p class="mb-0">Something</p>
                    </div>
                </div>

                <div class="card mb-4 mb-lg-0">
                    <div class="card-body">
                        <p><strong>We accept</strong></p>
                        <img class="me-2" width="45px" src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg" alt="Visa" />
                        <img class="me-2" width="45px" src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg" alt="American Express" />
                        <img class="me-2" width="45px" src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg" alt="Mastercard" />
                        <img class="me-2" width="45px" src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.webp" alt="PayPal acceptance mark" />
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header py-3">
                        <h5 class="mb-0">Summary</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                Products
                                <span>$${total_products_price}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                Shipping
                                <span>${shipping_cost}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                <div>
                                    <strong>Total amount</strong>
                                    <strong>
                                        <p class="mb-0">(including sales tax)</p>
                                    </strong>
                                </div>
                                <span><strong>$${total_amount}</strong></span>
                            </li>
                        </ul>

                        <form action="/checkout" method="get">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">
                                Go to checkout
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
