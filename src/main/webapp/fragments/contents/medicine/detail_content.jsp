<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/10
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="pb-5">
  <c:if test="${medicine != null}">
    <div class="container">
        <div class="row mb-3 align-items-end">
            <div class="col-md-3"></div>
            <div class="col-md-6 text-center" data-aos="fade-up">
              <h2>${medicine.itemName} 상세 정보</h2>
            </div>
            <div class="col-md-3"></div>
        </div>
      </div>
    </div>
  </c:if>
</section>