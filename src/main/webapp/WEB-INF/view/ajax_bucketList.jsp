<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table class="table">
    <thead>
        <tr>
            <th>Product number</th>
            <th>Phone</th>
            <th>Amount</th>
            <th>Price</th>
            <%--<th>Action</th>--%>

        </tr>
    </thead>
    <tbody>
        <c:set var="iter" value="1"/>
        <c:forEach var="entry" items="${orderItemList}">
            <tr>
                <th scope="row"><c:out value="${iter}"/></th>
                <td><c:out value="${entry.key.brand.name}"/></td>
                <td><c:out value="${entry.value}"/></td>
                <td><c:out value="${entry.key.price} $"/></td>
                <%--<td><button class="btn btn-default decreaseCount" productId="${entry.key.id}">-</button><button class="btn btn-default increaseCount" type="submit" productId="${entry.key.id}">+</button></td>--%>
            </tr>
            <c:set var="iter" value="${iter+1}"/>
        </c:forEach>
    </tbody>
</table>
