/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
    var Customer = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'email': 'P1',
                'firstName': 'P2',
                'lastName': 'P3',
                'passWord': 'P4',
                'phoneNumber': 'P5',
                'gender': 'P6',
                'address': 'P7',
                'city': 'P8',
                'country': 'P9',
                'status': 'P10'
            };
        }
    });
    var onLoadListWHSuccess2 = function(result) {
        var data = "";
        data += "<option value='all'>All</option>";
        $.each(result.list, function(index, value) {
            data += "<option value='" + value.id + "'>" + value.name + "</option>";
        });
        $('#warehouse').html(data);
    };
    _service.call('getallwarehouses', '', onLoadListWHSuccess2);
    var ChangeStatus = Model.$extend({
        mapping: function() {
            return {
                'id_order': 'P0',
                'status': 'P1'
            };
        }
    });
    var WareHouses = Model.$extend({
        mapping: function() {
            return {
                'id': 'P0',
                'name': 'P1',
                'address': 'P2',
                'phone': 'P3',
                'email': 'P4',
                'region': 'P5',
                'region_name': 'P6'
            };
        }
    });
    $('.full-order').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("idcustomer");
        var data2 = $(this).attr("idorder");
        var status = $(this).attr("status");
        $("#overlay #context").load("views/view_details_full_order.html", function() {
            $(document).trigger('DETAIL_FULLORDER_LOADED', [data, data2, status]);
            $('#overlay').fadeIn();
        });
    });
    $('.customer-detail').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("idname");
        $("#overlay #context").load("views/view_details_customer.html", function() {
            $(document).trigger('DETAIL_CUSTOMER_LOADED', data);
            $('#overlay').fadeIn();
        });
    });
    $('.details-order').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("idname");
        $("#overlay #context").load("views/view_details_order.html", function() {
            $(document).trigger('DETAIL_ORDER_LOADED', data);
            $('#overlay').fadeIn();
        });
    });
    $(document).on('DETAIL_ORDER_LOADED', function(event, data_input) {
        var onGetSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                var des = value.item.description;
                if (des.length > 30) {
                    des = des.substring(0, 29) + "...";
                }
                data += "<tr> <td class='align-center'>" + value.item.id + "</td> <td>" + value.item.name + "</td> <td>" + des + "</td> <td>" + value.quantity + "</td> <td class='align-center'>" + value.item.typeItem.nameType + "</td> <td>" + value.item.price + "</td> </tr>";
            });
            $('#body-details').html(data);
        };
        _service.call('../customers/getitemorderbyidpurchase', data_input, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });

    $('.warehouse-details').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("idname");
        $("#overlay #context").load("views/view_details_warehouse.html", function() {
            $(document).trigger('DETAIL_WAREHOUSES_LOADED', data);
            $('#overlay').fadeIn();
        });
    });
    $(document).on('DETAIL_WAREHOUSES_LOADED', function(event, data) {
        var onGetSuccess = function(result) {
            var item = new WareHouses();
            item.parse(result.data_response);
            $('#details-warehouse td#name-warehouse').html(item.get('P1'));
            $('#details-warehouse td#address-warehouse').html(item.get('P2'));
            $('#details-warehouse td#name-phone').html(item.get('P3'));
            $('#details-warehouse td#name-email').html(item.get('P4'));
            $('#details-warehouse td#name-region').html(item.get('P6'));
        };
        _service.call('getwarehousebyid', data, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });
    $(document).on('DETAIL_CUSTOMER_LOADED', function(event, data) {
        var onGetSuccess = function(result) {
            var item = new Customer();
            item.parse(result.data_response);
            $('#details-customer #customer-id').text(item.get('P0'));
            $('#details-customer #customer-email').text(item.get('P1'));
            $('#details-customer #customer-fname').text(item.get('P2'));
            $('#details-customer #customer-lname').text(item.get('P3'));
            $('#details-customer #customer-phone').text(item.get('P5'));
            $('#details-customer #customer-address').text(item.get('P7'));
            $('#details-customer #customer-city').text(item.get('P8'));
            $('#details-customer #customer-country').text(item.get('P9'));
            $('#details-customer #customer-status').text(item.get('P10'));
        };
        _service.call('getcustomerbyid', data, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });
    $(function() {
        $("#datefrom").datepicker();
        $("#dateto").datepicker();
    });
    $('.details-status').on('click', function(e) {
        var data = $(this).attr("idname");
        $("#overlay #context").load("views/dialog_change_status_order.html", function() {
            $(document).trigger('DIALOG_CHANGESTATUS_LOADED', data);
            $('#overlay').fadeIn();
        });
    });

    $(document).on('DETAIL_FULLORDER_LOADED', function(event, data, data2, status) {
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
        var onGetSuccess = function(result) {
            var item = new Customer();
            item.parse(result.data_response);
            $('#details-full-order #customer-id').text(item.get('P0'));
            $('#details-full-order #customer-email').text(item.get('P1'));
            $('#details-full-order #customer-fname').text(item.get('P2'));
            $('#details-full-order #customer-lname').text(item.get('P3'));
            $('#details-full-order #customer-phone').text(item.get('P5'));
            $('#details-full-order #customer-address').text(item.get('P7'));
            $('#details-full-order #customer-city').text(item.get('P8'));
            $('#details-full-order #customer-country').text(item.get('P9'));
            $('#details-full-order #customer-status').text(item.get('P10'));
        };
        _service.call('getcustomerbyid', data, onGetSuccess);
        var onGetSuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                var des = value.item.description;
                if (des.length > 30) {
                    des = des.substring(0, 29) + "...";
                }
                data += "<tr> <td class='align-center'>" + value.item.id + "</td> <td>" + value.item.name + "</td> <td>" + des + "</td> <td>" + value.quantity + "</td> <td class='align-center'>" + value.item.typeItem.nameType + "</td> <td>" + value.item.price + "</td> </tr>";
            });
            $('#body-details').html(data);
        };
        _service.call('../customers/getitemorderbyidpurchase', data2, onGetSuccess);
        $('#order-header').text("Order ID : " + data2 + " (" + status + ") ");
        $('#changestatus').on('click', function(e) {
            e.preventDefault();
            $("#overlay #context").load("views/dialog_change_status_order.html", function() {
                $(document).trigger('DIALOG_CHANGESTATUS_LOADED', data2);
                $('#overlay').fadeIn();
            });
        });
    });
    $(document).on('DIALOG_CHANGESTATUS_LOADED', function(event, data) {
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
        $('#commit-change-status').on('click', function(e) {
            var onGetSuccess = function(result) {
                if (result.code === 400) {
                    location.reload();
                } else {
                    $('#overlay').fadeOut();
                    $('#message').text(result.data_response);
                    $('#message').fadeIn();
                }
            };
            var status = $('#status-order').val();
            var changeStatus = new ChangeStatus();
            changeStatus.set('id_order', data);
            changeStatus.set('status', status);
            _service.call('changestatusorder', changeStatus.toJsonString(), onGetSuccess);
        });
//        var onGetSuccess = function(result) {
//            var item = new WareHouses();
//            item.parse(result.data_response);
//            $('#details-warehouse td#name-warehouse').html(item.get('P1'));
//            $('#details-warehouse td#address-warehouse').html(item.get('P2'));
//            $('#details-warehouse td#name-phone').html(item.get('P3'));
//            $('#details-warehouse td#name-email').html(item.get('P4'));
//            $('#details-warehouse td#name-region').html(item.get('P6'));
//        };
//        _service.call('../manager/getwarehousebyid', data, onGetSuccess);
//        $('#close-dialog').on('click', function() {
//            $('#overlay').fadeOut();
//        });
    });
});