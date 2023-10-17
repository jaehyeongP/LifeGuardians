function moveToPage(e){
    let hpid = $(e).parent().parent().find('#modal_hpid').val();
    console.log(hpid);

    $.ajax({
        type:"GET",
        url:"/reservation/reserve.do?hpid=" + hpid,
        data: {"hpid": hpid},

        success: function (data){
            console.log("success");
        },
        error:function (error){

        }
    })


}