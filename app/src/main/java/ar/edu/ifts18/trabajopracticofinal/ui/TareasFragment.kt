package ar.edu.ifts18.trabajopracticofinal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.R
import ar.edu.ifts18.trabajopracticofinal.TareaAdapter
import ar.edu.ifts18.trabajopracticofinal.Tarea
import androidx.recyclerview.widget.LinearLayoutManager


class TareasFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tareaAdapter: TareaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vencimientos, container, false)

        val listaTareas = listOf(
            Tarea("PPI", "Junio 26"),
            Tarea("TP Taller de Comunicación", "Julio 3"),
            Tarea("TP Desarrollo de Apps", "Mayo 17"),
            Tarea("TP Matemáticas", "Junio 18"),
            Tarea("TP Tecnologías de la Información", "Mayo 15")
        )

        recyclerView = view.findViewById(R.id.rvItemTarea)
        recyclerView.layoutManager = LinearLayoutManager(context)
        tareaAdapter = TareaAdapter(listaTareas)
        recyclerView.adapter = tareaAdapter

        return view
    }
}