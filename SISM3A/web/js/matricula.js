/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function listarTipoCobro() {

    alert("Cargando Datos..");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "SMatricula",
        success: function(response) {

            for (var i = 0; i < response.length; i++)
            {
                $('#tipoPagoAM').append("<option value=" + response[i].idCiclo + ">" + response[i].denominacion + ": " + response[i].monto + "</option>");
            }
        },
        error: function(error) {
            alert(error.responseText);
        }
    });
}
function RegistrarTutor() {

    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#MatriculaForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtNombreAM: {
                    required: true
                },
                txtApellidoPAM: {
                    required: true
                },
                txtApellidoMAM: {
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
            confirm("Esta Seguro Registrar Nuevo Tutor");

            var oTutor = new Object();
            oTutor.nombre = $("#txtNombreT").val();
            oTutor.apellidoPaterno = $("#txtApellidoP").val();
            oTutor.apellidoMaterno = $("#txtApellidoM").val();
            oTutor.dni = $("#txtDni").val();
            oTutor.direccion = $("#txtDireccion").val();
            oTutor.telefono = $("#txtTelefono").val();

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
