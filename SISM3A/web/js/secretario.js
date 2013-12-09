/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function RegistrarSecretario() {
    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#registrarSecretarioForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtNombreS: {
                    required: true
                },
                txtApellidoPS: {
                    required: true
                },
                txtApellidoMS: {
                    required: true
                },
                txtDniS: {
                    required: true,
                    number: true,
                    minlength: 8,
                    maxlength: 8
                },
                txtDireccionS: {
                    required: true
                },
                txtTelefonoS: {
                    required: true,
                    number: true
                },
                txtusuarioS: {
                    required: true
                },
                txtpasswS: {
                    required: true,
                    minlength: 6,
                    maxlength: 6
                }
            },
            messages: {
                txtNombreS: "nombre",
                txtApellidoPS: "Apellido",
                txtApellidoMS: "Apellido",
                txtDniS: "dni 8 caracteres",
                txtDireccionS: "Direccion",
                txtTelefonoS: "Telefono",
                txtusuarioS: "Ususario",
                txtpasswS: "6 caracteres"
            }
        });

        if ($('#registrarSecretarioForm').valid()) {
            confirm("Esta Seguro Registrar Nuevo Tutor");

            var oSecretario = new Object();
            oSecretario.nombre = $("#txtNombreS").val();
            oSecretario.apellidoPaterno = $("#txtApellidoPS").val();
            oSecretario.apellidoMaterno = $("#txtApellidoMS").val();
            oSecretario.dni = $("#txtDniS").val();
            oSecretario.direccion = $("#txtDireccionS").val();
            oSecretario.telefono = $("#txtTelefonoS").val();
            oSecretario.usuario = $("#txtusuarioS").val();
            oSecretario.contrasenia = $("#txtpasswS").val();

            var sendData = JSON.stringify(oSecretario);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SCrearSecretario",
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

