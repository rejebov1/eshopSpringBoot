<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>bucket page</title>
    <jsp:include page="../include/default-js-css-res.jsp"/>
</head>
<%@include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
<body>
<script>
    $(document).ready(function () {
        $.get("${pageContext.request.contextPath}/admin/users/ajax", function (data) {
            $("#users-container").html(data);
        });

        $(document).on("click", ".blockUser",
            function () {
                $.post("${pageContext.request.contextPath}/admin/users/" + $(this).attr("userId") + "/block", function (data) {
                    $("#users-container").html(data);
                });
            }
        );

        $(document).on("click", ".unblockUser",
            function () {
                $.post("${pageContext.request.contextPath}/admin/users/" + $(this).attr("userId") + "/unblock", function (data) {
                    $("#users-container").html(data);
                });
            }
        );
        $(document).on("click", ".deleteUser",
            function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/users/" + $(this).attr("userId") + "/block",
                    type: 'DELETE',
                    success:
                        function (data) {
                            $("#users-container").html(data);
                        }
                });
            }
        );
    });
</script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <h3 class="text-primary">
                User list:
            </h3>

            <div class="row">
                <div class="col-md-12" id="users-container">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
