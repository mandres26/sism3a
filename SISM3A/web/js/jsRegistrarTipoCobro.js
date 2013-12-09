function RegistrarTipoCobro() {
    $(document).ready(function() {
        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#RegistrarTipoCobroForm").validate({
            errorClass: 'jqInvalid',
            rules: {
                txtDenominacion: {
                    required: true

                },
                txtMonto: {
                    required: true
                }
            },
            messages: {
                txtCiclo: " id ciclo",
                txtDenominacion: "Denomicacion",
                txtMonto: "Monto",
            }
        });
        if ($('#RegistrarTipoCobroForm').valid()) {
            confirm("Esta Seguro Registrar Tipo cobro");

            var oTipoCobro = new Object();
            oTipoCobro.idCiclo = $("#txtCiclo").val();
            oTipoCobro.denominacion = $("#txtDenominacion").val();
            oTipoCobro.monto = $("#txtMonto").val();


            var sendData = JSON.stringify(oTipoCobro);
            alert(sendData);
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "SRegistrarTipoCobro",
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