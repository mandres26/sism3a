/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function listarTutorSalon() {

    alert("Cargando Datos..");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "SSalon",
        success: function(response) {

            for (var i = 0; i < response.length; i++)
            {
                $('#listTutor').append("<option value=" + response[i].idTutor + ">" + response[i].nombre + " " + response[i].apellidoPaterno + " " + response[i].apellidoMaterno + "</option>");
            }
        },
        error: function(error) {
            alert(error.responseText);
        }
    });
}
function crearSalon() {
    alert("ggggo");
    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#crearSalonForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtNombreSalon: {
                    required: true
                },
                txtcapacidadSalon: {
                    required: true,
                    maxlength: 45,
                    number: true
                },
                listTutor: {
                    required: function() {
                        if ($("#listTutor option[value='']")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            },
            messages: {
                txtNombreSalon: "Denominacion Salon",
                txtcapacidadSalon: "Capacidad max 45",
                listTutor: "Selecione un Tutor"
            }
        });
        if ($('#crearSalonForm').valid()) {
            confirm("Esta Seguro Registrar Nuevo Tutor");
            var oSalon = new Object();
            oSalon.nombre = $("#txtNombreSalon").val();
            oSalon.capacidad = $("#txtcapacidadSalon").val();
            oSalon.idTutor = $('#listTutor').val();
            var sendData = JSON.stringify(oSalon);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SSalon",
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