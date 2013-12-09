/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function RegistrarTutor() {
    alert("hola");
    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#registrarTutorForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtNombreT: {
                    required: true
                },
                txtApellidoP: {
                    required: true
                },
                txtApellidoM: {
                    required: true
                },
                txtDni: {
                    required: true,
                    number: true,
                    minlength: 8,
                    maxlength: 8
                },
                txtDireccion: {
                    required: true
                },
                txtTelefono: {
                    required: true,
                    number: true
                }
            },
            messages: {
                txtNombreT: "nombre",
                txtApellidoP: "Apellido",
                txtApellidoM: "Apellido",
                txtDni: "dni 8 caracteres",
                txtDireccion: "Direccion",
                txtTelefono: "Telefono"
            }
        });
        if ($('#registrarTutorForm').valid()) {


            var oTutor = new Object();
            oTutor.nombre = $("#txtNombreT").val();
            oTutor.apellidoPaterno = $("#txtApellidoP").val();
            oTutor.apellidoMaterno = $("#txtApellidoM").val();
            oTutor.dni = $("#txtDni").val();
            oTutor.direccion = $("#txtDireccion").val();
            oTutor.telefono = $("#txtTelefono").val();
            alert("otraves hola");
            var sendData = JSON.stringify(oTutor);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SRegistrarTutor",
                data: sendData,
                success: function(response) {
                    alert(response);

                },
                error: function(error) {
                    alert(error.responseText);
                }
            });
        }
    });
}
function prueba() {
    //jAlert("Actualidad jQuery", "Actualidad jQuery");
    
    jConfirm("¿Te gusta Actualidad jQuery?", "Actualidad jQuery", function(r) {
        if (r) {
            jAlert("Te gusta Actualidad jQuery", "Actualidad jQuery");
        } else {
            jAlert("No te gusta Actualidad jQuery", "Actualidad jQuery");
        }
    });
    
    
}

function listarTutor() {
    var id;
    alert("Cargando Datos....");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "SRegistrarTutor",
        success: function(response) {
            $('#tbody').html(" ");
            for (var i = 0; i < response.length; i++)
            {

                $('#tbody').append(
                        "<tr><td>" + response[i].idTutor +
                        "</td><td>" + response[i].nombre + " " + response[i].apellidoPaterno + " " + response[i].apellidoMaterno +
                        "</td><td>" + response[i].dni +
                        "</td><td>" + response[i].direccion +
                        "</td>" + response[i].estado + "<td></tr>");
            }
        },
        error: function(error) {
            alert(error.responseText);
        }
    });
}
function listarTutorGrid() {
    var id;
    alert('ssss');
    jQuery("#listGrid").jqGrid({
        type: "GET",
        url: "SRegistrarTutor",
        datatype: "json",
        colNames: ['ID', 'NOMBRES', 'APEPATERNO', 'APEMATERNO', 'DIRECCION', 'ESTADO'],
        colModel: [
            {name: 'idTutor', index: 'idTutor', width: 50, sortable: false, align: 'left'},
            {name: 'nombre', index: 'nombre', width: 200, sortable: false, align: 'left'},
            {name: 'apellidoPaterno', index: 'apellidoPaterno', width: 200, sortable: false, align: 'left'},
            {name: 'apellidoMaterno', index: 'apellidoMaterno', width: 200, sortable: false, align: 'left'},
            {name: 'direccion', index: 'direccion', width: 200, sortable: false, align: 'left'},
            {name: 'estado', index: 'estado', width: 200, sortable: false, align: 'left'}
        ],
        multiselect: false,
        paging: true,
        rowNum: 15,
        rowList: [15, 30, 45],
        pager: $("#pagerGrid"),
        loadonce: true,
        sortorder: "desc",
        viewrecords: true,
        caption: "Lista de Alumnos",
        onSelectRow: function(id) {
            var nombre = $('#listGrid').getCell(id, "nombre");
            var apelliP = $('#listGrid').getCell(id, "apellidoPaterno");
            var apelliM = $('#listGrid').getCell(id, "apellidoMaterno");
            var dir = $('#listGrid').getCell(id, "direccion");
            var esta = $('#listGrid').getCell(id, "estado");

            $("#txtNombreT1").val(nombre);
            $("#txtApellidoP1").val(apelliP);
            $("#txtApellidoM1").val(apelliM);
            $("#txtDni1").val(dir);
            $("#txtDireccion1").val(esta);
        }
    }).navGrid("#pagerGrid", {edit: false, add: false, del: false});
    $("#listGrid").jqGrid('bindKeys', {
        onEnter: function(rowid) {
            var id = jQuery("#listGrid").jqGrid('getGridParam', 'selrow');
            $('#popup').fadeOut('slow');
            if (id) {
                var ret = $("#listGrid").jqGrid('getRowData', id);
                $("#txtIdPersona").val(ret.idtercero);
                $("#txtNombreCompleto").val(ret.fullnombre);
                $("#txtDocumento").val(ret.nrodocdef);
            }
        }
    });

}

