function calReviewAddHandler() {
    var formData = new FormData($('#review_submit_form')[0]);

    var data = {};
    formData.forEach(function(value, key){
        data[key] = value;
    });

    $.ajax({
        url: "/api/hospital/review/add.do",
        type: "post",
        data: data,
        success: function (jsonData) {
            alert("리뷰가 작성되었습니다.")
            let hpid = $('#review_hpid').val();
            $("#reviewModal").modal('hide');
            $('#' +hpid+ '_detail_btn').attr('class', 'text-success').text("방문 완료");
        },
        error: function (error) {
            console.error("Error occurred while fetching data", error);
        }
    });
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
    normal: "/resource/assets/img/emoji/aZHCfuhGuOOYwW2qVXWHexwrRIyJANgCLjN7lWOdmbO21vE_d90xpVXz3SyMYtehQnyruxenEMnVAeigcZf6cQ.svg",
    bad: "https://w7.pngwing.com/pngs/699/293/png-transparent-emoji-emoticon-expression-annoyed-emoji-icon-thumbnail.png",
    worst: "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/55893/angry-face-emoji-clipart-md.png"
};

