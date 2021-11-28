<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/Profile.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>Профиль</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>

    <jsp:include page="templates/header.jsp"/>

    <div class="main">
        <div class="profile-form-container">

            <svg xmlns="http://www.w3.org/2000/svg" width="154" height="154" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"></path>
            </svg>

            <div class="info">
                
                <div class="nick-name">
                    ${user.login}
                </div>

                <form class="info" action="<c:url value="/edit"/>" method="post">
                    <input type="text" placeholder="Имя" class="input" name="name" value="${user.name}">
                    <input type="text" placeholder="Фамилия" class="input" name="surname" value="${user.surname}">
                    <input type="email" placeholder="Эл. почта" class="input" name="email" value="${user.email}">
                    <button class="button" type="submit">Сохранить</button>
                </form>
            </div>

        </div>
    </div>
    
</body>
</html>