<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Товары
        </h3>
        <div class="well">
            <c:set var="count" value="0"/>
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="iter" value="1"/>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <th scope="row"><a href="${pageContext.request.contextPath}/orders/${order.id}"><c:out value="${order.id}"/></a></th>
                                <td><c:out value="${order.totalPrice} $"/></td>
                                <td><c:out value="${order.status.toString()}"/></td>
                                <td>
                                    <c:if test="${order.possibleToEdit}">
                                        <a href="${pageContext.request.contextPath}/orders/${order.id}/return" class="btn btn-default" type="button">Вернуть в корзину</a>
                                    </c:if>
                                </td>
                            </tr>
                            <c:set var="iter" value="${iter+1}"/>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>