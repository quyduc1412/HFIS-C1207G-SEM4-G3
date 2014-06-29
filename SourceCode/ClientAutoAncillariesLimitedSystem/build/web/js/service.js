var Service = Class.$extend({
  call: function(url, jsonData, onSuccess, onError) {
    $.ajax({
      type: 'POST',    
      url: url,
      data: jsonData,
      crossDomain: true,          
      cache: false, 
      success: function(result) {
            onSuccess(result);  
      },
      error: onError
    });
  }
});