/**
 * @author DeweyLiu
 * @version 1.0.0
 * @date 2018/12/17 17:02
 */
$(function(){
    $("#selectCityId").change(function(){
        var cityId = $("#selectCityId").val();
        var url = '/report/cityId/'+ cityId;
        window.location.href = url;
    })
});