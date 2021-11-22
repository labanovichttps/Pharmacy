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
    <link rel="stylesheet" href="static/css/login.css">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <title>Login</title>
</head>
<body>


<section class="vh-100 ">
    <form action="<c:url value="<%=AppConstant.AUTHORIZATION_CONTROLLER%>"/>" method="post">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                <p class="text-white-50 mb-5">Please enter your login and password!</p>

                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="typeEmailX" class="form-control form-control-lg"
                                           name="<%=AppConstant.LOGIN_LABEL%>"/>
                                    <label class="form-label" for="typeEmailX">Login</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg"
                                           name="<%=AppConstant.PASSWORD_LABEL%>"/>
                                    <label class="form-label" for="typePasswordX">Password</label>
                                </div>

                                <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a>
                                </p>

                                <button class="btn btn-outline-light btn-lg px-5"
                                        onclick="window.location.href='home.jsp'" type="submit">Login
                                </button>

                            </div>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="registration.jsp"
                                                                          class="text-white-50 fw-bold">Sign Up</a></p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <%--error message--%>
    <c:if test="${not empty message}">
        <p style="color: red">${message}</p>
    </c:if>
</section>
</body>
</html>
