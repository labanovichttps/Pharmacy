<%@ page import="com.labanovich.constants.AppConstant" %><%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 7.11.21
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="static/auth.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Registration</title>
</head>
<body>


<%----%>
<nav class="navbar navbar-dark bg-dark navbar-expand-sm">
    <a class="navbar-brand" href="#">
        <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/logo_white.png" width="30" height="30" alt="logo">
        BootstrapBay
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar-list-4">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg" width="40" height="40" class="rounded-circle">
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Dashboard</a>
                    <a class="dropdown-item" href="#">Edit Profile</a>
                    <a class="dropdown-item" href="#">Log Out</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<div class="sidenav">
    <div class="login-main-text">
        <h2>COURSES FOR YOU<br></h2>
        <p>Register and enjoy.</p>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form action="<c:url value="<%=AppConstant.REGISTRATION_CONTROLLER%>"/>" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" placeholder="Name"
                           name="<%=AppConstant.NAME_LABEL%>">
                </div>
                <%--name--%>

                <div class="form-group">
                    <label>Surname</label>
                    <input type="text" class="form-control" placeholder="Surname"
                           name="<%=AppConstant.SURNAME_LABEL%>">
                </div>
                <%--surname--%>

                <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control" placeholder="example@gmail.com"
                           name="<%=AppConstant.EMAIL_LABEL%>">
                </div>
                <%--email--%>

                <div class="form-group">
                    <label>Login</label>
                    <input type="text" class="form-control" placeholder="login"
                           name="<%=AppConstant.LOGIN_LABEL%>">
                </div>
                <%--login--%>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="Password"
                           name="<%=AppConstant.PASSWORD_LABEL%>">
                </div>
                <%--password--%>

<%--                <div class="form-group">--%>
<%--                    <label>Confirm password</label>--%>
<%--                    <input type="password" class="form-control" placeholder="Password"--%>
<%--                           name="<%=AppConstant.PASSWORD_LABEL%>">--%>
<%--                </div>--%>

                <button type="submit" class="btn btn-black">Register</button>
            </form>
            <%--error message--%>
            <c:if test="${not empty message}">
                <p style="color: red">${message}</p>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
