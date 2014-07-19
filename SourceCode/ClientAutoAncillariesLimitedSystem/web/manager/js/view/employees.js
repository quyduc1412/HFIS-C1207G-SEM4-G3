/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
    var Employee = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'wareHouses': 'P1',
                'email': 'P2',
                'password': 'P3',
                'name': 'P4',
                'address': 'P5',
                'phone': 'P6'
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
        var item = new Employee();
        item.parse(result.data_response);
        $('.dialog.additem #id').html(item.get('P0'));
        $('.dialog.additem #warehouse').val(item.get('P1'));
        $('.dialog.additem #email').val(item.get('P2'));
        $('.dialog.additem #password').val(item.get('P3'));
        $('.dialog.additem #re-password').val(item.get('P3'));
        $('.dialog.additem #name').val(item.get('P4'));
        $('.dialog.additem #address').val(item.get('P5'));
        $('.dialog.additem #phone').val(item.get('P6'));
    };
    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("item_id");
        $("#overlay #context").load("views/dialog_employee.html", function() {
            $(document).trigger('DIALOG_EMPLOYEE_LOADED', 2);
            $('.dialog.additem #title-dialog').html('Edit Employee');
            $('#overlay').fadeIn();
            var onGetSuccess = function(result) {
                getWareHouses(onFillData, result);
            };
            _service.call('getemployeebyid', data, onGetSuccess);
        });
    });
    $('#main a.add').on('click', function(e) {
        e.preventDefault();
        $("#overlay #context").load("views/dialog_employee.html", function() {
            $(document).trigger('DIALOG_EMPLOYEE_LOADED', 1);
            $('.dialog.additem #title-dialog').html('Add Employee');
            $('#overlay').fadeIn();
            getWareHouses();
        });
    });
    var onLoadListWHSuccess = function(result) {
        var data = "";
        data += "<option value='all'>All</option>";
        var param = getParameterByName("category");
        $.each(result.list, function(index, value) {
            if (param.indexOf(value.id) !== -1) {
                data += "<option value='" + value.id + "' selected>" + value.name + "</option>";
            }else{
                data += "<option value='" + value.id + "'>" + value.name + "</option>";
            }
        });
        $('#filterCategory').html(data);
    };
    _service.call('getallwarehouses', '', onLoadListWHSuccess);
    var getWareHouses = function(after, data2) {
        var onGetListSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<option value='" + value.id + "'>" + value.name + "</option>";
            });
            $('#warehouse').html(data);
            after(data2);
        };
        _service.call('getallwarehouses', '', onGetListSuccess);
    };

    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        var response = $(this).attr("item_id");
        $("#overlay #context").load("views/confirm_dialog.html", function() {
            $(document).trigger('COMFIRM_LOADED', ['You Want Delete This Employee ?', response]);
            $('#overlay').fadeIn();
        });
    });

    $(document).on('DIALOG_EMPLOYEE_LOADED', function(event, data_method) {
        $("#form_dialog_employee").validationEngine();
        $('#overlay .cancel').on('click', function(e) {
            e.preventDefault();
            $('#overlay').fadeOut();
        });
        $('.dialog.additem .add').on('click', function(e) {
            e.preventDefault();
            var id = $('.dialog.additem #id').html();
            var wareHouses = $('.dialog.additem #warehouse').val();
            var email = $('.dialog.additem #email').val();
            var name = $('.dialog.additem #name').val();
            var address = $('.dialog.additem #address').val();
            var phone = $('.dialog.additem #phone').val();
            var password = $('.dialog.additem #password').val();
            var re_password = $('.dialog.additem #re-password').val();
            var data = new Employee();
            if (id === '') {
                data.set('id', '0');
            } else {
                data.set('id', id);
            }
            data.set('wareHouses', wareHouses);
            data.set('email', email);
            data.set('password', password);
            data.set('name', name);
            data.set('address', address);
            data.set('phone', phone);
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
                        }, 3000);
                if (result.code === 400) {
                }
            };
            var valid = $("#form_dialog_employee").validationEngine('validate');
            if (valid === true) {
                if (data_method === 1) {
                    _service.call('insertemployee', data.toJsonString(), onInsertSuccess);
                } else {
                    _service.call('updateemployee', data.toJsonString(), onInsertSuccess);
                }
            } else {
                $("#form_dialog_employee").validationEngine();
            }
        });
    });
    $(document).on('COMFIRM_LOADED', function(event, data, item_id) {
        $('.half_w.dialog.confirm h3.title').html(data);
        $('.half_w.dialog.confirm .yes').on('click', function() {
            _service.call('deleteemployee', item_id, function(result) {
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

