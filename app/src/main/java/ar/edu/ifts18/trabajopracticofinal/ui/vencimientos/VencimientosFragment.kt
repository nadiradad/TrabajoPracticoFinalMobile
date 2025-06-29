package ar.edu.ifts18.trabajopracticofinal.ui.vencimientos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.Tarea
import ar.edu.ifts18.trabajopracticofinal.TareaAdapter
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentVencimientosBinding
import ar.edu.ifts18.trabajopracticofinal.ui.vencimientos.VencimientosViewModel

class VencimientosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TareaAdapter
    private lateinit var listaTarea: List<Tarea>

    private var _binding: FragmentVencimientosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVencimientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(this)[VencimientosViewModel::class.java]
        listaTarea = listOf(
            Tarea("TP Integrador - Testing", "30/06/2025"),
            Tarea("Trabajo Practico 2 - PPII", "27/06/2025"),
            Tarea("Trabajo de Clase - T. de Comunc.", "22/06/2025"),
            Tarea("TP y Exposicion grupal - Mobile", "30/06/2025"),
            Tarea("TP Integrador - TIC", "30/06/2025")
        )

        recyclerView = binding.rvItemTarea
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = TareaAdapter(listaTarea)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}