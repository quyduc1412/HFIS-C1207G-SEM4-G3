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
    $('#update-profile').on('click', function(e) {
        e.preventDefault();
        var idprofile = $('#id-profile').html();
        var fName = $('#fname').val();
        var lName = $('#lname').val();
        var gender = $('#gender').val();
        var phone = $('#phone').val();
        var address = $('#address').val();
        var city = $('#city').val();
        var country = $('#country').val();
        var data = new Customer();
        data.set('id', idprofile);
        data.set('firstName', fName);
        data.set('lastName', lName);
        data.set('phoneNumber', phone);
        data.set('gender', gender);
        data.set('address', address);
        data.set('city', city);
        data.set('country', country);
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
                        }, 2000);
            }
        };
        var valid = $("#form-updateprofile").validationEngine('validate');
        if (valid === true) {
            _service.call('updateprofile', data.toJsonString(), onInsertSuccess);
        } else {
            $("#form-updateprofile").validationEngine();
        }
    });

});

