
$(document).ready(function() {
    var _service = Service();
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
        var data = new Item();
        data.set('name', name);
        data.set('description', desciption);
        data.set('category', category);
        data.set('price', price);
        alert(data.toJsonString());
        var onInsertSuccess = function(result) {
            if(result.code === 400){
                location.reload();
            }
        };
        _service.call('insertItem',data.toJsonString(),onInsertSuccess);
    });
    $('#overlay .cancel').on('click', function(e) {
        e.preventDefault();
        $('#overlay').fadeOut();
    });
});