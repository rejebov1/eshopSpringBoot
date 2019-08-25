<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>product page</title>
    <jsp:include page="include/default-js-css-res.jsp"/>
</head>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<body>
<div class="row">
    <div class="col-sm-4">
        <div class="thumbnail">
            <div class="caption">
                <c:forEach items="${products}" var="product">
                    <h3>
                        Phone : <c:out value="${product.brand.name}"/>
                    </h3>
                    <p>
                        Description : <c:out value="${product.description}"/>
                    </p>
                    <p>
                        Price : <c:out value="${product.price} $"/>
                    </p>
                    <p>
                        Produce country : <c:out value="${product.brand.produceCountry}"/>
                    </p>
                    <p>
                        Date of issue : <c:out value="${product.merchModel.dateOfIssue}"/>
                    </p>
                    <p>
                        <security:authorize access="hasAnyAuthority('USER')">
                            <button class="btn btn-primary addToBucket" productId="${product.id}">Add to bucket</button>
                        </security:authorize>
                    </p>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(document).on("click", ".addToBucket",
            function () {
                $.post("${pageContext.request.contextPath}/bucket/ajax/add/" + $(this).attr("productId"), {productCount: 1}, function (data) {
                    $("#bucket_counter").html(data);
                    alert("Товар добавлен");
                });
            });
    });
</script>
</body>
</html>