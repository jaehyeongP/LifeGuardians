function moveToPage(e){
    let hpid = $(e).parent().parent().find('#modal_hpid').val();

    $.ajax({
        type:"GET",
        url:"/reservation/reserve.do",
        dataType: "JSON",
        data: {"hpid": hpid},

        success: function (jsonData){
            localStorage.setItem("hospital", JSON.stringify(jsonData));
            console.log(hpid);
            window.location.href = "/reservation/reservepage.do";

        },
        error:function (error){
            console.log("error");
        }
    })


}