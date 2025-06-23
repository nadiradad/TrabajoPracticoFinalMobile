package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalificacionesAdapter(private val lista: List<Calificaciones>) :
    RecyclerView.Adapter<CalificacionesAdapter.CalificacionesViewHolder>() {

    inner class CalificacionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMateria: TextView = itemView.findViewById(R.id.tvNombreMateria)
        val tvNotaUno: TextView = itemView.findViewById(R.id.tvNotaTrabajoPracticoUno)
        val tvNotaDos: TextView = itemView.findViewById(R.id.tvNotaTrabajoPracticoDos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalificacionesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_calificaciones, parent, false)
        return CalificacionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalificacionesViewHolder, position: Int) {
        val calificaciones = lista[position]
        holder.tvMateria.text = calificaciones.nombre
        holder.tvNotaUno.text = "${calificaciones.calificacionUno}"
        holder.tvNotaDos.text = "${calificaciones.calificacionDos}"
    }

    override fun getItemCount(): Int = lista.size
}
