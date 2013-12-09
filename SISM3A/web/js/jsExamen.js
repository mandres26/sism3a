/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function loadPage() {
    $("#txtFecOpeacion").val($.GetFechActual());
}
function cargarCalendario() {
    $.Calendario('#txtFecOpeacion');
    $('#txtFecOpeacion').mask('99/99/9999');
    
     $.Calendario('#txtFecha');
    $('#txtFecha').mask('99/99/9999');
    

}
