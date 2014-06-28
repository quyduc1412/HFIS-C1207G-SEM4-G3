
$(document).ready(function() {
    var Reponse = Model.$extend({
        mapping: function() {
            return {
                'code': 'code',
                'message': 'message',
            }
        }
    });
});