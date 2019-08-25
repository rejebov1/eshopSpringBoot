<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Заказы
        </h3>
        <div class="well">
            <c:set var="count" value="0"/>
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Стоимость</th>
                            <th>Пользователь</th>
                            <th>Статус</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <th scope="row"><c:out value="${order.id}"/></th>
                                <td><c:out value="${order.totalPrice}"/></td>
                                <td><c:out value="${order.user.email}"/></td>
                                <td><c:out value="${order.status.toString()}"/></td>
                                <td>
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/orders/${order.id}/edit">
                                        <select id="status" name="status" class="form-control">
                                          <option value="NEW">New</option>
                                          <option value="IN_PROGRESS">Delivery in process</option>
                                          <option value="DELIVERED">Delivered</option>
                                        </select>
                                        <button id="add" name="add" class="btn btn-primary">Change status</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>