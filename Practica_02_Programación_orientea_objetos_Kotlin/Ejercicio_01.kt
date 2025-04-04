/*
Descripción: Clase para cuenta bancaria

De: Fernando Perez Del Castillo
*/

// Clase que representa una cuenta bancaria con saldo y un límite de retiro
class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    //Metodo get para obtener el saldo
    fun getSaldo(): Double{
        return saldo
    }
    //Metodo set para establecer un nuevo saldo
    fun setSaldo(nuevoSaldo: Double){
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo")
        }
    }

    // Método para realizar un retiro de la cuenta
    fun retirar(cantidad: Double){

        // Verifica si la cantidad a retirar supera el límite permitido
        if(cantidad > limiteRetiro){
            println("No se puede retirar más del limite permitido")

        // Verifica si hay fondos suficientes para retirar la cantidad deseada
        } else if(cantidad> saldo){
            println("Fondos insuficientes")

        // Verifica si hay fondos suficientes para retirar la cantidad deseada
        } else {
            saldo -= cantidad
            println("Retiro exitoso, su saldo actual es: $$saldo")
        }
    }
}
