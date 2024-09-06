$(document).ready(function() {
    $('#loader').hide();
    $("#submit").on("click", function() {
        $("#submit").prop("disabled", true);
        var name = $("#name").val();
        var address = $("#address").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        var form = $("#form").serialize();
        var data = new FormData($("#form")[0]);
        data.append('name', name);
        data.append('address', address);
        data.append('phone', phone);
        data.append('email', email);


        //alert(data);
        $('#loader').show();
        if (name === "" || file === "" || price === "" || description === ""|| stock === ""|| suppliers === "") {
            $("#submit").prop("disabled", false);
            $('#loader').hide();
            $("#name").css("border-color", "red");
            $("#address").css("border-color", "red");
            $("#phone").css("border-color", "red");
            $("#email").css("border-color", "red");

            $("#error_name").html("Please fill the required field.");
            $("#error_address").html("Please fill the required field.");
            $("#error_phone").html("Please fill the required field.");
            $("#error_email").html("Please fill the required field.");

        } else {
            $("#name").css("border-color", "");
            $("#address").css("border-color", "");
            $("#phone").css("border-color", "");
            $("#email").css("border-color", "");

            $('#error_name').css('opacity', 0);
            $('#error_address').css('opacity', 0);
            $('#error_phone').css('opacity', 0);
            $('#error_email').css('opacity', 0);

            // $.ajax({
            //     type: 'POST',
            //     enctype: 'multipart/form-data',
            //     data: data,
            //     url: "/category/saveCustomersDetails",
            //     processData: false,
            //     contentType: false,
            //     cache: false,
            //     success: function(data, statusText, xhr) {
            //         console.log(xhr.status);
            //         if(xhr.status == "200") {
            //             $('#loader').hide();
            //             $("#form")[0].reset();
            //             $('#success').css('display','block');
            //             $("#error").text("");
            //             $("#success").html("Customers Inserted Succsessfully.");
            //             $('#success').delay(2000).fadeOut('slow');
            //         }
            //     },
            //     error: function(e) {
            //         $('#loader').hide();
            //         $('#error').css('display','block');
            //         $("#error").html("Oops! something went wrong.");
            //         $('#error').delay(5000).fadeOut('slow');
            //         location.reload();
            //     }
            // });
        }
    });
});
