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

      <div class="input-group">                   
        <select id="search_type" class="form-select" name="search_type">
          <option value="medicine_name">약이름</option>
          <option value="symptom">증상</option>
        </select>
        <input type="text" id="search_keyword" class="form-control" name="search_keyword" placeholder="약 검색" style="width: 50%;" onsubmit="return false">
        <input type="button" id="btn_search" class="btn btn-primary" value="검색">
      </div>

    </div>

    <div id="medicineList" class="row"></div>

  </div>
</section>

<section>
  <div class="row">
    <div id="pagination" class="d-flex justify-content-center"></div>
  </div>
</section>