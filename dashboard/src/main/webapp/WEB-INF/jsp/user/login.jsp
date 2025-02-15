<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Login</title>
</head>
<body>

<!-- include nav-bar -->
<jsp:include page="/WEB-INF/jsp/util/navbar.jsp"/>


<div class="container">
    <div class="row text-center">
        <div class="col-12"><h3>Login</h3></div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/login/process">
        <div class="form-group ">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" name="email" class="form-control <c:if test="${error != null}">is-invalid</c:if>"
                   id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email">
            <c:if test="${error != null}">
                <div class="invalid-feedback">
                        ${error}
                </div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password"  class="form-control <c:if test="${error != null}">is-invalid</c:if>" id="exampleInputPassword1"
                   placeholder="Password">
            <c:if test="${error != null}">
                <div class="invalid-feedback">
                        ${error}
                </div>
            </c:if>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
