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
    $("#send2").on('click', function(e) {
        e.preventDefault();
        var id = '0';
        var email = $('.register #email3').val();
        var fname = $('.register #fname').val();
        var lname = $('.register #lname').val();
        var password = $('.register #address2').val();
        var re_password = $('.register #address3').val();
        var phone = $('.register #phone').val();
        var gender = $('.register #gender').val();
        var address = $('.register #address1').val();
        var city = $('.register #city').val();
        var country = $('.register #zip').val();
        // var status = $('.dialog.additem #address').val();
        var data = new Customer();
        data.set('id', id);
        data.set('email', email);
        data.set('firstName', fname);
        data.set('lastName', lname);
        data.set('passWord', password);
        data.set('phoneNumber', phone);
        data.set('gender', gender);
        data.set('address', address);
        data.set('city', city);
        data.set('country', country);
        data.set('status', '0');
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
        var valid = $("#register").validationEngine('validate');
        if (valid === true) {
            _service.call('../manager/insertcustomer', data.toJsonString(), onInsertSuccess);
        } else {
            $("#register").validationEngine();
        }
    });

});

