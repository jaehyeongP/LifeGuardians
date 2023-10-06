<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="utf-8">
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
<%--    &lt;%&ndash; TODO : anyDir와 anyFile은 직접 수정해야 함--%>
 <jsp:include page="/fragments/contents/hospital/detail_content.jsp"/>
</main>

<footer id="footer">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<jsp:include page="/fragments/vendor.jsp"/>

<!-- Template JS File -->
<%-- TODO : anyDir와 anyFile은 직접 수정해야 함--%>
<script src="/resource/assets/js/anyDir/anyFile.js"></script>