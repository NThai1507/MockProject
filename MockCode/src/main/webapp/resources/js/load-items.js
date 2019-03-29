
$(document).ready(function () {
    console.log('Insile add we are hidden');
    $("#types").change(function () { 
        if ($(this).val() =='table-item') {
            $('.tables').removeClass('off');
            $('.charts').addClass('off');
        }
        if ($(this).val() == 'chart-item') {
            $('.charts').removeClass('off');
            $('.tables').addClass('off');
        }
        console.log('Insile add we are hidden');
    });
    $("#types").val("chart-item").change();
    
    
});

