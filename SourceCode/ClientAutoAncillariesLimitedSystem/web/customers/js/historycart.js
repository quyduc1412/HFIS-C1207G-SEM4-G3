/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var _service = Service();
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
    $('.warehouse-details').on('click', function(e) {
        e.preventDefault();
        var data = $(this).attr("idname");
        $("#overlay #context").load("views/view_details_warehouse.html", function() {
            $(document).trigger('DETAIL_WAREHOUSES_LOADED', data);
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
                data += "<tr> <td class='align-center'>" + value.item.id + "</td> <td>" + value.item.name + "</td> <td>" + des + "</td> <td>" + value.quantity + "</td> <td class='align-center'>"+value.item.typeItem.nameType+"</td> <td>" + value.item.price + "</td> </tr>";
            });
            $('#body-details').html(data);
        };
        _service.call('getitemorderbyidpurchase', data_input, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
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
        _service.call('../manager/getwarehousebyid', data, onGetSuccess);
        $('#close-dialog').on('click', function() {
            $('#overlay').fadeOut();
        });
    });
});