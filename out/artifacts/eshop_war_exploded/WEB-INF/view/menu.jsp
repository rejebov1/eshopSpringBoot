<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<html>
<head>
    <title>Mobile shop</title>
    <%-- <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>--%>
    <%-- <link href="../resources/style.css" rel="stylesheet" type="text/css" media="screen, projection"/>--%>
    <style>
        <%@include file="../../resources/style.css"%>
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home"> <img class="d-block w-100"
                                                                                 src="${pageContext.request.contextPath}/resources/img/real.jpg"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
            aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation" style="">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <security:authorize access="hasAnyAuthority('ADMIN')">
                <li class="nav-item ">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin page</a>
                </li>
            </security:authorize>
            <security:authorize access="hasAnyAuthority('USER')">
                <li class="nav-item ">
                <li><a class="nav-link" href="${pageContext.request.contextPath}/order">Orders</a></li>
                <li><a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a></li>
                <li><a class="nav-link" href="${pageContext.request.contextPath}/productList">All Products</a></li>
            </security:authorize>
        </ul>
    </div>
</nav>