
/*MANEJO DE EVENTOS TOUCH EL BOTON ACEPTAR*/

window.addEventListener('load', function(){
 
 var box1 = document.getElementById('botonGuardar')
 var statusdiv = document.getElementById('botonGuardar')
 var startx = 0
 var dist = 0
 
 
 box1.addEventListener('touchstart', function(e){
  var touchobj = e.changedTouches[0] // reference first touch point (ie: first finger)
 document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar2.svg"
  e.preventDefault()
 }, false)
 
 box1.addEventListener('touchmove', function(e){
  var touchobj = e.changedTouches[0] // reference first touch point for this event
  e.preventDefault()
 }, false)
 
 box1.addEventListener('touchend', function(e){
  var touchobj = e.changedTouches[0] // reference 
  document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar.svg"
  e.preventDefault()
 }, false)
 
}, false)