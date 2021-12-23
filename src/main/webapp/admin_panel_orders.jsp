<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <link rel='stylesheet' type='text/css' href='static/css/admin_panel.css'>
    <title>Admin</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>

<c:import url="/all_orders"/>
<c:set var="adminOrders" value="${sessionScope.adminOrders}"/>
<body>

<header>
    <div class="header">

        <div>Admin panel</div>
        <div class="right-part">
            <div class="dropdown">
                <button class="dropbtn">Admin</button>
                <div class="dropdown-content">
                    <a href="<c:url value="/admin_panelAllDrugs.jsp"/>">Все лекарства</a>
                    <a href="<c:url value="/admin_panel_orders.jsp"/>">Все заказы</a>
                    <a href="<c:url value="/logout"/>">Выйти</a>
                </div>
            </div>
        </div>

    </div>
</header>
<div class="main">
    <table class="table">
        <tr>
            <th>Номер заказа</th>
            <th>ФИО</th>
            <th>Email</th>
            <th>Итоговая сумма</th>
            <th>Время заказа</th>
            <th>Заказ</th>
        </tr>
        <c:forEach var="order" items="${adminOrders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.initials}</td>
                <td>${order.email}</td>
                <td>${order.total}</td>
                <td>${order.orderDate}</td>
                <td>
                    <form action="<c:url value="/admin_user_orders"/>" method="post">
                        <input type="hidden" name="ordDate" value="${order.orderDate}">
                        <input type="hidden" name="user_admin_order" value="${order.user_id}">
                        <button type="submit">Подробнее</button>
                    </form>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

</body>
</html>