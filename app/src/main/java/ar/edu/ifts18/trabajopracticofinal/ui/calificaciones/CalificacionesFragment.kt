package ar.edu.ifts18.trabajopracticofinal.ui.calificaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.Calificaciones
import ar.edu.ifts18.trabajopracticofinal.CalificacionesAdapter
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentCalificacionesBinding

class CalificacionesFragment  : Fragment()  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CalificacionesAdapter
    private lateinit var listaCalificaciones: List<Calificaciones>

    private var _binding: FragmentCalificacionesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calificacionesViewModel =
            ViewModelProvider(this).get(CalificacionesViewModel::class.java)

        _binding = FragmentCalificacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 1. Inicializa la lista de ejemplo
        listaCalificaciones = listOf(
            Calificaciones("Matemáticas", 9.0, 8.5),
            Calificaciones("Lengua", 7.0, 7.5),
            Calificaciones("Historia", 10.0, 9.0)
        )

        // 2. Inicializa el RecyclerView y el Adapter
        recyclerView = binding.rvCalificaciones
        adapter = CalificacionesAdapter(listaCalificaciones)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}