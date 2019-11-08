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
        <div class="col-12"><h3>Register new device</h3></div>
    </div>
    <form:form method="post" modelAttribute="device" action="${pageContext.request.contextPath}/device-catalog/register-new-device">

        <spring:bind path="location">
            <div class="form-group ">
                <label for="location">location</label>
                <form:input path="location" type="text" id="location" placeholder="Enter location"
                            cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
                <form:errors path="location" cssClass="invalid-feedback"/>
            </div>
        </spring:bind>

        <spring:bind path="ipAddress">
            <div class="form-group ">
                <label for="ipAddress">Ip address</label>
                <form:input path="ipAddress" type="text" id="ipAddress" placeholder="Enter ip address"
                            cssClass="form-control ${status.error ? 'is-invalid' : ''}"/>
                <form:errors path="ipAddress" cssClass="invalid-feedback"/>
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

