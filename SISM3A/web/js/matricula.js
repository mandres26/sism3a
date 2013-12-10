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
function matricular() {

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
                txtDniAM: {
                    required: true,
                    number: true,
                    minlength: 8,
                    maxlength: 8
                },
                txtDireccionAM: {
                    required: true
                },
                txtTelefonoAM: {
                    required: true,
                    number: true
                },
                EscuelaAM: {
                    required: function() {
                        if ($("#EscuelaAM option[value='']")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                tipoPagoAM: {
                    required: function() {
                        if ($("#tipoPagoAM option[value='']")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                
            },
            messages: {
                txtNombreAM: "nombre",
                txtApellidoPAM: "Apellido",
                txtApellidoMAM: "Apellido",
                txtDniAM: "dni 8 caracteres",
                txtDireccionAM: "Direccion",
                txtTelefonoAM: "Telefono",
                EscuelaAM:"Selecione",
                tipoPagoAM:"selcione"
            }
        });
        if ($('#MatriculaForm').valid()) {
            confirm("Esta Seguro Registrar nueva Matricula");

            var OMatricula = new Object();
            OMatricula.nombre = $("#txtNombreAM").val();
            OMatricula.apellidoPaterno = $("#txtApellidoPAM").val();
            OMatricula.apellidoMaterno = $("#txtApellidoMAM").val();
            OMatricula.dni = $("#txtDniAM").val();
            OMatricula.direccion = $("#txtDireccionAM").val();
            OMatricula.telefono = $("#txtTelefonoAM").val();
            OMatricula.escuela = $("#EscuelaAM").val();
            OMatricula.idciclo = $("#tipoPagoAM").val();

            var sendData = JSON.stringify(OMatricula);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SMatricula",
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
