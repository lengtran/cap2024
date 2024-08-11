<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Capstone Project</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Core theme CSS -->
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Hank's Hardware</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/products">Product</a>
                    </li>


                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/account/create-account">Sign Up</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/account/loginPageUrl">Log In</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/login/logout">Log Out</a>
                    </li>
                </sec:authorize>



                <sec:authorize access="isAuthenticated()">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="admin/products" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Admin
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <li><a class="dropdown-item" href="/admin/create">Create</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/admin/products">Delete</a></li>
                    </ul>
                </li>
                </sec:authorize>
            </ul>
            <!-- Optional search form -->
            <%-- <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form> --%>
        </div>
    </div>
</nav>
