<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<html>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<h3 class="text-primary">
				Confirm order:
			</h3>
            <p>Customer: <c:out value="${user.fullName}"/></p>
            <%--<p>Адрес доставки: <c:out value="${user.address.address}"/></p>--%>
            <p>Delivery address: <c:out value="${user.address}"/>
            <p>Email: <c:out value="${user.email}"/></p>

            <c:if test="${totalPrice>0}">
                <div class="well">
                    <div class="row">
                        <div class="col-md-12" id="bucket-container">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Product number</th>
                                        <th>Phone</th>
                                        <th>Amount</th>
                                        <th>Price</th>
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
                                        </tr>
                                        <c:set var="iter" value="${iter+1}"/>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <p>Total price: ${totalPrice} $</p>

                    <div class="row">
                        <div class="col-md-10">
                        </div>
                        <div class="col-md-2">
                            <form action="${pageContext.request.contextPath}/orders" method="POST"><button type="submit" class="btn btn-primary">Confirm order</button></form>
                        </div>
                    </div>
                </div>
            </c:if>
		</div>
	</div>
</div>
</html>
