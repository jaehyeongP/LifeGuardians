jQuery.datetimepicker.setLocale('ko');

jQuery('#datetimepicker').datetimepicker({
    changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
    format:'Y-m-d H:i',
    step: 30,
    defaultSelect: false,
    defaultDate: false,
    minDate:0,
    // maxDate:-90,
    minTime: '09:00',
    maxTime: '18:00',
    // yearEnd: '2023',
    closeOnDateSelect: 0,
    closeOnWithoutClick: true,
    disabledWeekDays:[0,6],

});

// let selectDate = $("#dateStart").datetimepicker("getDate");
// selectDate 한 값을 front에 뿌려주고,

// jQuery("#dateStart").click(function (){
//     jQuery("#datetimepicker").datetimepicker('show');
// });

