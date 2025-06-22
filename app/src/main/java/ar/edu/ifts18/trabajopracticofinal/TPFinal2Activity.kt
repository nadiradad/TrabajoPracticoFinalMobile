package ar.edu.ifts18.trabajopracticofinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.ifts18.trabajopracticofinal.databinding.ActivityTpfinal2Binding

class TPFinal2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTpfinal2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTpfinal2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalClases = 30
        val asistencias = 22
        val faltas = totalClases - asistencias

        val porcentaje = if (totalClases > 0) {
            (asistencias * 100) / totalClases
        } else {
            0
        }

        binding.totalClasesTextView.text = totalClases.toString()
        binding.asistenciasTextView.text = asistencias.toString()
        binding.faltasTextView.text = faltas.toString()
        binding.progresoAsistencia.progress = porcentaje
        binding.porcentajeNumeroTextView.text = "$porcentaje%"
    }
}
