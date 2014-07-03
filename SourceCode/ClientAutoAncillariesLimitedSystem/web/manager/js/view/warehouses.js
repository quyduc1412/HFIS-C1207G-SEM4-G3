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
                'region' : 'P5'
            };
        }
    });
    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("item_id");
        $("#overlay #context").load("views/dialog_warehouses.html", function() {
            $(document).trigger('DIALOG_WAREHOUSES_LOADED', 2);
            $('.dialog.additem #title-dialog').html('Edit Warehouses');
            $('#overlay').fadeIn();
//            var onGetSuccess = function(result) {
//                getTypeItem(onFillData, result);
//            };
//            _service.call('getItemByID', data, onGetSuccess);
        });
    });
    $('#main a.add').on('click', function(e) {
        e.preventDefault();
        $("#overlay #context").load("views/dialog_warehouses.html", function() {
            $(document).trigger('DIALOG_WAREHOUSES_LOADED', 1);
            $('.dialog.additem #title-dialog').html('Add Item');
            $('#overlay').fadeIn();
            getRegion();
        });

    });
    
    var getRegion = function(after, data2) {
        var onGetListSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<option value='" + value.id + "'>" + value.name + "</option>";
            });
            $('#region').html(data);
            after(data2);
        };
        _service.call('getRegion', '', onGetListSuccess);
    };
    
    $(document).on('DIALOG_WAREHOUSES_LOADED', function(event, data_method) {
//        $("#form_dialog_item").validationEngine();
        $('#overlay .cancel').on('click', function(e) {
            e.preventDefault();
            $('#overlay').fadeOut();
        });
        $('.dialog.additem .add').on('click', function(e) {
            e.preventDefault();
            var id = $('.dialog.additem #id').html();
            var name = $('.dialog.additem #name').val();
            var region = $('.dialog.additem #region').val();
            var phone = $('.dialog.additem #phone').val();
            var address = $('.dialog.additem #address').val();
            var email = $('.dialog.additem #email').val();
            var data = new WareHouses();
            if (id === '') {
                data.set('id', '0');
            } else {
                data.set('id', id);
            }
            data.set('name', name);
            data.set('address', address);
            data.set('region', region);
            data.set('phone', phone);
            data.set('email', email);
            var onInsertSuccess = function(result) {
                if (result.code === 400) {
                    $('#overlay').fadeOut();
                }
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
                if (result.code === 400) {
                }
            };
            alert(data.toJsonString());

            if (data_method === 1) {
                _service.call('addwarehouse', data.toJsonString(), onInsertSuccess);
            } else {
                _service.call('addwarehouse', data.toJsonString(), onInsertSuccess);
            }
        });
    });
});

