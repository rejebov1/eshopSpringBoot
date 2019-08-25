<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<form class="form-horizontal" method="POST">
    <fieldset>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>

        <head>
            <title>Login</title>
            <%-- <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>--%>
            <%-- <link href="../resources/style.css" rel="stylesheet" type="text/css" media="screen, projection"/>--%>
            <style>
                <%@include file="../../resources/style.css"%>
            </style>
        </head>

        <div>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
        </div>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
              id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <div class="card bg-light">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <h4 class="card-title mt-3 text-center">Sign in</h4>
                <%--<form action="login" method="post">--%>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input id="email" name="email" value="" type="text" placeholder="Enter your email"
                           pattern="(.+)@(.+)$"
                           title="Email example: email@email.com"
                           class="form-control input-md" required="">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input id="password" name="password" value="" type="password" placeholder="Enter your password"
                           pattern="[a-zA-Z0-9а-яА-ЯёЁ]{4,}"
                           title="Password must contain at least 1 letter and minimum 4 characters"
                           class="form-control input-md" required="">
                </div> <!-- form-group// -->
                <div class="form-group">

                    <security:csrfInput/>

                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                </div> <!-- form-group// -->
                <%--</form>--%>
            </article>
        </div>
    </fieldset>
</form>
</html>
