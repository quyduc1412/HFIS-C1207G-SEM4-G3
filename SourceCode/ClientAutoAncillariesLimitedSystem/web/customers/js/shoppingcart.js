/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
    var WareHouses = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'name': 'P1',
                'address': 'P2',
                'phone': 'P3',
                'email': 'P4',
                'region': 'P5',
                'region_name': 'P6'
            };
        }
    });
    var ChangePassword = Model.$extend({
        mapping: function() {
            return {
                'currentpassword': 'P0',
                'password': 'P1',
                'newpassword': 'P2'
            };
        }
    });
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
    var onLoadListWHSuccess = function(result) {
        var data = "";
        data += "<option value='0'>Choise A Warehouse</option>";
        $.each(result.list, function(index, value) {
            data += "<option value='" + value.id + "'>" + value.name + "</option>";
        });
        $('#warehouse').html(data);
    };
    _service.call('../manager/getallwarehouses', '', onLoadListWHSuccess);
    var onInsertSuccess = function(result) {
        var data = "";
        var totalprice = 0;
        data += "<h3>Cart</h3>";
        data += "<ul>";
        $.each(result.listCart, function(index, value) {
            var des = value.item.description;
            if (des.length > 30) {
                des = des.substring(0, 29) + "...";
            }
            totalprice += value.item.price * value.quantity;
            data += "<li> <a href='detail?id=" + value.item.id + "' class='figure'><img style='width:50px;height:50px;' src='../upload/" + value.item.thumbnail + "' alt=''></a> <div> <span><a href='blog-single.html'>" + value.item.name + "</a></span> <p>" + des + "</p><p><a>Price :</a>" + value.item.price + "</p><p><a>All Amout</a> " + value.quantity + "</p> </div> </li>";
        });
        data += "<p style='text-align: center;'><a>Total price :" + totalprice + "</a><a href='submitorder'><input type='submit' id='checkOrder' value='Check Order'></a></p>";
        data += "</ul>";
        if (result.listCart.length < 1) {
            data = "";
            data += "<h3>Cart</h3>";
            data += "<a style='width:100%;text-align:center;display: block;'>No item in your cart</a>";
        }
        $('.post').html(data);
    };
    _service.call('inserttocart', '', onInsertSuccess);

    $('#addtocart').on('click', function(e) {
        e.preventDefault();
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
    $('#submit-order2').on('click', function(e) {
        e.preventDefault();
        if ($("select#warehouse").val() !== '0') {
            var data = $("#warehouse").val();
            var onFinished = function(resuilt) {
                if (resuilt.code === 405) {
                    window.location.href = "login.jsp?message=" + resuilt.data_response;
                } else {
                    window.location.href = "historycart";
                }
            };
            _service.call('finishorder', data, onFinished);
        }
    });

    $('select#warehouse').on('change', function(e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        if (valueSelected !== '0') {
            $("#overlay #context").load("views/view_details_warehouse.html", function() {
                $(document).trigger('DETAIL_WAREHOUSES_LOADED', valueSelected);
                $('#overlay').fadeIn();
            });
        }

    });

    $(document).on('DETAIL_WAREHOUSES_LOADED', function(event, data) {
        var onGetSuccess = function(result) {
            var item = new WareHouses();
            item.parse(result.data_response);
            $('#details-warehouse td#name-warehouse').html(item.get('P1'));
            $('#details-warehouse td#address-warehouse').html(item.get('P2'));
            $('#details-warehouse td#name-phone').html(item.get('P3'));
            $('#details-warehouse td#name-email').html(item.get('P4'));
            $('#details-warehouse td#name-region').html(item.get('P6'));
        };
        _service.call('../manager/getwarehousebyid', data, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });


    $('.clickchangepassword').on('click', function(e) {
        e.preventDefault();
        $("#overlay #context").load("views/view_change_pass.html", function() {
            $(document).trigger('DIALOG_CHANGEPASSSWORD_LOADED');
        });
    });
    $(document).on('DIALOG_CHANGEPASSSWORD_LOADED', function(event) {
        $('#overlay').fadeIn();
        var onChangeSuccess = function(result) {
            $('#message').text(result.data_response);
            $('#message').fadeIn();
            setTimeout(
                    function()
                    {
                        $('#message').fadeOut();
                        if (result.code === 400) {
                            location.reload();
                        }
                    }, 3000);
        };
        $('#commit-change-password').on('click', function(e) {
            e.preventDefault();
            var currentpass = $('#currentpass').val();
            var password = $('#newpass').val();
            var confirmpass = $('#cofirmpass').val();
            var item = new ChangePassword();
            item.set('currentpassword', currentpass);
            item.set('password', password);
            item.set('newpassword', confirmpass);
            _service.call('changepassword', item.toJsonString(), onChangeSuccess);
        });
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });
});

