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
          <input type="text" id="search_medicine" class="form-control" placeholder="병원 검색" style="width: 50%;">
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
          <tbody>
          <tr><th id="reserve_detail_title">예약 상세</th></tr>
          </tbody>
        </table>
<%--          예약 detail--%>
        <div id="reserve_detail" class="map mb-2"style="width:100%;height:34%; border-radius:10px; border-width:2px; !important; border-style:solid !important; border-color:black !important;">
            <input id="hidden_reserveId" type="hidden" value="">
            <h3>예약 상세정보</h3>
            예약 상태 : <input type="text" id="status" value="" readonly><br/>
            증상 : <input type="text" id="symptoms" value="" readonly><br/>
            예약 시간 : <input type="text" id="reserveTime" value="" readonly><br/>
            수정일 : <input type="text" id="editDate" value="" readonly><br/>
            <button type=""></button>
        </div>

        <div>test</div>


<%--        <jsp:include page="review_content.jsp"></jsp:include>--%>
      </div>
    </div>
  </div>


<%--  <jsp:include page="detail_content.jsp"></jsp:include>--%>
</section>