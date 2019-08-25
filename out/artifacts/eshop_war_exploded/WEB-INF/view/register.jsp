<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--@elvariable id="newUser" type=""--%>
<form:form class="form-horizontal" method="post" modelAttribute="newUser">

    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
    <head>
        <title>Registration</title>
            <%-- <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>--%>
            <%-- <link href="../resources/style.css" rel="stylesheet" type="text/css" media="screen, projection"/>--%>
        <style>
            <%@include file="../../resources/style.css"%>
        </style>
    </head>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Create Account</h4>
                <%--<form>--%>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                </div>
                <form:input id="fullName" name="fullName" type="text" placeholder="" class="form-control input-md"
                            required="" path="fullName"/>
                <p class="bg-danger">
                    <form:errors path="fullName" cssClass="error"/></p>
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                </div>
                <input id="email" name="email" value="" type="text" placeholder="Enter your email"
                       pattern="(.+)@(.+)$"
                       title="Email example: email@email.com"
                       class="form-control input-md" required="">
                <p class="bg-danger"><form:errors path="email" cssClass="error"/></p>
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                </div>
                <label>
                    <select class="custom-select" style="max-width: 120px;">
                        <option selected="">+375</option>
                    </select>
                </label>
                    <%--<input id="phoneNumber" name="phoneNumber" type="text" placeholder="(XX)XXX-XX-XX"
                           pattern="(^(17|29|33|44|25)\) [0-9]{3}-[0-9]{2}-[0-9]{2}$"
                           title="Phone example: (25) 111-11-11"
                           class="input-medium bfh-phone" required="">
                    <p class="bg-danger"><form:errors path="phoneNumber" cssClass="error" /></p>--%>
                <form:errors path="phoneNumber" cssClass="error"/> <br>
                <label for="phoneNumber">
                    <form:input path="phoneNumber" required="true"
                                pattern="^(33|44|29|25|17)(\s|-)?\d{3}(\s|-)?\d{2}(\s|-)?\d{2}$"
                                type="tel" class="form-control signUp-field" id="phoneNumber" placeholder="XX XXX XX XX"
                                title="Use operator code 33,44,29,25,17"/>
                </label>
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
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                </div>
                <input id="confirmPassword" name="confirmPassword" value="" type="password"
                       placeholder="Confirm your password"
                       pattern="[a-zA-Z0-9а-яА-ЯёЁ]{4,}"
                       title="Password must contain at least 1 letter and minimum 4 characters"
                       class="form-control input-md" required="">
                <form:errors path="confirmPassword" cssClass="error"/> <br>
                <span id="confirmPassword" style="color: red;"></span>
            </div> <!-- form-group// -->
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Create Account</button>
            </div> <!-- form-group// -->
            <p class="text-center">Have an account? <a href="${pageContext.request.contextPath}/login">Log In</a></p>
                <%--</form>--%>
        </article>
    </div>
</form:form>

