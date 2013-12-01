/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registrarTutor() {
    var oBTutor = new Object();
    oBTutor.nombre = $("#txtNombreT").val();
    oBTutor.apellidoPaterno = $("#txtApePT").val();
    oBTutor.apellidoMaterno = $("#txtApeMT").val();
    oBTutor.dni = $("#ndi").val();
    oBTutor.direccion = $("#txtDirec").val();
    
    var sendData = JSON.stringify(oBTutor);
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
;

