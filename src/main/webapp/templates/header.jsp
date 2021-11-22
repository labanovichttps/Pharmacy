<%@ page import="com.labanovich.constants.AppConstant" %><%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 17.11.21
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <title>Header</title>
</head>
<!-- Navbar -->
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="<%=AppConstant.INDEX_JSP%>"/>">TrainingLL</a>
        <form class="d-flex">
            <c:choose>
                <c:when test="${empty user}">
                    <button type="button" class="btn btn-link"
                            onclick="window.location.href='<c:url value="<%=AppConstant.LOGIN_JSP%>"/>'">Sing in
                    </button>
                    <button class="btn btn-outline-success" type="submit"
                            onclick="window.location.href='<c:url value="<%=AppConstant.REGISTRATION_JSP%>"/>'">Sign up
                    </button>
                </c:when>
                <c:otherwise>
                    <button type="button" class="btn btn-danger"
                            onclick="window.location.href='<c:url value="<%=AppConstant.LOGOUT_CONTROLLER%>"/>'">
                        logout
                    </button>
                </c:otherwise>
            </c:choose>
        </form>
    </div>
</nav>


