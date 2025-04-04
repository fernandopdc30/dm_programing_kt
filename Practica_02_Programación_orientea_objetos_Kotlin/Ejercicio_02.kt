/*
Descripción: Clase para Producto

De: Fernando Perez Del Castillo
*/

// Clase que representa un producto con precio y descuento
class Producto(private var precio: Double, private var descuento: Double) {

    // Clase que representa un producto con precio y descuento
    fun getPrecio(): Double {
        return precio
    }

    // Clase que representa un producto con precio y descuento
    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo.")
        }
    }

    // Getter para obtener el porcentaje de descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Setter para actualizar el descuento, validando que esté entre 0 y 100
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El descuento debe estar entre 0 y 100%.")
        }
    }

    // Método que calcula el precio final del producto aplicando el descuento
    fun calcularPrecioFinal(): Double{
        return precio * (1-descuento / 100)
    }
}
