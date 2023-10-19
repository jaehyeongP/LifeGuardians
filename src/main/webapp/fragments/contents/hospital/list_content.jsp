<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div class="container" style="height:900px;">
        <div class="row mb-5 text-center">
        </div>
        <div class="row">
            <div class="col-md-6">
                <table class="table table-hover align-items-center">
                    <tbody id="hospital-select-tbody">
                    </tbody>
                </table>
            </div>

            <div id="map_div" class="row col-md-6 align-items-center">
                <table class="table table-hover">
                    <tbody>
                    <tr><th id="map_address">병원을 선택해 주세요</th></tr>
                    </tbody>
                </table>

                <div id="map" class="map mb-2"style="width:100%;height:34%; border-radius:10px; border-width:2px; !important; border-style:solid !important; border-color:black !important;"></div>

                <jsp:include page="review_content.jsp"></jsp:include>
            </div>
        </div>
    </div>


<jsp:include page="detail_content.jsp"></jsp:include>
</section>