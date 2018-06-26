$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {
   var name = $("#language").val();
    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8;',
        url: "/api/search",
        data: name,
        dataType: 'text',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	data = eval("(" + data + ")");
            var json = "<h4>Rooster Sounds</h4><pre>"
            	+data.sounds + " in " +data.nativelang+ "</pre>";
            $('#feedback').html(json);
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
       error: function (e) {

            var json = "<h4>Error Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}