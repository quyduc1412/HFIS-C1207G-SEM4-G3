
$(document).ready(function() {
    var Item = Model.$extend({
        mapping: function() {
            return {
                'name': 'P0',
                'category': 'P1',
                'description': 'P2',
                'price': 'P3',
            }
        }
    });
    $('a.add').on('click', function(e) {
        e.preventDefault();
        var _service = Service();
        var onGetListSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<option value='" + value.id + "'>" + value.nameType + "</option>";
            });
            $('#category').html(data);
        }
        _service.call('getcategory', '', onGetListSuccess);
        $('#overlay').fadeIn();
    });
    $('.dialog.additem .add').on('click', function(e) {
        e.preventDefault();
        var name = $('.dialog.additem #name').val();
        var category = $('.dialog.additem #category').val();
        var desciption = $('.dialog.additem #desciption').val();
        var price = $('.dialog.additem #price').val();
        var item = new Item();
        item.set('name', name);
        item.set('description', desciption);
        item.set('category', category);
        item.set('price', price);
        $('.dialog.additem #desciption').html(JSON.stringify(item));
        alert(JSON.stringify(item));
    });
    $('#overlay .cancel').on('click', function(e) {
        e.preventDefault();
        $('#overlay').fadeOut();
    });
});