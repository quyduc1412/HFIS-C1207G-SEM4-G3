
$(document).ready(function() {
    var action = 1;
    var _service = Service();
    var Item = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'name': 'P1',
                'category': 'P2',
                'description': 'P3',
                'price': 'P4',
                'date_Created': 'P5'
            }
        }
    });
    var getTypeItem = function(after) {
        var onGetListSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<option value='" + value.id + "'>" + value.nameType + "</option>";
            });
            $('#category').html(data);
            after();
        };
        _service.call('getcategory', '', onGetListSuccess);
    };
    $('a.add').on('click', function(e) {
        e.preventDefault();
        getTypeItem();
        $('#overlay').fadeIn();
        action = 1;
    });
    $('.dialog.additem .add').on('click', function(e) {
        e.preventDefault();
        var id = $('.dialog.additem #id').val();
        var name = $('.dialog.additem #name').val();
        var category = $('.dialog.additem #category').val();
        var desciption = $('.dialog.additem #desciption').val();
        var price = $('.dialog.additem #price').val();
        var data = new Item();
        data.set('id', id);
        data.set('name', name);
        data.set('description', desciption);
        data.set('category', category);
        data.set('price', price);
        alert(data.toJsonString());
        var onInsertSuccess = function(result) {
            $('#overlay').fadeOut();
            $('#message').text('SUCCESS');
            $('#message').fadeIn();
            setTimeout(
                    function()
                    {
                        $('#message').fadeOut()
                    }, 5000);
            if (result.code === 400) {
            }
        };
        alert(action);
        if(action === 1){
            _service.call('insertItem', data.toJsonString(), onInsertSuccess);
        }else{
            _service.call('updateItem', data.toJsonString(), onInsertSuccess);
        }
    });
    $('#overlay .cancel').on('click', function(e) {
        e.preventDefault();
        $('#overlay').fadeOut();
    });
    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        _service.call('deleteItem', $(this).attr("item_id"));
    });


   
    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        action = 2;
         var onFillData = function (result){
            $('#overlay').fadeIn();
            var item = new Item();
            item.parse(result.data_response);
            alert(item.get('P0'));
            $('.dialog.additem #id').html(item.get('P0'));
            $('.dialog.additem #name').val(item.get('P1'));
            $('.dialog.additem #category').val(item.get('P2'));
            $('.dialog.additem #desciption').val(item.get('P3'));
            $('.dialog.additem #price').val(item.get('P4'));
        };
        var onGetSuccess = function(result) {
            getTypeItem(onFillData(result));
        };
        alert('click');
        _service.call('getItemByID',$(this).attr("item_id"),onGetSuccess);
    });
});