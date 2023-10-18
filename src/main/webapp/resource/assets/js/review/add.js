

window.onload = function () {
    document.getElementById('bestImage').addEventListener('click', changeImageBest);
    document.getElementById('goodImage').addEventListener('click', changeImageGood);
    document.getElementById('normalImage').addEventListener('click', changeImageNormal);
    document.getElementById("badImage").addEventListener("click", changeImageBad);
    document.getElementById("worstImage").addEventListener("click",changeImageWorst);
    document.getElementById('add_best').addEventListener('change', changeImageBest);
    document.getElementById('add_good').addEventListener('change', changeImageGood);
    document.getElementById('add_normal').addEventListener('change', changeImageNormal);
    document.getElementById('add_bad').addEventListener("change", changeImageBad);
    document.getElementById("add_worst").addEventListener("change", changeImageWorst);

    $('#review_submit_form').on("submit", function (e) {
        e.preventDefault(); //공부
        calReviewAddHandler("A2114469");
        // calReviewAddHandler(hpid);
    });



    console.log("Hello");
    test();

}


function calReviewAddHandler(hpid) {
    console.log(hpid);

    let formData = new FormData($('#review_submit_form')[0]);
    formData.append("hpid", hpid);


    $.ajax({
        url: "/hospital/review/add.do",
        type: "post",
        enctype: "multipart/form-data",
        processData: false,
        contentType: false,
        data: formData,
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



function test() {
    console.log("test");

}



// 여기서부터 이미지 변경되는 함수


function resetImages() {
    document.getElementById('bestImage').src = defaultImages.best;
    document.getElementById('goodImage').src = defaultImages.good;
    document.getElementById('normalImage').src = defaultImages.normal;
    document.getElementById('badImage').src = defaultImages.bad;
    document.getElementById('worstImage').src = defaultImages.worst;
}

function changeImageBest() {
    resetImages();
    var radio = document.getElementById('best');
    var image = document.getElementById('bestImage');

    radio.checked=true;
        image.src="/resource/assets/img/emoji/image_processing20200510-10310-2x47zj.png";

}

function changeImageGood() {
    resetImages();
    var radio = document.getElementById('good');
    var img = document.getElementById('goodImage');

    if (radio.checked) {
        img.src ="/resource/assets/img/emoji/image_processing20200510-10310-2x47zj(1).png";
    }
}

function changeImageNormal() {
    resetImages();

    var radio=document.getElementById('normal');
    var img=document.getElementById('normalImage');

    if(radio.checked){
        img.src="/resource/assets/img/emoji/image_processing20200510-16409-11khjpu.png";
    }
}

function changeImageBad() {
    resetImages();

    var radio=document.getElementById('bad');
    var img=document.getElementById('badImage');

    if(radio.checked){
        img.src="/resource/assets/img/emoji/png-transparent-emoji-emoticon-expression-annoyed-emoji-icon-thumbnail.png";
    }
}

function changeImageWorst() {
    resetImages();

    var radio=document.getElementById('worst');
    var img=document.getElementById('worstImage');

    if(radio.checked){
        img.src="/resource/assets/img/emoji/image_processing20200511-10310-g2cru8.png";
    }
}

var defaultImages = {
    best: "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/48205/smiling-face-with-smiling-eyes-emoji-clipart-md.png",
    good: "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/47713/smiling-face-emoji-clipart-md.png",
    normal: "https://i.namu.wiki/i/yJApduHcc407AABSeNmsLm1-EPta1FESJvt3ScKPqXedSCGbpkoHTicJ3FIFXNUKg89hR2QIIH4BqvrvCYK3FQ.svg",
    bad: "https://w7.pngwing.com/pngs/699/293/png-transparent-emoji-emoticon-expression-annoyed-emoji-icon-thumbnail.png",
    worst: "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/55893/angry-face-emoji-clipart-md.png"
};

