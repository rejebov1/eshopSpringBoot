<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">

    <div class="row">

        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked admin-menu">
                <li class="active"><a href="${pageContext.request.contextPath}/profile/edit" data-target-id="profile"><i
                        class="glyphicon glyphicon-user"></i> Edit profile</a></li>
                <li><a href="${pageContext.request.contextPath}/profile/changePassword"
                       data-target-id="change-password"><i class="glyphicon glyphicon-lock"></i> Change Password</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/logout" data-target-id="logout"><i
                        class="glyphicon glyphicon-log-out"></i> Logout</a></li>
            </ul>
        </div>

        <div class="col-md-9  admin-content" id="profile">
            <div class="panel panel-info" style="margin: 1em;">
                <div class="panel-heading">
                    <h3 class="panel-title">Full name</h3>
                </div>
                <div class="panel-body">
                    <c:out value="${user.fullName}"/>
                </div>
            </div>
            <div class="panel panel-info" style="margin: 1em;">
                <div class="panel-heading">
                    <h3 class="panel-title">Email</h3>
                </div>
                <div class="panel-body">
                    <c:out value="${user.email}"/>
                </div>
            </div>
            <div class="panel panel-info" style="margin: 1em;">
                <div class="panel-heading">
                    <h3 class="panel-title">Phone number</h3>
                </div>
                <div class="panel-body">
                    <c:out value="${user.phoneNumber}"/>
                </div>
            </div>

            <div class="panel panel-info" style="margin: 1em;">
                <div class="panel-heading">
                    <h3 class="panel-title">Address</h3>
                </div>
                <div class="panel-body">
                    <c:out value="${user.address}"/>
                </div>
            </div>

            <div class="panel panel-info" style="margin: 1em;">
                <div class="panel-heading">
                    <h3 class="panel-title">Role</h3>
                </div>
                <div class="panel-body">
                    <c:out value="${user.role.toString()}"/>
                </div>
            </div>
        </div>
    </div>
</div>
