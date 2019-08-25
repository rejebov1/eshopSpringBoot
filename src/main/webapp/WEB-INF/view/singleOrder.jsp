<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <h3 class="text-primary">
                Purchase number: <c:out value="${order.id}"/>
            </h3>

            <p>Order status: <c:out value="${order.status.toString()}"/></p>

            <div class="well">
                <div class="subtitle">Thank you for order!</div>
            </div>
            <p>Total price for your purchases : ${totalPrice}$</p>
        </div>
    </div>
</div>
