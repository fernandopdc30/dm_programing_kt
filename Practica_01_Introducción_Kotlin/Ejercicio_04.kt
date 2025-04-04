/*
Ejercicio 4: Adivina Número

De: Fernando Perez Del Castillo
*/
import kotlin.random.Random

// Función que genera un número aleatorio entre 1 y 30
fun generarNumeroAleatorio ():Int{
    return Random.nextInt(1,31)
}

fun main(){
    val numeroRandom = generarNumeroAleatorio()
    var intentos = 5
    println("He generado un número entre 1 y 30. ¡Intenta adivinarlo!")
    
    // Bucle principal del juego: se repite mientras queden intentos
    while(intentos>0){
        println("Ingresa tu numero: ")
        val numero = readLine()?.toIntOrNull()

        // Verifica si la entrada es válida
        if (numero == null || numero !in 1..30) {
            println("Por favor, ingresa un número válido entre 1 y 30.")
            continue
        }

        // Compara el número del usuario con el número generado
        if(numero == numeroRandom){
            println("Felicidades! haz ganado")
            break
        }
        else if(numero< numeroRandom){
            println("El número es mayor que $numero.")
        }
        else {
            println("El numero es menor que $numero")
        }

        intentos--

        // Muestra los intentos restantes o finaliza el juego si ya no hay
        if (intentos > 0) {
            println("Te quedan $intentos intentos!")
        } else {
            println("Game Over. El número era $numeroRandom.")
        }
    }
}
