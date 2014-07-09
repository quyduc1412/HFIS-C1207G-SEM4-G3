/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
//    var Employee = Model.$extend({
//        mapping: function() {
//            return {
//                'id': 'P0',
//                'wareHouses': 'P1',
//                'email': 'P2',
//                'password': 'P3',
//                'name': 'P4',
//                'address': 'P5',
//                'phone': 'P6'
//            };
//        }
//    });

    var onLoadListWHSuccess = function(result) {
        var data = "";
        $.each(result.list, function(index, value) {
            data += "<option value='" + value.id + "'>" + value.name + "</option>";
        });
        $('#warehouse').html(data);
    };
    _service.call('../manager/getallwarehouses', '', onLoadListWHSuccess);
    var onInsertSuccess = function(result) {
        var data = "";
        data += "<h3>Cart</h3>";
        data += "<ul>";
        $.each(result.listCart, function(index, value) {
            var des = value.item.description;
            if (des.length > 30) {
                des = des.substring(0, 29) + "...";
            }
            data += "<li> <a href='detail?id=" + value.item.id + "' class='figure'><img style='width:50px;height:50px;' src='../upload/" + value.item.thumbnail + "' alt=''></a> <div> <span><a href='blog-single.html'>" + value.item.name + "</a></span> <p>" + des + "</p><a>Price :</a>" + value.item.price + " </div> </li>";
        });
        data += "<br/><a href='submitorder'><input type='submit' id='checkOrder' value='Check Order'></a>";
        data += "</ul>";
        if (result.listCart.length < 1) {
            data = "";
            data += "<h3>Cart</h3>";
            data += "<a style='width:100%;text-align:center;display: block;'>No item in your cart</a>";
        }
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
            data += "<h3>Cart</h3>";
            data += "<ul>";
            var param = getParameterByName("category");
            $.each(result.listCart, function(index, value) {
                var des = value.item.description;
                if (des.length > 30) {
                    des = des.substring(0, 29) + "...";
                }
                data += "<li> <a href='detail?id=" + value.item.id + "' class='figure'><img style='width:50px;height:50px;' src='../upload/" + value.item.thumbnail + "' alt=''></a> <div> <span><a href='blog-single.html'>" + value.item.name + "</a></span> <p>" + des + "</p><a>Price :</a>" + value.item.price + " </div> </li>";
            });
            data += "<br/><a href='submitorder'><input type='submit' id='checkOrder' value='Check Order'></a>";
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

