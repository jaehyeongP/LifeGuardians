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

    <!-- 예약 양식 -->
    <form action="" id="reserve" method="POST" novalidate>
        <div class="form-group">
            <label for="name">환자 이름 *</label>
            <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요">
        </div>
        <div class="form-group">
            <label for="idNumber">주민등록번호 *</label>
            <input type="number" class="form-control" id="idNumber" placeholder="주민등록번호를 입력해주세요">
        </div>
        <div class="form-group">
            <label for="phone">연락 받을 휴대전화 *</label>
            <input type="tel" class="form-control" id="phone" placeholder="전화번호를 입력해주세요">
        </div>
        <div class="form-group">
            <label for="datePicker">예약 일자 *</label>
            <input type="date" class="form-control" id="datePicker">
        </div>
        <div class="form-group">
            <label for="message">증상</label>
            <textarea class="form-control" id="message" rows="3" placeholder="증상을 입력해주세요"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">예약 신청</button>
    </form>
</div>



