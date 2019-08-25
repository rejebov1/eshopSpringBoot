<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fieldset>

    <!-- Form Name -->
    <legend><c:out value="${action}"/> product</legend>


    <!-- Text input-->
    <div class="form-group">
        <label class="col-md-4 control-label" for="name">Naming</label>
        <div class="col-md-4">
            <form:input id="name" name="name" type="text" placeholder="" class="form-control input-md" required=""
                        path="name"/>
            <p class="bg-danger"><form:errors path="name" cssClass="error"/></p>
        </div>
    </div>

    <!-- Textarea -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="description">Description</label>
        <div class="col-md-4">
            <form:textarea class="form-control" id="description" name="description" path="description"/>
            <p class="bg-danger"><form:errors path="description" cssClass="error"/></p>
        </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
        <label class="col-md-4 control-label" for="price">Price</label>
        <div class="col-md-4">
            <form:input id="price" name="price" type="text" placeholder="" class="form-control input-md" required=""
                        path="price"/>
            <p class="bg-danger"><form:errors path="price" cssClass="error"/></p>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-4 control-label" for="price">Price</label>
        <div class="col-md-4">
            <form:input id="date of issue" name="date of issue" type="text" placeholder="" class="form-control input-md"
                        required="" path="date of issue"/>
            <p class="bg-danger"><form:errors path="price" cssClass="error"/></p>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-4 control-label" for="price">Price</label>
        <div class="col-md-4">
            <form:input id="produce country" name="produce country" type="text" placeholder=""
                        class="form-control input-md" required="" path="produce country"/>
            <p class="bg-danger"><form:errors path="produce country" cssClass="error"/></p>
        </div>
    </div>

    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="register"></label>
        <div class="col-md-4">
            <button id="register" name="register" class="btn btn-primary"><c:out value="${action}"/></button>
        </div>
    </div>

</fieldset>
</form:form>

