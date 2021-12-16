<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/adminMore.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>Корзина</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>

<header>
    <div class="header">

        <div class="logo"><a id="a" color="#fff" href="admin_panel_orders.jsp">Назад</a></div>

        <div class="dropdown">
            <button class="dropbtn">Admin</button>
            <div class="dropdown-content">
                <a href="#">Все лекарства</a>
                <a href="<c:url value="/admin_panel_orders.jsp"/>">Все заказы</a>
                <a href="<c:url value="/logout"/>">Выйти</a>
            </div>

        </div>
    </div>
</header>

<div class="main">

    <c:forEach items="${userAdminOrders}" var="cure">
        <div class="drug-form-container">

            <h1 class="form-title">
                ${cure.name}
            </h1>

            <div class="circle"></div>

            <div class="classification">
                ${cure.type}
            </div>

            <div class="form-text">
                ${cure.dose}
            </div>

            <div class="info">

                <div class="form-text">ГЕРМАНИЯ</div>

                <div class="form-text">${cure.deliveryTime}</div>

            </div>

        </div>
    </c:forEach>


</div>
</body>
</html>