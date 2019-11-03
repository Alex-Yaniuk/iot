<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new Device</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/device-catalog/register-new-device" method="post">
    <input type="text" name="location" placeholder="location"/>
    <input type="text" name="ipAddress" placeholder="idAddress"/>
    <input type="submit">
</form>


</body>
</html>
