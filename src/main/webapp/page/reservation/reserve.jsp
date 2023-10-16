<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">

<head>

    <jsp:include page="/fragments/head.jsp"/>
    <link rel="stylesheet" href="/resource/assets/css/jquery.datetimepicker.min.css">
    <script src="/resource/assets/js/reservation/jquery.datetimepicker.full.min.js"></script>

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

<%--    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>--%>

</main>

<footer id="footer">
    <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<%-- Vendor JS Files --%>
<jsp:include page="/fragments/vendor.jsp"/>

<script type="text/javascript" src="/resource/assets/js/reservation/datetimepicker.js"></script>


<%--<link rel="stylesheet" type="text/css" th:href="@{/static/plugins/datetimepicker/jquery.datetimepicker.min.css}">--%>
<%--<script th:src="@{/static/plugins/datetimepicker/jquery.datetimepicker.full.min.js}"></script>--%>

<%--<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
<%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
<%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
