<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div class="container" style="height:900px;">

        <div class="row">

            <%--      예약 list main--%>
            <div class="col-md-6">
                <table class="table table-hover align-items-center">
                    <tbody id="hospital-select-tbody">

                    </tbody>
                </table>
            </div>
            <%--      예약 detail Title--%>
            <div id="reserve_div" class="row col-md-6 align-items-center">
                <table class="table table-hover">

                    <thead>
                    <tr>
                        <th id="reserve_detail_title">예약 상세</th>
                    </tr>
                    </thead>

                    <tbody class="" style="width:100%; border-radius:10px; border-width:2px; !important; border-style:solid !important; border-color:black !important;">
                    <tr>
                        <th>
                            <label id="dutyName_label" class="col-form-label">예약내역을 선택해주세요.</label>
                            <label id="extraAddress_label" class="col-form-label"></label>
                        </th>
                        <th></th>
                    </tr>

                    <tr>
                        <td class="margin col-md-auto" style="border: none"></td>
                    </tr>

                    <tr>
                        <td id="address_title" class="text-center col-md-3" style="border: none">주소</td>
                        <td id="address_content" class="text-center col-md-9" style="border: none"></td>
                    </tr>

                    <tr>
                        <td id="tel_title" class="text-center col-md-6" style="border: none">전화 번호</td>
                        <td id="tel_content" class="text-center col-md-auto" style="border: none"></td>
                    </tr>

                    <tr>
                        <td id="reserve_time_title" class="text-center col-md-6" style="border: none">예약 시간</td>
                        <td id="reserve_time_content" class="text-center col-md-auto" style="border: none"></td>
                    </tr>
                    <tr>
                        <td class="margin col-md-auto" style="border: none"></td>
                    </tr>
                    <tr>
                        <td id="symptoms_title" class="text-center col-md-6" style="border: none">증상</td>
                        <td id="symptoms_content" class="text-center col-md-auto" style="border: none"></td>
                    </tr>
                    <tr id="status_btn_tr">
                        <input id="review_dutyName" type="hidden" value="">
                        <input id="review_hpid" type="hidden" value="">

                        <td id="reservation_cancel_btn" class="text-center col-md-6" style="border: none">
                            <div class="btn btn-outline-danger" onclick="editStatus()">예약 취소</div>
                        </td>
                        <td id="reservation_review_btn" class="text-center col-md-auto" style="border: none">
                            <div class="btn btn-outline-success" onclick="showModal(this)">방문 완료</div>
                        </td>
                    </tr>
                    </tbody>

                </table>

                <div id="reviewModal" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="reservationModalLabel">리뷰 작성</h5>
                            </div>

                            <div id="detail-modal-body">
                                <jsp:include page="/fragments/contents/hospital/review_add_content.jsp"></jsp:include>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>