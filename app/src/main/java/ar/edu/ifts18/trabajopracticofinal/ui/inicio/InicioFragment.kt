package ar.edu.ifts18.trabajopracticofinal.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ifts18.trabajopracticofinal.CalificacionesRecientes
import ar.edu.ifts18.trabajopracticofinal.CalificacionesRecientesAdapter
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentInicioBinding
import ar.edu.ifts18.trabajopracticofinal.CronogramaItem
import ar.edu.ifts18.trabajopracticofinal.CronogramaItemAdapter

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inicioViewModel = ViewModelProvider(this).get(InicioViewModel::class.java)
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            CronogramaItem("TP Programación", "Fecha entrega: 24/06/25", android.R.drawable.ic_menu_info_details),
            CronogramaItem("TP Base de Datos", "Fecha entrega: 28/06/25", android.R.drawable.ic_menu_info_details),
            CronogramaItem("TP Matemática", "Fecha entrega: 30/06/25", android.R.drawable.ic_menu_info_details)
        )

        binding.rvInicioCronograma.layoutManager = LinearLayoutManager(requireContext())
        binding.rvInicioCronograma.adapter = CronogramaItemAdapter(items)

        val listaCalificaciones = listOf(
            CalificacionesRecientes("Segundo parcial", "2", "Matemáticas"),
            CalificacionesRecientes("Primer parcial", "4", "Historia"),
            CalificacionesRecientes("Quiz sorpresa", "3", "Física")
        )

        val adapter = CalificacionesRecientesAdapter(listaCalificaciones)

        binding.rvCalificacionesRecientes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCalificacionesRecientes.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
