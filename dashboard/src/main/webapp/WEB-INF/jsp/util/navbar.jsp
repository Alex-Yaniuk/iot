<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/device-catalog">Device list</a>
            </li>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/registration">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/device-catalog/register-new-device">Register new device</a>
                </li>
            </sec:authorize>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search">
            <input class="form-control mr-sm-2" name="search-str" type="search" placeholder="Device search by location"
                   aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>