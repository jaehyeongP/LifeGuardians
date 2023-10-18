<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
  <div class="container">
    <c:if test="${sessionScope.member_id != null}">
      <div class="row">
        <div class="col-10">
          <input id="board_id" type="hidden" value="${board.board_id}">
        </div>
        <div class="col-2">
          <input id="btn_delete" class="btn btn-outline-danger" type="button" value="삭제">
        </div>
      </div>
    </c:if>
    <c:if test="${sessionScope.member_id == null}">

    </c:if>
    <div class="row form-control">
        <div class="col-3">${board.board_id}</div>
        <div class="col-9">${board.title}</div>
    </div>
    <div class="row form-control">
        <div class="col-auto">${board.content}</div>
    </div>
  </div>
</section>