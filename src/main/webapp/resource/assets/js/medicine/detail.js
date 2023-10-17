const btn_add = document.getElementById("btn_add");
const member_id = document.getElementById("member_id");

btn_add.addEventListener("click", () => {
    if (!confirm("내 약으로 등록하시겠습니까?")) {
        alert("등록이 취소되었습니다.")
        return;
    }
    
    const formData = new FormData();
    formData.append("member_id", member_id.value);
    formData.append("itemName", document.getElementById("itemName").value);
    formData.append("entpName", document.getElementById("entpName").value);
    formData.append("efcyQesitm", document.getElementById("efcyQesitm").value);
    formData.append("useMethodQesitm", document.getElementById("useMethodQesitm").value);
    formData.append("atpnWarnQesitm", document.getElementById("atpnWarnQesitm").value);
    formData.append("atpnQesitm", document.getElementById("atpnQesitm").value);
    formData.append("intrcQesitm", document.getElementById("intrcQesitm").value);
    formData.append("seQesitm", document.getElementById("seQesitm").value);
    formData.append("depositMethodQesitm", document.getElementById("depositMethodQesitm").value);
    formData.append("itemImage", document.getElementById("itemImage").value);

    btn_add.disabled=true;
    console.log(member_id.value);

    $.ajax({
        type: "POST",
        url: "/medicine/detail.do",
        data: formData,
        enctype: "multipart/form-data",
        processData: false,
        contentType: false,
        success: function(data) {
            alert("등록이 완료되었습니다");
        },
        error: function(error) {
            btn_add.disabled=false;
            alert("등록 실패: " + JSON.stringify(error.responseJSON));
        },
    });
})
