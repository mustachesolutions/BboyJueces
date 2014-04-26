/*::::::::::::::::DEFINICION DE COMPORTAMIENTO DE LOS BOTONES CON LOS CLICKS:::::::::::::*/

//-----------------------------BotonGuardar
function rolloverGuardar() {
document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar2.svg"; 
}
function rolloutGuardar(){
document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar.svg" ;
}

function downGuardar(){
document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar2.svg" ;
   
}

function upGuardar(){document.getElementById("botonGuardar").src = "../imagenes/botones/save/guardar.svg"}

//-----------------------------Originality
function rolloverOriginality() {
document.getElementById("boton").src = "../imagenes/botones/Originality/originality1.svg"; 
}
function rolloutOriginality(){
document.getElementById("boton").src = "../imagenes/botones/Originality/originality2.svg" ;
}

function downOriginality(){
document.getElementById("boton").src = "../imagenes/botones/Originality/originality1.svg" ;
contador();    
}

//-----------------------------Foundation
function rolloverFoundation() {
document.getElementById("boton").src = "../imagenes/botones/Foundation/BASE2Foundation.svg"; 
}
function rolloutFoundation(){
document.getElementById("boton").src = "../imagenes/botones/Foundation/BASE1Foundation.svg" ;
}

function downFoundation(){
document.getElementById("boton").src = "../imagenes/botones/Foundation/BASE2Foundation.svg" ;
contador();    
}

//-----------------------------Execution
function rolloverExecution() {
document.getElementById("botonExecution").src = "../imagenes/botones/Execution/execution2.svg"; 
}
function rolloutExecution(){
document.getElementById("botonExecution").src = "../imagenes/botones/Execution/execution1.svg" ;
}

function downExecution(){
document.getElementById("botonExecution").src = "../imagenes/botones/Execution/execution2.svg" ;
contador();    
}

//-----------------------------Dynamics
function rolloverDynamics() {
document.getElementById("boton").src = "../imagenes/botones/Dynamics/dynamics2.svg"; 
}
function rolloutDynamics(){
document.getElementById("boton").src = "../imagenes/botones/Dynamics/dynamics1.svg";
}

function downDynamics(){
document.getElementById("boton").src = "../imagenes/botones/Dynamics/dynamics2.svg" ;
contador();    
}

//-----------------------------Battle
function rolloverBattle() {
document.getElementById("boton").src = "../imagenes/botones/Battle/battle2.svg"; 
    
}
function rolloutBattle(){
document.getElementById("boton").src = "../imagenes/botones/Battle/battle1.svg";
   
}

function downBattle(){
document.getElementById("boton").src = "../imagenes/botones/Battle/battle2.svg" ;
    contador();   
}

//DEFINICION DE VARIABLES DE ENTORNO
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
function refresh()
        {
                location.reload(true);
        }


                          