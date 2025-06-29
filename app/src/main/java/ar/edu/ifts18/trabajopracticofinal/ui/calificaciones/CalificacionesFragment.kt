package ar.edu.ifts18.trabajopracticofinal.ui.calificaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.Calificaciones
import ar.edu.ifts18.trabajopracticofinal.CalificacionesAdapter
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentCalificacionesBinding

class CalificacionesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CalificacionesAdapter
    private lateinit var listaCalificaciones: List<Calificaciones>
    private var _binding: FragmentCalificacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalificacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(this).get(CalificacionesViewModel::class.java)

        listaCalificaciones = listOf(
            Calificaciones("Testing", 2, 6, "Parcial 1", "TP Integrador"),
            Calificaciones("Tec. de la Informacion", 10, 9,"Trabajo Practico 1", "Trabajo Practico 2"),
            Calificaciones("Taller de Comunicacion", 5, 6,"Trabajo Practico 1", "Trabajo Practico 2"),
            Calificaciones("PPII", 8, 7,"Parcial 1", "Parcial 2"),
            Calificaciones("Mobile", 4, 7,"Parcial 1", "TP Integrador")
        )

        recyclerView = binding.rvItemCronograma
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CalificacionesAdapter(listaCalificaciones)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}