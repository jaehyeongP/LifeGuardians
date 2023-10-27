function moveToPage(e){
    let hpid = $(e).parent().parent().find('#modal_hpid').val();

    $.ajax({
        type:"GET",
        url:"/hospital/reservation/reserve.do",
        dataType: "JSON",
        data: {"hpid": hpid},

        success: function (jsonData){
            localStorage.setItem("responseJSON", JSON.stringify(jsonData));
            window.location.href = "/hospital/reservation/reservepage.do";

        },
        error:function (error){
        }
    })


}