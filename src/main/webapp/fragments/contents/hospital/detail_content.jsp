<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<div class=" detail_elements  p-2 m-2 h-100"--%>
<%--     style='background-color:white ;   border: 2px solid black; border-radius: 10px; height:1000px'>--%>
<%--    <div class=" p-2 w-100 h-100" style='background-color:white;  border-color:black'>--%>
<%--        <hr>--%>
<%--        <div id="detail-content" class="" style="" >--%>

<%--            <div class="d-flex justify-content-center">--%>
<%--                <div class="spinner spinner-border text-primary" id="spinner" role="status">--%>
<%--                    <span class="visually-hidden">Loading...</span>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--        </div>--%>

<%--    </div>--%>
<%--</div>--%>

<!-- 모달 창 -->
<div id="reservationModal" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="reservationModalLabel">병원 상세페이지</h5>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>--%>
            </div>
            <div id="detail-modal-body">
                <div class="spinner spinner-border text-primary" id="spinner" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                <a href="/reservation/reserve.do=?hpid=${hpid}" class="btn btn-primary" target="_self">예약하기</a>
            </div>
        </div>
    </div>
</div>

