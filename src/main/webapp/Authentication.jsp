<%@ page import="com.labanovich.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/Authentication.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>Вход</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>

<header>
    <div class="header">

        <div class="logo"><a id="a" href="index.jsp">PharmacyLL</a></div>

    </div>
</header>

<div class="main">
    <div class="register-form-container">

        <h1 class="form-title">
            Вход
        </h1>

        <form action="<c:url value="<%=AppConstant.AUTHORIZATION_CONTROLLER%>"/>" class="form-fields" method="post">

            <div class="form-field">
                <input type="text" maxlength="30" placeholder="Логин или Эл. почта" name="<%=AppConstant.LOGIN_LABEL%>">
            </div>

            <div class="form-field">
                <input type="password" maxlength="30" placeholder="Пароль" name="<%=AppConstant.PASSWORD_LABEL%>">
            </div>
            <c:if test="${not empty message}">
                <p style="color: red">${message}</p>
            </c:if>

            <button type="submit" class="button">Вход</button>

            <div class="form-text">
                <div>У вас ещё нет аккаунта?</div>
                <div><a href="<c:url value="/Registration.jsp"/>">Зарегистрироваться!</a></div>
            </div>

        </form>

    </div>
</div>

</body>
</html>
