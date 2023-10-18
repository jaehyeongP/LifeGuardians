<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <jsp:include page="/fragments/head.jsp"/>
</head>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=e2o0bgo5bp&submodules=geocoder"></script>
<script src="/resource/assets/js/account/signup_hospital.js"></script>
<script src="/resource/assets/js/account/hospital_idcheck.js"></script>
<script src="/resource/assets/js/account/pwdsame.js"></script>


<body>
<main id="main" class="bg-secondary">
    <jsp:include page="/fragments/contents/account/signup_hospital_content.jsp" />
</main><!-- End #main -->

<footer id="footer" class="fixed-bottom">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<jsp:include page="/fragments/vendor.jsp"/>

<!-- Template Main JS File -->
<script src="/resource/assets/js/main.js"></script>

</body>

</html>