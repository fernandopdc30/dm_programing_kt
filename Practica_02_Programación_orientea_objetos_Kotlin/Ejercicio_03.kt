/*
Descripción: Figuras

De: Fernando Perez Del Castillo
*/


// Clase abstracta base para todas las figuras geométricas
abstract class Shape {
    // Método abstracto para calcular el área (debe implementarse en las clases hijas)
    abstract fun calcularArea(): Double

    // Método abstracto para calcular el perímetro (también debe implementarse en las hijas)
    abstract fun calcularPerimetro(): Double

    // Método común para todas las figuras: imprime área y perímetro
    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

// Clase Cuadrado que hereda de Shape
class Cuadrado(private val lado: Double) : Shape() {

    // Implementación específica del área para un cuadrado
    override fun calcularArea(): Double {
        return lado * lado
    }

    // Implementación específica del perímetro para un cuadrado
    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Clase Círculo que hereda de Shape
class Circulo(private val radio: Double) : Shape() {

    // Área de un círculo: π * radio^2
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    // Perímetro (circunferencia) de un círculo: 2 * π * radio
    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Clase Rectángulo que hereda de Shape
class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {

    // Área de un rectángulo: largo * ancho
    override fun calcularArea(): Double {
        return largo * ancho
    }

    // Perímetro de un rectángulo: 2 * (largo + ancho)
    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

// Función principal para probar las figuras
fun main() {
    val cuadrado = Cuadrado(5.0)
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.imprimirResultados()
}
