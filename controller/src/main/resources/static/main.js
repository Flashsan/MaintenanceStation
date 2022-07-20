
$(document).ready(function () {

    //for delete operation
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#removeModalCenter #delRef').attr('href', href);
        $('#removeModalCenter').modal();
    });

});
