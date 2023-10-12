<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" review_elements  p-2 m-2 h-100"
     style='background-color:white ;   border: 2px solid black; border-radius: 10px; height:1000px'>
  <!--<div class=" p-2 w-100 h-100" style='background-color:white;  border-color:black'>
    <div class="review_top"
         style="border-width: 1px;  border-radius:10px; height:10px">
      리뷰

    </div>

    <div id="review1" class="review-1 border m-2 mt-4 mb-4 p-2 "
         style="border-width: 20px ;  height:260px ">

      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 제목:  </div>


      </div>
      <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
        <div class="p-2 bd-highlight" style="overflow:scroll; height:auto;" >



        </div>
      </div>
      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 작성자: </div>
        <div class="p-2 bd-highlight" > 작성일:</div>
        <div class="p-2 bd-highlight" > 평점:  </div>
      </div>
    </div>



    <div id="review2" class="review-1 border m-2 mt-4 mb-4 p-2 "
         style="border-width: 20px ;  height:260px">

      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 제목:  </div>


      </div>
      <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
        <div class="p-2 bd-highlight" > 내용  </div></div>
      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 작성자: </div>
        <div class="p-2 bd-highlight" > 작성일:</div>
        <div class="p-2 bd-highlight" > 평점:  </div>
      </div>
    </div>

    <div id="review3" class="review-1 border m-2 mt-4 mb-4 p-2 "
         style="border-width: 20px ;  height:260px">

      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 제목:  </div>


      </div>
      <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
        <div class="p-2 bd-highlight" > 내용  </div></div>
      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 작성자: </div>
        <div class="p-2 bd-highlight" > 작성일:</div>
        <div class="p-2 bd-highlight" > 평점:  </div>
      </div>
    </div>

    <div id="review4" class="review-1 border m-2 mt-4 mb-4 p-2 "
         style="border-width: 20px ;  height:260px">

      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 제목:  </div>


      </div>
      <div class="content border m-1 p-1" style=" border-width:10px; height:190px; font-size:13px; border-color:black">
        <div class="p-2 bd-highlight" > 내용  </div></div>
      <div class="border d-flex justify-content-start" style="border-radius: 10px; border-width: 20px; border-color:black; font-size:10px; height:25px">
        <div class="p-2 bd-highlight" > 작성자: </div>
        <div class="p-2 bd-highlight" > 작성일:</div>
        <div class="p-2 bd-highlight" > 평점:  </div>
      </div>
    </div>
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
      </ul>
    </nav>

  </div>
-->

  <div id="map" style="width:100%;height:400px;"></div>
  <script>

    function test (x, y){
      var mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 16
      };

      var map = new naver.maps.Map('map', mapOptions);

      var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.3595704, 127.105399),
        map: map
      });
    }

  </script>


  <div>
    <progress value="20" max="100"></progress>
  </div>
  <div>
    <progress value="20" max="200"></progress>
  </div>

</div>