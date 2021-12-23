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
    <link href="<c:url value="/static/css/header.css"/>" rel="stylesheet">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <title>Header</title>
</head>
<!-- Navbar -->

<header>
    <div class="header">

        <div class="logo"><a id="a" href="<c:url value="/index.jsp"/>">PharmacyLL</a></div>
        <c:choose>

            <c:when test="${empty user}">
                <div class="entry">
                    <div class="button1"><a class="button-text" href="<c:url value="/Authentication.jsp"/>">ВОЙТИ</a>
                    </div>

                    <div class="button2"><a class="button-text"
                                            href="<c:url value="/Registration.jsp"/>">РЕГИСТРАЦИЯ</a></div>
                </div>
            </c:when>
            <c:when test="${not empty user}">

                <div class="right-part">
                    <div class="busket">
                        <form action="<c:url value="/basket"/>" method="post">
                            <button type="submit">КОРЗИНА</button>
                        </form>
                    </div>
                    <div class="dropdown">
                        <button class="dropbtn">${user.login}</button>
                        <div class="dropdown-content">
                            <a href="<c:url value="/Profile.jsp"/>">Профиль</a>
                            <a href="<c:url value="/my_orders.jsp"/>">Мои заказы</a>
                            <a href="<c:url value="/logout"/>">Выйти</a>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>

    </div>
</header>


