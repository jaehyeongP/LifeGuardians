<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="utf-8">
<head>
    <jsp:include page="/fragments/head.jsp"/>
</head>

<body>
<div id="topbar" class="d-flex align-items-center">
    <jsp:include page="/fragments/common/topbar.jsp"/>
</div>

<header id="header">
    <jsp:include page="/fragments/common/header.jsp"/>
</header>

<main id="main">
 <jsp:include page="/fragments/contents/medicine/detail_content.jsp"/>
</main>

<footer id="footer">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<jsp:include page="/fragments/vendor.jsp"/>

<!-- Template JS File -->
<script src="/resource/assets/js/medicine/detail.js"></script>
</body>
</html>