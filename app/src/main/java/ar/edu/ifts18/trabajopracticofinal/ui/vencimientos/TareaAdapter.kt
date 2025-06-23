package ar.edu.ifts18.trabajopracticofinal.ui.vencimientos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.R

class TareaAdapter(private val lista: List<Tarea>) :
    RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarea, parent, false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = lista[position]
        holder.tvNombre.text = tarea.nombre
        holder.tvFecha.text = "Fecha: ${tarea.fecha}"
    }

    override fun getItemCount(): Int = lista.size
}
