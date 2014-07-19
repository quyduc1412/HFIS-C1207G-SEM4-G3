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
//    var onLoadListWHSuccess2 = function(result) {
//        var data = "";
//        data += "<option value='all'>All</option>";
//        $.each(result.list, function(index, value) {
//            data += "<option value='" + value.id + "'>" + value.name + "</option>";
//        });
//        $('#warehouse').html(data);
//    };
//    _service.call('getallwarehouses', '', onLoadListWHSuccess2);
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
    $(function() {
        $("#datefrom").datepicker();
        $("#dateto").datepicker();
    });
});