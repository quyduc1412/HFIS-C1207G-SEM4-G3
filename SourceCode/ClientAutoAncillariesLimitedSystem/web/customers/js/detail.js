/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('.images-product').on('click',function (e){
        var image = $(this).prop('src');
        $('#currentimage').prop('src',image);
        $('#currentimage').fadeIn();
    });
});

