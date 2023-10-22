<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
  <div class="container">
    <c:if test="${board.member_id == sessionScope.member_id}">
      <div class="row">
        <div class="col-10">
          <input id="board_id" type="hidden" value="${board.board_id}">
        </div>
        <div class="col-2">
          <input id="btn_delete" class="btn btn-outline-danger" type="button" value="삭제">
        </div>
      </div>
    </c:if>
    <c:if test="${sessionScope.member_id != board.member_id}">

    </c:if>
    <c:if test="${sessionScope.member_id == null}">

    </c:if>
    <div class="row form-control">
        <div class="col-9">${board.title}</div>
    </div>
    <div class="row form-control">
        <div class="col-auto">${board.content}</div>
    </div>
  </div>
  
</section>

<section>

  <div class="container">
    <input id="board_id" type="hidden" value="${board.board_id}">
    <%-- 댓글 작성 --%>
    <c:if test="${sessionScope.hp_id != null}">
      <div class="row">
        <div class="col-9">
          <input id="reply_content" type="text" class="form-control" placeholder="댓글 작성">
        </div>
        <div class="col-3">
          <input id="btn_reply" class="btn btn-outline-primary" type="button" value="댓글쓰기">
        </div>
      </div>
    </c:if>
    <c:if test="${sessionScope.hp_id == null}">
      
    </c:if>
    
    <%-- 달린 댓글 출력 부분 --%>
    <div id="replyList"></div>
    <c:if test="${reply != null}">
      <div class="row">
        <c:forEach var="r" items="${reply}">
          <div class="col-3">
            <input class="form-control" type="text" value="${r.dutyName}" readonly>
          </div>
          <div class="col-9">
            <input class="form-control" type="text" value="${r.reply_content}" readonly>
          </div>
        </c:forEach>
      </div>
    </c:if>
    <c:if test="${reply == null}">
      <h4>등록된 댓글이 없습니다.</h4>
    </c:if>

  </div>
</section>