function moveToPage(e){
    let hpid = $(e).parent().parent().find('#modal_hpid').val();
    // js에서 session 으로 member_id받아오기?

    $.ajax({
        type:"GET",
        url:"/reservation/reserve.do",
        dataType: "JSON",
        data: {"hpid": hpid},

        success: function (jsonData){
            localStorage.setItem("responseJSON", JSON.stringify(jsonData));
            console.log(hpid);
            // localStorage.setItem("resultmember", JSON.stringify(jsonData));
            // console.log("2");
            window.location.href = "/reservation/reservepage.do";

        },
        error:function (error){
            console.log("error");
        }
    })


}