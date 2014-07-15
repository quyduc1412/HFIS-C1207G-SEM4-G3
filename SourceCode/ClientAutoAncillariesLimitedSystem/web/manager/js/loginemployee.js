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
        alert(result.code);
        if (result.code === 400) {
            window.location = 'managerorder';
        } else if (result.code === 401) {
            window.location = 'item';
        } else {
            $('#message').text(result.data_response);
            $('#message').fadeIn();
            setTimeout(
                    function()
                    {
                        $('#message').fadeOut();
                        if (result.code === 400) {
                            location.reload();
                        }
                    }, 1000);
        }
    };
    $('#submit-login').on('click', function(e) {
        e.preventDefault();
        var data = new Login();
        data.set('email', $('#login').val());
        data.set('password', $('#pass').val());
        _service.call('loginemployee', data.toJsonString(), onLoginSuccess);
    });


    $("#send2").on('click', function(e) {
        e.preventDefault();
        var data = new Login();
        data.set('email', $('#email3').val());
        data.set('password', $('#address2').val());
        _service.call('logincustomer', data.toJsonString(), onLoginSuccess);
    });

});

