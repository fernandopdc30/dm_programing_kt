/*
Ejercicio 2: Piedra, papel o tijera

De: Fernando Perez Del Castillo
*/
import kotlin.random.Random

// Función que elige aleatoriamente una opción para la computadora
fun elegirOpcionComputadora(): String {
    val opciones = listOf("Piedra", "Papel", "Tijera")
    return opciones[Random.nextInt(opciones.size)]
}

// Función que determina el resultado del juego comparando la elección del usuario y de la computadora
fun determinarResultadoJuego(eleccionUser: String, eleccionComputer: String): String{
    return when{
        eleccionUser == eleccionComputer -> "Empate"
        (eleccionUser == "Piedra" && eleccionComputer == "Tijera") ||
                (eleccionUser == "Papel" && eleccionComputer == "Piedra") ||
                (eleccionUser == "Tijera" && eleccionComputer == "Papel") -> "Ganaste"
        else -> "Perdiste"
    }
}
fun main (){
    println("Elige una opción: Piedra, Papel o Tijera: " )
    val eleccionUsuario = readLine()?.capitalize() ?: ""
    if (eleccionUsuario !in listOf("Piedra", "Papel", "Tijera")) {
        println("Elección inválida. Debes elegir Piedra, Papel o Tijera.")
        return
    }
    
    // La computadora elige una opción aleatoria
    val eleccionComputadora = elegirOpcionComputadora()
    println("la computadora eligio: ${eleccionComputadora}")
    // Determina el resultado y lo muestra
    val resultado = determinarResultadoJuego(eleccionUsuario, eleccionComputadora)
    println("Resultado: $resultado")
}
