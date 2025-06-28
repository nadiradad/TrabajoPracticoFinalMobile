package ar.edu.ifts18.trabajopracticofinal

data class Presentismo(
    val nombreMateria: String,
    val totalClases: Int,
    val asistencias: Int
) {
    val faltas: Int get() = totalClases - asistencias
    val porcentaje: Int get() = if (totalClases > 0) (asistencias * 100) / totalClases else 0
}

