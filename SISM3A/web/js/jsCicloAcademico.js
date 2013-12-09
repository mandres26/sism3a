/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function RegistrarCicloAcademico() {
    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#registrarCicloAcademicoForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtTipoCicloAcademico: {
                    required: true
                },
                txtFechaInicio: {
                    required: true

                },
                txtFechaFin: {
                    required: true
                },
                txtCosto: {
                    required: true,
                    number: false,
                }
            },
            messages: {
                txtTipoCicloAcademico: "Tipo Ciclo Academico",
                txtFechaInicio: "Fecha Inicio",
                txtFechaFin: "Fecha Fin",
                txtCosto: "Costo es numero",
            }
        });
        if ($('#registrarCicloAcademicoForm').valid()) {
            confirm("Esta Seguro Registrar Ciclo Academico");

            var oCicloAcademico = new Object();
            oCicloAcademico.tipoCicloAcademico = $("#txtTipoCicloAcademico").val();
            oCicloAcademico.fechaInicio = $("#txtFechaInicio").val();
            oCicloAcademico.fechaFin = $("#txtFechaFin").val();
            oCicloAcademico.costo = $("#txtCosto").val();

            var sendData = JSON.stringify(oCicloAcademico);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SRegistrarCicloAcademico",
                data: sendData,
                success: function(response) {
                    alert(response);
                    $('#txtCiclo').val(response);
                    $('#txtNombreCiclo').val(oCicloAcademico.tipoCicloAcademico);

                },
                error: function(error) {
                    alert(error.responseText);
                }
            });
        }
    });

//    function mostrarCiclo() {
//        alert("Cargando Datos....");
//        $.ajax({
//            type: "GET",
//            dataType: "json",
//            url: "SRegistrarCicloAcademico",
//            success: function(response) {
//                $('#txtCiclo').html(response);
//                
//            },
//            error: function(error) {
//                alert(error.responseText);
//            }
//        });
//    }
}

