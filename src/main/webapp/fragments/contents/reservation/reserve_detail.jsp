<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body {
        background-color: #f5f5f5;
    }
    .container {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
    }
    h1 {
        color: #007BFF;
    }
</style>

<div class="container mt-5">
    <h1 class="text-center">병원 방문 예약</h1>

    <!-- 예약 양식 폼 제출-->
    <form action="/reservation/reserve.do" id="reserve" method="POST" novalidate>
        <div class="form-group">
            <label for="name">환자 이름 </label>
            <input type="text" class="form-control" value="${member.username}" id="name" readonly>
        </div>

        <div class="form-group">
            <label for="phone">연락 받을 휴대전화 *</label>
            <input type="tel" class="form-control" id="phone" placeholder="전화번호를 입력해주세요">
        </div>

        <div class="form-group">
            <label for="dutyName">기관명</label>
            <input type="text" class="form-control" id="dutyName" value="" readonly>
        </div>

        <%--datetimepicker--%>
        <div class="form_group">
            <label for="datetimepicker">예약 일시</label><br/>
            <input type="text" id="datetimepicker" name="datetimepicker" readonly="readonly" />
        </div>

        <div class="form-group">
            <label for="symptoms">증상</label>
            <textarea class="form-control" id="symptoms" rows="3" placeholder="증상을 입력해주세요"></textarea>
        </div>

        <button type="submit" class="btn btn-primary">예약 신청</button>

    </form>
</div>

