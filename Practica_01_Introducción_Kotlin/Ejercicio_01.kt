/*
Ejercicio 1: Evaluación de empleados

De: Fernando Perez Del Castillo

*/
// Función que calcula el dinero recibido 
fun calcularDineroRecibido(salarioMensual: Double, puntuacion: Int): Double {
    return salarioMensual * (puntuacion / 10.0)
}
// Función que determina el nivel de rendimiento según la puntuación
fun obtenerNivel(puntuacion: Int): String {
    return when {
        puntuacion in 0..3 -> "Inaceptable"
        puntuacion in 4..6 -> "Aceptable"
        puntuacion in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}
fun main(){
    println("Ingrese la puntuación (0 a 10):")
    val puntuacion = readln()?.toIntOrNull() ?:0
    println("Ingrese el salario mensual:")
    val salarioMensual = readln()?.toDoubleOrNull() ?:0.0

    if (puntuacion == null || puntuacion !in 0..10 || salarioMensual == null || salarioMensual <= 0.0) {
        println("Datos inválidos. Asegúrese de que la puntuación esté entre 0 y 10 y el salario sea positivo.")
        return
    }
    // Calcula el nivel y el dinero recibido
    val nivel = obtenerNivel(puntuacion)
    val dinero = calcularDineroRecibido(salarioMensual, puntuacion)
    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dinero)}")
}
