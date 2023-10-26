<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <button type="button" class="btn btn-primary" onclick="moveToPage(this)">예약하기</button>
            </div>
        </div>
    </div>
</div>

