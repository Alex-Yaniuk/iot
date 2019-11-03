<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Sensor data</title>
</head>
<body>

<c:forEach var="num" items="${data}">
    <p>${num}</p>
</c:forEach>

</body>
</html>