function getData() {
    $("#list2").jqGrid('GridUnload');
    $("#list2").jqGrid({
        type: "GET",
        url: "SRegistrarTutor",
        datatype: "json",
        colNames: ['ID', 'NOMBRES', 'APEPATERNO', 'APEMATERNO', 'DIRECCION', 'ESTADO'],
        colModel: [
            {name: 'idTutor', index: 'idTutor', width: 50, sortable: false, align: 'left'},
            {name: 'nombre', index: 'nombre', width: 200, sortable: false, align: 'left'},
            {name: 'apellidoPaterno', index: 'apellidoPaterno', width: 200, sortable: false, align: 'left'},
            {name: 'apellidoMaterno', index: 'apellidoMaterno', width: 200, sortable: false, align: 'left'},
            {name: 'direccion', index: 'direccion', width: 200, sortable: false, align: 'left'},
            {name: 'estado', index: 'estado', width: 200, sortable: false, align: 'left'}
        ],
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#pager2',
        sortname: 'idTutor',
        viewrecords: true,
        sortorder: "desc",
        multiselect: false,
        caption: "MAESTRO DE ALUMNOS",
        onSelectRow: function(id) {
            var ids = $('#list2').getCell(id, "idTutor");

            if (ids == null) {
                ids = 0;
                if ($("#list10_d").jqGrid('getGridParam', 'records') > 0) {
                    $("#list10_d").jqGrid('setGridParam', {url: "SListarTutor?ids=" + ids, page: 1});
                    $("#list10_d").jqGrid('setCaption', "DETALLE MATRICULA: " + ids).trigger('reloadGrid');
                }
            } else {
                $("#list10_d").jqGrid('setGridParam', {url: "SListarTutor?ids=" + ids, page: 1});
                $("#list10_d").jqGrid('setCaption', "DETALLE MATRICULA: " + ids).trigger('reloadGrid');
            }
        }});
    $("#list2").jqGrid('navGrid', '#pager10',
            {add: false, edit: false, del: false});
    $("#list10_d").jqGrid({
        height: 'auto',
        type: 'GET',
        datatype: "json",
        colNames:
                ['DIRECCION', 'TELEFONO', 'ESTADO', 'SALONCARGO'],
        colModel:
                [
                    {name: 'direccion', index: 'direccion', width: 50, align: "center"},
                    {name: 'estado', index: 'estado', width: 250, align: "left"},
                    {name: 'numero', index: 'numero', width: 250, align: "left"},
                    {name: 'denominacion', index: 'denominacion', width: 100, align: "center"}
                ],
        rowNum: 5,
        rowList: [5, 10, 20],
        pager: '#pager10_d',
        sortname: 'item',
        viewrecords: true,
        sortorder: "asc",
        multiselect: true,
        caption: "DETALLE DE CURSOS MATRICULADOS"
    }).navGrid('#pager10_d',
            {add: false, edit: false, del: false});
    $("#ms1").click(function() {
        var s;
        s = $("#list10_d").jqGrid('getGridParam', 'selarrrow');
        alert(s);
    });


}
var dd = function jalaID(id) {
    var id = id;
    return id;
};

function ActualizarTutor(dd) {
    var oTutor = new Object();
    oTutor.idTutor = dd;
    var sendData = JSON.stringify(oTutor);
    alert(sendData);
    $.ajax({
        type: "GET",
        dataType: "json",
        data: sendData,
        url: "SListarTutor",
        success: function(response) {

            for (var i = 0; i < response.length; i++)
            {

                $("#txtNombreT1").val(response[i].nombre);
                $("#txtApellidoP1").val(response[i].apellidoPaterno);
                $("#txtApellidoM1").val(response[i].apellidoMaterno);
                $("#txtDni1").val(response[i].dni);
                $("#txtDireccion1").val(response[i].direccion);
            }
        },
        error: function(error) {
            alert(error.responseText);
        }
    });
}