<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">

<head>
    <jsp:include page="/fragments/head.jsp"/>

</head>


<div id="topbar" class="d-flex align-items-center fixed-top">
    <jsp:include page="/fragments/common/topbar.jsp"/>
</div>

<header>
    <jsp:include page="/fragments/common/header.jsp"/>
</header>

<main id="main">
    <div class="d-flex m-1" style="height: 1400px; background-color: #1977cc; border-radius: 10px;">
        <div class="container-fluid" style="">
            <jsp:include page="/fragments/contents/reservation/reserve_detail.jsp"/>
        </div>
    </div>

</main>

<footer id="footer">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<%-- Vendor JS Files --%>
<jsp:include page="/fragments/vendor.jsp"/>
