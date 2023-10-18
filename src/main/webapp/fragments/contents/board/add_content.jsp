<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/18
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section>
  <form method="post">
    <div class="container">
      <div class="row form-control">
        <div class="col-3">
          <label for="title">글제목</label>
        </div>
        <div class="col-9">
          <input id="title" type="text" placeholder="글 제목을 입력하세요">
        </div>
      </div>
      <div class="row form-control">
        <div class="col-3">
          <label for="content">내용</label>
        </div>
        <div class="col-9">
          <textarea id="content" cols="30" rows="10"></textarea>
        </div>
      </div>
      <div class="row">
        <div class="col-10"></div>
        <div class="col-2">
          <input id="btn_add" class="btn btn-outline-primary" type="button" value="작성">
        </div>
      </div>
    </div>
  </form>
</section>
