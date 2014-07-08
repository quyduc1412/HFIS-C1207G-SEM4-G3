/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
    var LoginModel = Model.$extend({
        mapping: function() {
            return {
                'user': 'P0',
                'pass': 'P1'
            };
        }
    });
    $('#submit-login').on('click', function(e) {
        e.preventDefault();
        var user = $('#login').val();
        var pass = $('#pass').val();
        var login = new LoginModel();
        login.set('user',user);
        login.set('pass',pass);
        alert(login.toJsonString());
    });
});


