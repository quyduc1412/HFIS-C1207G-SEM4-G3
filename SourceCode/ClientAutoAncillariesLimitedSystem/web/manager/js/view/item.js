
$(document).ready(function() {
    var _service = Service();
    var Item = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'name': 'P1',
                'category': 'P2',
                'description': 'P3',
                'price': 'P4',
                'date_Created': 'P5',
                'images': 'P6'
            };
        }
    });
    $('#message').fadeOut();
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
    var onGetCategorySuccess = function(result) {
        var data = "";
        var param = getParameterByName("category");
        data += "<option value='all'>All</option>";
        $.each(result.list, function(index, value) {
            if (param.indexOf(value.id) !== -1) {
                data += "<option value='" + value.id + "' selected>" + value.nameType + "</option>";
            } else {
                data += "<option value='" + value.id + "'>" + value.nameType + "</option>";
            }
        });
        $('#filterCategory').html(data);
    };
    _service.call('getcategory', '', onGetCategorySuccess);
    var images_data = "";
    var onFillData = function(result) {
        $('#overlay').fadeIn();
        var item = new Item();
        item.parse(result.data_response);
        $('.dialog.additem #id').html(item.get('P0'));
        $('.dialog.additem #name').val(item.get('P1'));
        $('.dialog.additem #category').val(item.get('P2'));
        $('.dialog.additem #desciption').val(item.get('P3'));
        $('.dialog.additem #price').val(item.get('P4'));
        var images = item.get('P6');
        images_data = images;
        var arr_image = images.split(';');
        for (var i = 0; i < arr_image.length; i++) {
            if (arr_image[i] !== '') {
                $('.dialog.additem #images_form').append("<img class='deleteimg' name='" + arr_image[i] + "' src='../upload/" + arr_image[i] + "' alt='' style='width: 20%;float:left;display: inline-block'/>");
            }
        }
        $(document).trigger('RELOAD_IMAGES');
    };
    var getTypeItem = function(after, data2) {
        var onGetListSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<option value='" + value.id + "'>" + value.nameType + "</option>";
            });
            $('#category').html(data);
            after(data2);
        };
        _service.call('getcategory', '', onGetListSuccess);
    };


    $('.table-icon.delete').on('click', function(e) {
        e.preventDefault();
        var response = $(this).attr("item_id");
        $("#overlay #context").load("views/confirm_dialog.html", function() {
            $(document).trigger('COMFIRM_LOADED', ['You Want Delete This Item ?', response]);
            $('#overlay').fadeIn();
        });
    });

    $('.table-icon.edit').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("item_id");
        $("#overlay #context").load("views/dialog_item.html", function() {
            $(document).trigger('DIALOG_ITEM_LOADED', 2);
            $('.dialog.additem #title-dialog').html('Edit Item');
            var onGetSuccess = function(result) {
                getTypeItem(onFillData, result);
            };
            _service.call('getItemByID', data, onGetSuccess);
        });
    });

    $('#main a.add').on('click', function(e) {
        e.preventDefault();
        $("#overlay #context").load("views/dialog_item.html", function() {
            $(document).trigger('DIALOG_ITEM_LOADED', 1);
            $('.dialog.additem #title-dialog').html('Add Item');
            getTypeItem();
            $('#overlay').fadeIn();
        });

    });
    $(document).on('DIALOG_ITEM_LOADED', function(event, data_method) {
        $("#form_dialog_item").validationEngine();
        if (data_method === 1) {
            images_data = "";
        }
        $('#overlay .cancel').on('click', function(e) {
            e.preventDefault();
            $('#overlay').fadeOut();
        });
        $("#fileuploader").uploadFile({
            url: "uploadFile",
//            formData: {"name":"Ravi","age":31},
            allowedTypes: "png,gif,jpg,jpeg",
            fileName: "myfile",
            onSuccess: function(files, data, xhr)
            {
                $('.dialog.additem #images_form').append("<img class='deleteimg' name='" + data.myfileFileName + "' src='../upload/" + data.myfileFileName + "' alt='' style='width: 20%;float:left;display: inline-block'/>");
                images_data += data.myfileFileName + ";";
                $(document).trigger('RELOAD_IMAGES');
            }
        });
        $('.dialog.additem .add').on('click', function(e) {
            e.preventDefault();

            var id = $('.dialog.additem #id').html();
            var name = $('.dialog.additem #name').val();
            var category = $('.dialog.additem #category').val();
            var desciption = $('.dialog.additem #desciption').val();
            var price = $('.dialog.additem #price').val();
            var data = new Item();
            if (id === '') {
                data.set('id', '0');
            } else {
                data.set('id', id);
            }
            data.set('name', name);
            data.set('description', desciption);
            data.set('category', category);
            data.set('price', price);
            data.set('images', images_data);
            var onInsertSuccess = function(result) {
                if (result.code === 400) {
                    $('#overlay').fadeOut();
                }
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

            var valid = $("#form_dialog_item").validationEngine('validate');
            if (valid === true) {
                if (data_method === 1) {
                    _service.call('insertItem', data.toJsonString(), onInsertSuccess);
                } else {
                    _service.call('updateItem', data.toJsonString(), onInsertSuccess);
                }
            }else{
                $("#form_dialog_item").validationEngine();
            }
        });
    });
    $(document).on('COMFIRM_LOADED', function(event, data, item_id) {
        $('.half_w.dialog.confirm h3.title').html(data);
        $('.half_w.dialog.confirm .yes').on('click', function(e) {
            _service.call('deleteItem', item_id, function(result) {
                if (result.code === 400) {
                    $('#overlay').fadeOut();
                }
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


    $(document).on('RELOAD_IMAGES', function(e) {
        $('.deleteimg').on('click', function(e) {
            var filename_delete = $(this).attr("name");
            var DeleteRequest = Model.$extend({
                mapping: function() {
                    return {
                        'id': 'P0',
                        'filename': 'P1'
                    };
                }
            });
            var data = new DeleteRequest();
            data.set('filename', filename_delete);
            data.set('id', $('.dialog.additem #id').html());
            _service.call_normal('deleteFile', data.toJsonString(), function(data) {
                images_data = images_data.replace(data.data_response, "");
                var arr_image = images_data.split(';');
                $('.dialog.additem #images_form').html("");
                for (var i = 0; i < arr_image.length; i++) {
                    if (arr_image[i] !== '') {
                        $('.dialog.additem #images_form').append("<img class='deleteimg' name='" + arr_image[i] + "' src='../upload/" + arr_image[i] + "' alt='' style='width: 20%;float:left;display: inline-block'/>");
                    }
                }
                $(document).trigger('RELOAD_IMAGES');
            });
        });
    });
});