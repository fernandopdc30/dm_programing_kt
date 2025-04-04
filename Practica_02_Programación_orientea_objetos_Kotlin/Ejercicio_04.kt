/*
Descripción: Sistema de gestión de biblioteca

De: Fernando Perez Del Castillo
*/


// Clase abstracta que representa un material genérico de biblioteca (libros, revistas, etc.)
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    // Método abstracto que será implementado por cada tipo específico de material
    abstract fun mostrarDetalles()
}

// Clase Libro que hereda de Material y agrega propiedades específicas de un libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {

    // Implementación del método abstracto para mostrar detalles de un libro
    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}

// Clase Revista que también hereda de Material, con propiedades propias
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {

    // Implementación del método abstracto para mostrar detalles de una revista
    override fun mostrarDetalles() {
        println("Revista: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

// Clase data para representar a un usuario de la biblioteca
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz que define las operaciones básicas que debe tener una biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(material: Material, usuario: Usuario)
    fun devolverMaterial(material: Material, usuario: Usuario)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

// Implementación concreta de la interfaz IBiblioteca
class Biblioteca : IBiblioteca {
    // Lista de materiales disponibles para préstamo
    private val materialesDisponibles = mutableListOf<Material>()

    // Mapa que asocia usuarios con sus materiales prestados
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    // Agrega un material a la lista de disponibles
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    // Registra un usuario nuevo en el sistema
    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
    }

    // Presta un material a un usuario si está disponible
    override fun prestarMaterial(material: Material, usuario: Usuario) {
        if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Material prestado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El material no está disponible.")
        }
    }

    // Devuelve un material prestado por el usuario
    override fun devolverMaterial(material: Material, usuario: Usuario) {
        if (material in usuarios[usuario] ?: mutableListOf()) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El usuario no tiene este material en préstamo.")
        }
    }

    // Muestra todos los materiales actualmente disponibles en la biblioteca
    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    // Muestra todos los materiales prestados a un usuario en particular
    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}

// Función principal que simula el uso de la biblioteca
fun main() {
    // Creamos un libro y una revista
    val libro = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista = Revista("National Geographic", "Varios", 2021, "0027-9358", 196, 5, "National Geographic Society")

    // Creamos un usuario
    val usuario = Usuario("Lucas", "Rojo", 30)

    // Creamos la biblioteca y registramos los materiales y el usuario
    val biblioteca = Biblioteca()
    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    // Prestamos un material, mostramos lo prestado, lo devolvemos y mostramos los disponibles
    biblioteca.prestarMaterial(libro, usuario)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario)
    biblioteca.devolverMaterial(libro, usuario)
    biblioteca.mostrarMaterialesDisponibles()
}
