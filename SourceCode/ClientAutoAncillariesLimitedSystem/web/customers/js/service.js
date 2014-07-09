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
    },
    call_normal: function(url, jsonData, onSuccess, onError) {
        $.ajax({
            type: 'POST',
            url: url,
            data: {data_request:jsonData},
            success: function(result) {
                onSuccess(result);
            },
            error: onError
        });
    }
});