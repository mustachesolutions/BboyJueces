/*MANEJO DE EVENTOS TOUCH PARA EXECUTION*/

window.addEventListener('load', function(){
 
 var box1 = document.getElementById('botonExecution')
 var statusdiv = document.getElementById('botonExecution')
 var startx = 0
 var dist = 0
 
 
 box1.addEventListener('touchstart', function(e){
  var touchobj = e.changedTouches[0] // reference first touch point (ie: first finger)
  startx = parseInt(touchobj.clientX) // get x position of touch point relative to left edge of browser
  statusdiv.innerHTML = 'Status: touchstart<br /> ClientX: ' + startx + 'px'
  document.getElementById("botonExecution").src ="../imagenes/botones/Execution/execution2.svg" 
  contador(); 
  e.preventDefault()
 }, false)
 
 box1.addEventListener('touchmove', function(e){
  var touchobj = e.changedTouches[0] // reference first touch point for this event
  var dist = parseInt(touchobj.clientX) - startx
  statusdiv.innerHTML = 'Status: touchmove<br /> Horizontal distance traveled: ' + dist + 'px'
  e.preventDefault()
 }, false)
 
 box1.addEventListener('touchend', function(e){
  var touchobj = e.changedTouches[0] // reference first touch point for this event
  statusdiv.innerHTML = 'Status: touchend<br /> Resting x coordinate: ' + touchobj.clientX + 'px'
  document.getElementById("botonExecution").src = "../imagenes/botones/Execution/execution1.svg";
    
  e.preventDefault()
 }, false)
 
}, false)


//METODO DEL CONTADOR
var i = 0; 
function contador() 
{ 
if(i<5){    
i = i + 1; 
//Aca capturo todos los eventos que me genere el elemento con id boton
var btn = document.getElementById("h1");     
btn.innerHTML = i;    }
else 
{
i = 0; 
var btn = document.getElementById("h1");     
btn.innerHTML = i; 
}
}