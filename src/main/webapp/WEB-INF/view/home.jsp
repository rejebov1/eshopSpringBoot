<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<html>
<head>
    <title>Mobile shop</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="standart">
    <%--   Карусель которая НЕ смогла--%>
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/huuawei.jpg"
                     alt="First slide">
                <%-- <img src="<c:url value="/resources/img/image.jpg"/>"--%>
            </div>
        </div>

        <div class="pdt-content text-center images" style="margin-top: 20px;">
            <div class="item item-animate"
                 style="width: 100px; height: 100px; display: inline-block; margin-right: 70px;">
                <div class="product-image">
                    <a href="#" title="Apple" class="product-image">
                            <span class="img-main">
                                <img style="width: 120%;"
                                     src="${pageContext.request.contextPath}/resources/img/logo/appleLogo.png"
                                     alt="Apple">
                            </span>
                    </a>
                </div>
            </div>
            <div class="item item-animate"
                 style="width: 100px; height: 100px; display: inline-block; margin-right: 70px;">
                <div class="product-image">
                    <a href="#" title="Huawei" class="product-image">
                            <span class="img-main">
                                <img style="width: 120%;"
                                     src="${pageContext.request.contextPath}/resources/img/logo/huaweiLogo.png"
                                     alt="Huawei">

                            </span>
                    </a>
                </div>
                <%--<div class="title" >Huawei</div>--%>
            </div>


            <div class="item item-animate"
                 style="width: 100px; height: 100px;display: inline-block; margin-right: 70px;">
                <div class="product-image">
                    <a href="#" title="Asus" class="product-image">
                            <span class="img-main">
                                <img style="width: 148%;"
                                     src="${pageContext.request.contextPath}/resources/img/logo/asusLogo.jpg"
                                     alt="Asus">
                            </span>
                    </a>
                </div>
                <%--<div class="title" >Asus</div>--%>
            </div>

            <%--    <div class="clearfix" ></div>--%>


            <div class="item item-animate"
                 style="width: 100px; height: 100px;display: inline-block; margin-right: 70px;">
                <div class="product-image">
                    <a href="#" title="Xiaomi" class="product-image">
                            <span class="img-main">
                                <img style="width: 120%; margin-left: 40%"
                                     src="${pageContext.request.contextPath}/resources/img/logo/xiaomiLogo.png"
                                     alt="Xiaomi">
                            </span>
                    </a>
                </div>
                <%-- <div class="title" >Xiaomi</div>--%>
            </div>


            <div class="item item-animate"
                 style="width: 100px; height: 100px;display: inline-block; margin-right: 100px;">
                <div class="product-image">
                    <a href="#" title="Sony" class="product-image">
                            <span class="img-main">
                                <img style="width: 200%;"
                                     src="${pageContext.request.contextPath}/resources/img/logo/sonyLogo.png"
                                     alt="Sony">
                            </span>
                    </a>
                </div>
                <%--<div class="title" >Sony</div>--%>
            </div>


            <div class="item item-animate"
                 style="width: 100px; height: 100px;display: inline-block; margin-right: 70px;">
                <div class="product-image">
                    <a href="#" title="Samsung" class="product-image">
                            <span class="img-main">
                                <img style="width: 175%;"
                                     src="${pageContext.request.contextPath}/resources/img/logo/samsungLogo.png"
                                     alt="Samsung">
                            </span>
                    </a>
                </div>
                <%--<div class="title" >iPhone XS</div>--%>
            </div>
        </div>
    </div>

    <div id="sns_about">

        <div class="container">
            <div class="span6 pull-right">
                <%-- <div class="row align-items-right">
                     <div class="col-md-8 align-self-end">
                         <div class="span6 pull-right" >--%>
                <div class="title">About Us</div>
                <br>
                <br/>
                <div class="subtitle">Discover why we are the best choice</div>
                <p align="justify">
                    - We prefer to keep things simple - and let our prices do the
                    talking :-)
                    - Online Customer service guaranteed
                    - Phones are mailed within 24 hours of purchase from Minsk
                    - All our mobile phones are absolutely new
                    - We can offer you mobile to make your the best choice.

                    At MobileS we sell six different grades of phones, and these
                    are clearly marked on the product listing.
                </p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
