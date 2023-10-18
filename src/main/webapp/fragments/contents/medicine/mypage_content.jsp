<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
  <div class="container">
    <c:if test="${list != null}">
      <div class="row">
        <c:forEach var="l" items="${list}">
          <div class="card col-3">
            <img src="${l.itemImage}" class="card-img-top">
            <div class="card-body">
              <h5 class="card-title" onclick="detail(`${l.itemName}`)">${l.itemName}</h5>
              <p class="card-text">${l.take_time}</p>
              <p class="card-text">${l.efcyQesitm}</p>
              <div class="d-grid gap-2 d-md-flex justify-content-md-end"></div>
            </div>
            <div class="card-footer">
              <input class="btn btn-outline-primary" type="button" value="수정" onclick="edit(`${l.medicine_id}`)">
              <input class="btn btn-outline-danger" type="button" value="삭제" onclick="del(`${l.medicine_id}`)">
            </div>
          </div>
        </c:forEach>
      </div>
    </c:if>
    <c:if test="${list == null}">
      <h3>등록된 약이 없습니다</h3>
    </c:if>
  </div>
</section>
