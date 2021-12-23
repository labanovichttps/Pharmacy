<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/orderds.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>Admin</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>
<jsp:include page="templates/header.jsp"/>

<c:import url="/my_orders"/>
<c:set var="ord" value="${requestScope.userOrders}"/>
<c:if test="${not empty user}">
    <div class="main">
        <table id="info-table">
            <tr>
                <th onclick="sortTable(0)">Номер заказа</th>
                <th onclick="sortTable(1)">ФИО</th>
                <!-- Здесь выводить все купленные наркотики? -->
                <th onclick="sortTable(2)">Итоговая сумма</th>
                <th onclick="sortTable(3)">Время заказа</th>
            </tr>
            <c:forEach var="order" items="${ord}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.initials}</td>
                    <td>${order.total}</td>
                    <td>${order.orderDate}</td>
                    <td>
                        <form action="<c:url value="/print_receipt"/>" method="post">
                            <input type="hidden" name="ordDate" value="${order.orderDate}">
                            <input type="hidden" name="order_print" value="${order.id}">
                            <input type="hidden" name="user_admin_order" value="${order.user_id}">
                            <button type="submit" class="check">Печатать чек</button>
                        </form>
                    </td>
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
</c:if>


</body>
</html>

<script>
    function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("info-table");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
    // Start by saying there should be no switching:
    shouldSwitch = false;
    /* Get the two elements you want to compare,
    one from current row and one from the next: */
    x = rows[i].getElementsByTagName("TD")[n];
    y = rows[i + 1].getElementsByTagName("TD")[n];
    /* Check if the two rows should switch place,
    based on the direction, asc or desc: */
    if (dir == "asc") {
    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
    // If so, mark as a switch and break the loop:
    shouldSwitch = true;
    break;
    }
    } else if (dir == "desc") {
    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
    // If so, mark as a switch and break the loop:
    shouldSwitch = true;
    break;
    }
    }
    }
    if (shouldSwitch) {
    /* If a switch has been marked, make the switch
    and mark that a switch has been done: */
    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
    switching = true;
    // Each time a switch is done, increase this count by 1:
    switchcount ++;
    } else {
    /* If no switching has been done AND the direction is "asc",
    set the direction to "desc" and run the while loop again. */
    if (switchcount == 0 && dir == "asc") {
    dir = "desc";
    switching = true;}}}}
</script>