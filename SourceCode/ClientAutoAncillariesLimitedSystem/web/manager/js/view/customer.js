/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
    var Customer = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'email': 'P1',
                'firstName': 'P2',
                'lastName': 'P3',
                'passWord': 'P4',
                'phoneNumber': 'P5',
                'gender': 'P6',
                'address': 'P7',
                'city': 'P8',
                'country': 'P9',
                'status': 'P10'
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
        var item = new Customer();
        item.parse(result.data_response);
        $('.dialog.additem #id').html(item.get('P0'));
        $('.dialog.additem #email').val(item.get('P1'));
        $('.dialog.additem #first-name').val(item.get('P2'));
        $('.dialog.additem #last-name').val(item.get('P3'));
        $('.dialog.additem #password').val(item.get('P4'));
        $('.dialog.additem #re-password').val(item.get('P4'));
        $('.dialog.additem #phone').val(item.get('P5'));
        $('.dialog.additem #gender').val(item.get('P6'));
        $('.dialog.additem #address').val(item.get('P7'));
        $('.dialog.additem #city').val(item.get('P8'));
        $('.dialog.additem #country').val(item.get('P9'));
       // $('.dialog.additem #gender').val(item.get('P10'));
    };
    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("item_id");
        $("#overlay #context").load("views/dialog_customer.html", function() {
            $(document).trigger('DIALOG_CUSTOMER_LOADED', 2);
            $('.dialog.additem #title-dialog').html('Edit Employee');
            $('#overlay').fadeIn();
            var onGetSuccess = function(result) {
                onFillData(result);
            };
            _service.call('getcustomerbyid', data, onGetSuccess);
        });
    });
    $('#main a.add').on('click', function(e) {
        e.preventDefault();
        $("#overlay #context").load("views/dialog_customer.html", function() {
            $(document).trigger('DIALOG_CUSTOMER_LOADED', 1);
            $('.dialog.additem #title-dialog').html('Add Customer');
            $('#overlay').fadeIn();
        });
    });
    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        var response = $(this).attr("item_id");
        $("#overlay #context").load("views/confirm_dialog.html", function() {
            $(document).trigger('COMFIRM_LOADED', ['You Want Delete This Customer ?', response]);
            $('#overlay').fadeIn();
        });
    });

    $(document).on('DIALOG_CUSTOMER_LOADED', function(event, data_method) {
        $("#form_dialog_customer").validationEngine();
        $('#overlay .cancel').on('click', function(e) {
            e.preventDefault();
            $('#overlay').fadeOut();
        });
        $('.dialog.additem .add').on('click', function(e) {
            e.preventDefault();
            var id = $('.dialog.additem #id').html();
            var email = $('.dialog.additem #email').val();
            var fname = $('.dialog.additem #first-name').val();
            var lname = $('.dialog.additem #last-name').val();
            var password = $('.dialog.additem #password').val();
            var re_password = $('.dialog.additem #re-password').val();
            var phone = $('.dialog.additem #phone').val();
            var gender = $('.dialog.additem #gender').val();
            var address = $('.dialog.additem #address').val();
            var city = $('.dialog.additem #city').val();
            var country = $('.dialog.additem #country').val();
           // var status = $('.dialog.additem #address').val();
            var data = new Customer();
            if (id === '') {
                data.set('id', '0');
            } else {
                data.set('id', id);
            }
            data.set('email', email);
            data.set('firstName', fname);
            data.set('lastName', lname);
            data.set('passWord', password);
            data.set('phoneNumber', phone);
            data.set('gender', gender);
            data.set('address', address);
            data.set('city', city);
            data.set('country', country);
            data.set('status','0');
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
            var valid = $("#form_dialog_customer").validationEngine('validate');
            if (valid === true) {
                alert(data.toJsonString());
                if (data_method === 1) {
                    _service.call('insertcustomer', data.toJsonString(), onInsertSuccess);
                } else {
                    _service.call('updatecustomer', data.toJsonString(), onInsertSuccess);
                }
            } else {
                $("#form_dialog_customer").validationEngine();
            }
        });
    });
    $(document).on('COMFIRM_LOADED', function(event, data, item_id) {
        $('.half_w.dialog.confirm h3.title').html(data);
        $('.half_w.dialog.confirm .yes').on('click', function() {
            _service.call('deletecustomer', item_id, function(result) {
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

