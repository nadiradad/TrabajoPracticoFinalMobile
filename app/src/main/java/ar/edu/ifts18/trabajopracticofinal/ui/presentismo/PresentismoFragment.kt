package ar.edu.ifts18.trabajopracticofinal.ui.presentismo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentPresentismoBinding

class PresentismoFragment  : Fragment()  {

    private var _binding: FragmentPresentismoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val presentismoViewModel =
            ViewModelProvider(this).get(PresentismoViewModel::class.java)

        _binding = FragmentPresentismoBinding.inflate(inflater, container, false)
        val root: View = binding.root

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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}