<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>bucket page</title>
        <jsp:include page="include/default-js-css-res.jsp" />
    </head>
    <%@ include file="header.jsp" %>
    <%@ include file="menu.jsp" %>
    <body>
        <script>
            $(document).ready(function () {
                $.post("${pageContext.request.contextPath}/bucket/ajax/list/", function (data) {
                    $("#bucket-container").html(data);
                });

                $(document).on("click", ".increaseCount",
                    function () {
                        $.post("${pageContext.request.contextPath}/bucket/ajax/increase-product-count/" + $(this).attr("productId"), function (data) {
                            $("#bucket-container").html(data);
                        });
                    });
                $(document).on("click", ".decreaseCount",
                    function () {
                        $.post("${pageContext.request.contextPath}/bucket/ajax/decrease-product-count/" + $(this).attr("productId"), function (data) {
                            $("#bucket-container").html(data);
                        });
                    });
            });
        </script>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">

                    <h3 class="text-primary">
                        Order list items:
                    </h3>

                    <c:if test="${totalOrderItemCount<1}">
                        <p>You have not added any products to your cart yet.</p>
                    </c:if>

                    <c:if test="${totalOrderItemCount>0}">
                        <div class="well">
                            <div class="row">
                                <div class="col-md-12" id="bucket-container">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-10">
                                </div>
                                <div class="col-md-2">
                                    <a href="${pageContext.request.contextPath}/orders/confirm" class="btn btn-primary"
                                       type="button">Make an order</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
