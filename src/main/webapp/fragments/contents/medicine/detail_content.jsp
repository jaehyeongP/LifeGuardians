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
              <h2>${medicine.itemName}</h2>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
          <div class="col-lg-6 col-md-6">
            <c:if test="${medicine.itemImage != null}">
              <img class="img-fluid" src="${medicine.itemImage}" alt="...">
            </c:if>
            <c:if test="${medicine.itemImage == null}">
              <h3>이미지가 없어용</h3>
            </c:if>
          </div>
          <div class="col-lg-6 col-md-6">
            <table class="table">
              <tr>
                <th>제조사</th>
                <td>${medicine.entpName}</td>
              </tr>
              <tr>
                <th>효능</th>
                <td>${medicine.efcyQesitm}</td>
              </tr>
              <tr>
                <th>사용법</th>
                <td>${medicine.useMethodQesitm}</td>
              </tr>
              <tr>
                <th>경고</th>
                <td>${medicine.atpnWarnQesitm}</td>
              </tr>
              <tr>
                <th>주의사항</th>
                <td>${medicine.atpnQesitm}</td>
              </tr>
              <tr>
                <th>상호작용</th>
                <td>${medicine.intrcQesitm}</td>
              </tr>
              <tr>
                <th>부작용</th>
                <td>${medicine.seQesitm}</td>
              </tr>
              <tr>
                <th>보관법</th>
                <td>${medicine.depositMethodQesitm}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </c:if>
</section>