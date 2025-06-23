import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.R
import ar.edu.ifts18.trabajopracticofinal.ui.vencimientos.Tarea
import ar.edu.ifts18.trabajopracticofinal.ui.vencimientos.TareaAdapter

class VencimientosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TareaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vencimientos, container, false)
        recyclerView = view.findViewById(R.id.recyclerVencimientos)

        val tareas = listOf(
            Tarea("TP PPI", "Junio 26"),
            Tarea("TP Taller de Comunicación", "Julio 3"),
            Tarea("TP Desarrollo de Apps", "Mayo 17"),
            Tarea("TP Matemáticas", "Junio 18"),
            Tarea("TP Tecnologías de la Información", "Mayo 15")
        )

        adapter = TareaAdapter(tareas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
}