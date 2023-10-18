<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/18
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section>
  <div class="container">
    <c:if test="${sessionScope.member_id != null}">
      <div class="row">
        <div class="col-10"></div>
        <div class="col-2">
          <a class="btn btn-primary" href="/board/add.do">글쓰기</a>
        </div>
      </div>
    </c:if>
    <c:if test="${sessionScope.member_id == null}">
      
    </c:if>
    <c:if test="${list != null}">
      <div class="row">
        <table class="table">
          <tr>
            <th>#</th>
            <th>글제목</th>
          </tr>
          <c:forEach var="l" items="${list}">
            <tr onclick="detail(`${l.board_id}`)">
              <td>${l.board_id}</td>
              <td>${l.title}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </c:if>
  </div>
</section>

<section>
  <div class="row">
    <div id="pagination" class="d-flex justify-content-center"></div>
  </div>
</section>