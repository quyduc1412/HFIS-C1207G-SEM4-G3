/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();

    var Login = Model.$extend({
        mapping: function() {
            return {
                'email': 'P0',
                'password': 'P1'
            };
        }
    });
    var onLoginSuccess = function(result) {
        if(result.code === 400){
            window.location = 'home'
        }else{
            $('#error-login').text(result.data_response);
        }
    };
    $('#submit-login').on('click', function(e) {
        e.preventDefault();
        var data = new Login();
        data.set('email', $('#user').val());
        data.set('password', $('#pass').val());
        _service.call('logincustomer', data.toJsonString(), onLoginSuccess);
    });

    
    _service.call('../manager/getallwarehouses', '', onLoadListWHSuccess);
    var onInsertSuccess = function(result) {
        var data = "";
        data += "<h3>Cart</h3>";
        data += "<ul>";
        var param = getParameterByName("category");
        $.each(result.listCart, function(index, value) {
            data += "<li> <a href='detail?id=" + value.item.id + "' class='figure'><img style='width:50px;height:50px;' src='../upload/" + value.item.thumbnail + "' alt=''></a> <div> <span><a href='blog-single.html'>" + value.item.name + "</a></span> <p>" + value.item.description + "</p><a>Price :</a>" + value.item.price + " </div> </li>";
        });
        data += "</ul>";
        $('.post').html(data);
    };
    _service.call('inserttocart', '', onInsertSuccess);
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
    $('#addtocart').on('click', function(e) {
        e.preventDefault();
        var onInsertSuccess = function(result) {
            var data = "";
            data += "<ul>";
            var param = getParameterByName("category");
            $.each(result.listCart, function(index, value) {
                data += "<li> <a href='detail?id=" + value.item.id + "' class='figure'><img style='width:50px;height:50px;' src='../upload/" + value.item.thumbnail + "' alt=''></a> <div> <span><a href='blog-single.html'>" + value.item.name + "</a></span> <p>" + value.item.description + "</p><a>Price :</a>" + value.item.price + " </div> </li>";
            });
            data += "</ul>";
            $('.post').html(data);
        };
        var id = getParameterByName("id");
        _service.call('inserttocart', id, onInsertSuccess);
    });
    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        var onInsertSuccess = function(result) {
            if (result.code === 400) {
                location.reload();
            } else {
                $('#message').text(result.data_response);
                $('#message').fadeIn();
                setTimeout(
                        function()
                        {
                            $('#message').fadeOut();
                        }, 3000);
            }
        };
        var response = $(this).attr("item_id");
        _service.call('removecart', response, onInsertSuccess);
    });
});

