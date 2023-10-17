function getReviewAvg(hpid) {
    console.log(hpid);

    $.ajax({
        url: "/review/rate.do",
        dataType: "json",
        data: {"hpid": hpid},
        success: function (jsonData) {
            $('#worst_progress').val(jsonData.avg1);
            $('#bad_progress').val(jsonData.avg2);
            $('#normal_progress').val(jsonData.avg3);
            $('#good_progress').val(jsonData.avg4);
            $('#best_progress').val(jsonData.avg5);

        },
        error: function (error) {
            console.error("Error occurred while fetching data", error);
        }
    });
}

function navermap(x, y) {

    $("#map").children().remove();

    var mapOptions = {
        center: new naver.maps.LatLng(x, y),
        zoom: 16
    };


    var map = new naver.maps.Map('map', mapOptions);

    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(x, y),
        map: map
    });
}






