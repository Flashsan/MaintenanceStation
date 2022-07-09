/**
 *
 */

$(document).ready(function () {

    //for delete workList
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#removeModalCenter #delRef').attr('href', href);
        $('#removeModalCenter').modal();
    });


    // $('.nBtn, .table .eBtn').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     var text = $(this).text();
    //
    //     //for update user
    //     if (text == 'Edit') {
    //         $.get(href, function (workListDto, status) {
    //             $('.myFormEdit #workListId').val(workListDto.workListId);
    //             $('.myFormEdit #workListName').val(workListDto.workListName);
    //             $('.myFormEdit #workListCoast').val(workListDto.workListCoast);
    //             // $('.myFormEdit #mechanic').val(workListDto.mechanic);
    //         });
    //         $('.myFormUpdate #modalEditWorkList').modal();
    //         //for creating workList
    //     } else {
    //         $('.myFormCreate #workListName').val('');
    //         $('.myFormCreate #workListCoast').val('');
    //         $('.createWorkList #mechanic').val('');
    //         $('.myFormCreate #modalCreateWorkList').modal();
    //     }
    // });


});
