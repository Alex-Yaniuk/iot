<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Registration</title>
</head>
<body>

<!-- include nav-bar -->
<jsp:include page="/WEB-INF/jsp/util/navbar.jsp"/>

<div class="container">
    <div class="row text-center">
        <div class="col-12"><h3>Registration</h3></div>
    </div>
    <form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/registration">
    <spring:bind path="email">
    <div class="form-group ">
        <label for="email">Email address</label>
        <form:input path="email" type="email" id="email" placeholder="Enter email"
                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
        <form:errors path="email" cssClass="invalid-feedback"/>
    </div>
    </spring:bind>

    <spring:bind path="firstName">
    <div class="form-group ">
        <label for="firstName">First name</label>
        <form:input path="firstName" type="text" id="firstName" placeholder="Enter first name"
                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
        <form:errors path="firstName" cssClass="invalid-feedback"/>
    </div>
    </spring:bind>

    <spring:bind path="lastName">
    <div class="form-group ">
        <label for="lastName">Last name</label>
        <form:input path="lastName" type="text" id="lastName" placeholder="Enter last name"
                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
        <form:errors path="lastName" cssClass="invalid-feedback"/>
    </div>
    </spring:bind>

    <spring:bind path="password">
    <div class="form-group ">
        <label for="password">Password</label>
        <form:input path="password" type="password" id="password" placeholder="Enter password"
                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
        <form:errors path="password" cssClass="invalid-feedback"/>
    </div>
    </spring:bind>

    <spring:bind path="confirmedPassword">
    <div class="form-group ">
        <label for="confirmedPassword">Confirm password</label>
        <form:input path="confirmedPassword" type="password" id="confirmedPassword" placeholder="Confirm password"
                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
        <form:errors path="confirmedPassword" cssClass="invalid-feedback"/>
    </div>
    </spring:bind>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
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
