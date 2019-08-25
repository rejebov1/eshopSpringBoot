<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<form:form class="form-horizontal" method="post" modelAttribute="user">
    <fieldset>

        <!-- Form Name -->
        <legend>Edit profile</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fullName">Full name</label>
            <div class="col-md-4">
                <form:input id="fullName" name="fullName" type="text" placeholder="" class="form-control input-md" required="" path="fullName"/>
                <p class="bg-danger"><form:errors path="fullName" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Phone number</label>
            <div class="col-md-4">
                <form:input id="phone" name="phone" type="text" placeholder="" class="form-control input-md" required="" path="phoneNumber"/>
                <p class="bg-danger"><form:errors path="phoneNumber" cssClass="error" /></p>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Address</label>
            <div class="col-md-4">
                <form:input id="address" name="address" type="text" placeholder="" class="form-control input-md" required="" path="address"/>
                <p class="bg-danger"><form:errors path="address" cssClass="error" /></p>
            </div>
        </div>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                <button id="register" name="register" class="btn btn-primary">Save</button>
            </div>
        </div>

    </fieldset>
</form:form>