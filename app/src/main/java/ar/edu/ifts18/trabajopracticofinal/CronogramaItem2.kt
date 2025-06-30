package ar.edu.ifts18.trabajopracticofinal

data class CronogramaItem2(
    val dia: String,
    val materia1: String,
    val horario1: String,
    val materia2: String? = null,
    val horario2: String? = null
)

