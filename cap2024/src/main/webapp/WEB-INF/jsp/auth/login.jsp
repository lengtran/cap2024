<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp" />


<style>
    .gradient-custom {
        background: #000000;
    }

    .card-custom {
        background: linear-gradient(45deg, #6a11cb, #2575fc);
    }
</style>

<!-- Section with black background -->
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card card-custom text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Log in</h2>
                            <p class="text-white-50 mb-5">Please enter your login and password!</p>

                            <c:if test="${param['error'] ne null}">
                                <div class="alert alert-danger" role="alert">
                                    Invalid Username or Password
                                </div>
                            </c:if>

                            <form action="/account/loginProcessingURL" method="post">
                                <!-- Email input -->
                                <div data-mdb-input-init class="form-outline form-white mb-4">
                                    <input type="text" id="usernameId" name="username"
                                           class="form-control form-control-lg <c:if test='${bindingResult.hasFieldErrors("email")}'>is-invalid</c:if>"
                                           value="${form.email}" />
                                    <label class="form-label" for="usernameId">Email</label>
                                    <c:if test="${bindingResult.hasFieldErrors('email')}">  <%-- this is required for capestone, if statement and a for loop each item --%>
                                        <div class="text-danger">
                                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                                ${error.defaultMessage}<br>
                                            </c:forEach>
                                        </div>
                                    </c:if>
                                </div>

                                <!-- Password input -->
                                <div data-mdb-input-init class="form-outline form-white mb-4">
                                    <input type="password" id="passwordId" name="password"
                                           class="form-control form-control-lg <c:if test='${bindingResult.hasFieldErrors("password")}'>is-invalid</c:if>"
                                           value="${form.password}" />
                                    <label class="form-label" for="passwordId">Password</label>
                                    <c:if test="${bindingResult.hasFieldErrors('password')}">
                                        <div class="text-danger">
                                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                                ${error.defaultMessage}<br>
                                            </c:forEach>
                                        </div>
                                    </c:if>
                                </div>

                                <!-- Checkbox -->
                                <div class="form-check d-flex justify-content-center mb-4">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="registerCheck" checked
                                           aria-describedby="registerCheckHelpText" />
                                    <label class="form-check-label" for="registerCheck">
                                        Remember Me
                                    </label>
                                </div>

                                <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-light btn-lg px-5"
                                        type="submit" value="Login" onclick="lsRememberMe()">Login</button>
                            </form>

                            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                            </div>
                        </div>

                        <div>
                            <p class="mb-0">Don't have an account? <a href="/account/create-account" class="text-white-50 fw-bold">Sign Up</a></p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
