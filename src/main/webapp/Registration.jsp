<%@ page import="com.labanovich.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/Registration.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>Регистрация</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>

    <header>
        <div class="header">

            <div class="logo"><a id="a" href="<c:url value="/index.jsp"/>">PharmacyLL</a></div>

        </div>
    </header>

    <div class="main">
        <div class="register-form-container">

            <h1 class="form-title">
                Регистрация
            </h1>

            <form class="form-fields" action="<c:url value="<%=AppConstant.REGISTRATION_CONTROLLER%>"/>" method="post">
                <div class="form-field">
                    <input type="text" required maxlength="30" placeholder="Имя" name="<%=AppConstant.NAME_LABEL%>">
                </div>

                <div class="form-field">
                    <input type="text" required maxlength="30" placeholder="Фамилия" name="<%=AppConstant.SURNAME_LABEL%>">
                </div>

                <div class="form-field">
                    <input type="email" required maxlength="30" placeholder="Эл. почта" name="<%=AppConstant.EMAIL_LABEL%>">
                </div>

                <div class="form-field">
                    <input type="text" maxlength="30" required placeholder="Логин" name="<%=AppConstant.LOGIN_LABEL%>">
                </div>

                <div class="form-field">
                    <input type="password" required maxlength="30" placeholder="Пароль" name="<%=AppConstant.PASSWORD_LABEL%>">
                </div>
                <button type="submit" class="button">Регистрация</button>
            </form>


            <div class="form-text">
                <div>Уже есть аккаунт?</div>
                <div><a href="<c:url value="/Authentication.jsp"/>">Войти!</a></div>
            </div>

        </div>
    </div>

    <%--error message--%>
    <c:if test="${not empty message}">
        <p style="color: red">${message}</p>
    </c:if>

</body>
</html>