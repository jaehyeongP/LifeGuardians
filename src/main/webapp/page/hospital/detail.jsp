<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<head>
    <jsp:include page="/fragments/head.jsp"/>
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=e2o0bgo5bp"></script>
    <script type="text/javascript" src="/resource/assets/js/hospital/detail.js"></script>
</head>


<div id="topbar" class="d-flex align-items-center fixed-top">
    <jsp:include page="/fragments/common/topbar.jsp"/>
</div>

<header>
    <jsp:include page="/fragments/common/header.jsp"/>
</header>

<main id="main">

    <div class="d-flex m-1" style="height: 1400px; background-color: #1977cc; border-radius: 10px;">
        <section id="detail" class=" detail_section_bg" style="width:700px">
            <jsp:include page="/fragments/contents/hospital/detail_content.jsp" />
        </section>


        <section id="review" class="review_section_bg" style="width:700px ; border-color:black;">
            <jsp:include page="/fragments/contents/hospital/review_content.jsp" />
        </section>

    </div>



</main>

<footer id="footer">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<jsp:include page="/fragments/vendor.jsp"/>

<!-- Template JS File -->

<%--<script src="/resource/assets/js/anyDir/anyFile.js"></script>--%>