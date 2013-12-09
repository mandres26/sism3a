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
                $('#listTutor').append("<option value="+response[i].idTutor+">"+response[i].nombre + " " + response[i].apellidoPaterno + " " + response[i].apellidoMaterno +"</option>");
            }
        },
        error: function(error) {
            alert(error.responseText);
        }
    });
}