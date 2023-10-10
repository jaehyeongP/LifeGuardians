<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/10
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
  <div class="container">

    <div class="row mb-5 text-center">

      <form id="search_form" class="php-email-form px-5" method="get">
        <div class="input-group">                   
          <select class="form-select" id="search_type" name="search_type">
            <option value="medicine_name">약이름</option>
            <option value="symptom">증상</option>
          </select>
          <input type="text" id="search_medicine" class="form-control" placeholder="약 검색" style="width: 50%;">
          <input type="submit" id="search_btn" class="btn btn-primary" value="검색">
        </div>
      </form>

    </div>

    <div class="row">

      <c:forEach var="l" items="${list}">
        <div class="card col-md-3 mb-5 mb-md-0">
          <c:if test="${l.itemImage != null}">
            <img src="${l.itemImage}" class="card-img-top">
          </c:if>
          <c:if test="${l.itemImage == null}">
            <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
          </c:if>
          <div class="card-body">
            <h5 class="card-title">${l.itemName}</h5>
            <p class="card-text">${l.efcyQesitm}</p>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <a class="btn btn-outline-primary" href="/medicine/detail.do?itemSeq=${l.itemSeq}">상세보기</a>
            </div>
          </div>
        </div>
      </c:forEach>

    </div>

  </div>

</section>