<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<div class="header-container" style="background-color: white; color: white; ">

    <div class="topheader-right span6">
        <security:authorize access="authenticated" var="authenticated" />
        <c:choose>
            <c:when test="${authenticated}">
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/reg">Registration</a>
                <a href="${pageContext.request.contextPath}/bucket">Bucket</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>


