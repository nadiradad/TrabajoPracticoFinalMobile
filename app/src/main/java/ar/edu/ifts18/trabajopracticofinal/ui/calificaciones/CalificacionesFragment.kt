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
            Calificaciones("Matemáticas", 9.0, 8.5),
            Calificaciones("Lengua", 7.0, 7.5),
            Calificaciones("Historia", 10.0, 9.0)
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