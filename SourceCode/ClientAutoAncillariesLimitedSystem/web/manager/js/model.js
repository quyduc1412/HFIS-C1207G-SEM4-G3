var Model = Class.$extend({
  __data: {},
  __init__ : function() {
    this.__data = {};
  },
  __classvars__ : {
    Session : {
      removeAll: function() {
        localStorage.clear();
      },
      setValue: function(key, value) {
        // we will follow up this cookie value to clear localStorage
        $.cookie("Session", 1);

        localStorage.setItem(key, value);
      },
      getValue: function (key) {
        if ($.cookie("Session") != 1) {
          localStorage.clear();
        }
        var value = localStorage.getItem(key);
        return value;
      }
    }
  },
  isMapped: function() {
    if (this.mapping()) {
      return true;
    } 
    return false;
  },
  toJsonString: function() {
    if (this.isMapped()) {
      var object = this.getModelObject();
      return JSON.stringify(object);
    } else {
      console.log(this.clazz + ' is not mapped.');
    }
  },
  toFriendlyString: function() {
    if (this.isMapped()) {
      var object = this.getFriendlyObject();
      return JSON.stringify(object);
    } else {
      console.log(this.clazz + ' is not mapped.');
    }
  },
  parse: function(data) {
    var json = data;
    if ($.type(data) === 'string') {
      json = $.parseJSON(data);  
    }
    
    if (json) {
      var mapping = this.mapping();
      for (var key in mapping) {
        var pair = mapping[key];
        this.__data[key] = this.__data[pair] = json[pair];
      }      
    } else {
      console.log(this.clazz + ' can not parse data to JSON.');
    }
  },
  set: function(key, value) {
    this.__data[key] = value;
  },
  get: function(key) {
    return this.__data[key];
  },
  getModelObject: function() {
    if (this.isMapped()) {
      var json = {};
      var mapping = this.mapping();
      for (var key in mapping) {
        var pair = mapping[key];
        var value = this.__data[key];
        if (value) {
          if (value.isMapped) {
            json[pair] = value.getModelObject();
          } else {
            json[pair] = value;    
          }
        }
      }
      return json;
    }
    return null;
  },
  getFriendlyObject: function() {
    if (this.isMapped()) {
      var friendly = {};
      var mapping = this.mapping();
      for (var key in mapping) {
        var pair = mapping[key];
        var value = this.__data[key];
        if (value) {
          if (value.isMapped) {
            friendly[key] = value.getFriendlyObject();    
          } else {
            friendly[key] = value;    
          }
        }
      }
      return friendly;
    }
    return null;
  },
  getCredentials: function() {
    var kcred = Model.Session.getValue('Credentials');
    if (kcred) {
      var credentials = $.parseJSON(kcred);
      if (credentials) {
        return credentials;
      }
    }
    return KCred().getDefaultObject();
  },
  saveCredentials: function(kcred) {
    if (kcred) {
      Model.Session.setValue('Credentials', JSON.stringify(kcred));
    }
  }
});