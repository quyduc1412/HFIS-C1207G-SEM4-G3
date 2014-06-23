var Service = Class.$extend({
    call: function(url, jsonData, onSuccess, onError) {
        $.ajax({
            type: 'POST',
            url: url,
            data: {data_request:jsonData},
            dataType: 'json',
            success: function(result) {
                onSuccess(result);
            },
            error: onError
        });
    }
});