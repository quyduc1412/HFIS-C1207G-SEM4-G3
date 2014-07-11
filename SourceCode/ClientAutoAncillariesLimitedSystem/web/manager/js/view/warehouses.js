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
                'region': 'P5'
            };
        }
    });
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
    var onFillData = function(result) {
        $('#overlay').fadeIn();
        var item = new WareHouses();
        item.parse(result.data_response);
        $('.dialog.additem #id').html(item.get('P0'));
        $('.dialog.additem #name').val(item.get('P1'));
        $('.dialog.additem #address').val(item.get('P2'));
        $('.dialog.additem #phone').val(item.get('P3'));
        $('.dialog.additem #email').val(item.get('P4'));
        $('.dialog.additem #region').val(item.get('P5'));
    };
    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("item_id");
        $("#overlay #context").load("views/dialog_warehouses.html", function() {
            $(document).trigger('DIALOG_WAREHOUSES_LOADED', 2);
            $('.dialog.additem #title-dialog').html('Edit Warehouses');
            $('#overlay').fadeIn();
            var onGetSuccess = function(result) {
                getRegion(onFillData, result);
            };
            _service.call('getwarehousebyid', data, onGetSuccess);
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
    var onLoadRegionSuccess = function(result) {
        var data = "";
        data += "<option value='all'>All</option>";
        var param = getParameterByName("category");
        $.each(result.list, function(index, value) {
            if (param.indexOf(value.id) !== -1) {
                data += "<option value='" + value.id + "' selected>" + value.name + "</option>";
            } else {
                data += "<option value='" + value.id + "'>" + value.name + "</option>";
            }
        });
        $('#filterCategory').html(data);
    };
    _service.call('getRegion', '', onLoadRegionSuccess);
    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        var response = $(this).attr("item_id");
        $("#overlay #context").load("views/confirm_dialog.html", function() {
            $(document).trigger('COMFIRM_LOADED', ['You Want Delete This Warehous ?', response]);
            $('#overlay').fadeIn();
        });
    });

    $(document).on('DIALOG_WAREHOUSES_LOADED', function(event, data_method) {
        $("#form_dialog_warehouses").validationEngine();
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
                $('#overlay').fadeOut();
                $('#message').text(result.data_response);
                $('#message').fadeIn();
                setTimeout(
                        function()
                        {
                            $('#message').fadeOut();
                            if (result.code === 400) {
                                location.reload();
                            }
                        }, 2000);
                if (result.code === 400) {
                }
            };
            var valid = $("#form_dialog_warehouses").validationEngine('validate');
            if (valid === true) {
                if (data_method === 1) {
                    _service.call('addwarehouse', data.toJsonString(), onInsertSuccess);
                } else {
                    _service.call('updatewarehouses', data.toJsonString(), onInsertSuccess);
                }
            } else {
                $("#form_dialog_warehouses").validationEngine();
            }
        });
    });
    $(document).on('COMFIRM_LOADED', function(event, data, item_id) {
        $('.half_w.dialog.confirm h3.title').html(data);
        $('.half_w.dialog.confirm .yes').on('click', function() {
            _service.call('deletewarehouse', item_id, function(result) {
                $('#overlay').fadeOut();
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
            });
        });
        $('.half_w.dialog.confirm .no').on('click', function(e) {
            $('#overlay').fadeOut();
        });
    });
});

