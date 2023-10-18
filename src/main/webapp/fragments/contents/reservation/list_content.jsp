<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div class="container" style="height:900px;">

        <%--    검색창--%>
        <div class="row mb-5 text-center">
            <form id="search_form" class="php-email-form px-5" method="get">

                <div class="input-group">
                    <select class="form-select" id="search_type" name="search_type">
                        <option value="medicine_name">병원이름</option>
                        <option value="symptom">진료과목</option>
                        <option value="symptom">주소</option>
                    </select>
                    <input type="text" id="search_medicine" class="form-control" placeholder="병원 검색"
                           style="width: 50%;">
                    <input type="submit" id="search_btn" class="btn btn-primary" value="검색">
                </div>

            </form>
        </div>
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
                    <tr>
                        <td id="btn1" class="text-center col-md-6" style="border: none">
                            <div class="btn btn-outline-danger">예약 취소</div>
                        </td>
                        <td id="btn2" class="text-center col-md-auto" style="border: none">
                            <div class="btn btn-outline-success">방문 완료</div>
                        </td>
                    </tr>
                    </tbody>

                </table>
                <input id="hidden_reserveId" name="hidden_reserveId" type="hidden" value="">

<%--                <div id="reviewModal" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">--%>
<%--                    <div class="modal-dialog" role="document">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title" id="reservationModalLabel">병원 상세페이지</h5>--%>
<%--                                &lt;%&ndash;                <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>&ndash;%&gt;--%>
<%--                            </div>--%>
<%--                            <div id="detail-modal-body">--%>
<%--                                <jsp:include page="/fragments/contents/hospital/review_add_content.jsp"></jsp:include>--%>
<%--&lt;%&ndash;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="spinner spinner-border text-primary" id="spinner" role="status">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <span class="visually-hidden">Loading...</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                            </div>--%>
<%--&lt;%&ndash;&ndash;%&gt;--%>
<%--                            <div class="modal-footer">--%>
<%--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>--%>
<%--                                <button type="button" class="btn btn-primary" onclick="moveToPage(this)">예약하기</button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>




            </div>
        </div>
    </div>
    <%--  <jsp:include page="detail_content.jsp"></jsp:include>--%>
</section>