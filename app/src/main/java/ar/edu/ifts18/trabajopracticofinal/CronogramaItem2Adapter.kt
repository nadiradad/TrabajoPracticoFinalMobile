package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CronogramaItem2Adapter(private val items: List<CronogramaItem2>) :
    RecyclerView.Adapter<CronogramaItem2Adapter.CronogramaViewHolder>() {

    inner class CronogramaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDia: TextView = itemView.findViewById(R.id.tvDia)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
        val tvNombre2: TextView = itemView.findViewById(R.id.tvNombre2)
        val tvFecha2: TextView = itemView.findViewById(R.id.tvFecha2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CronogramaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cronograma2, parent, false)
        return CronogramaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CronogramaViewHolder, position: Int) {
        val item = items[position]
        holder.tvDia.text = item.dia
        holder.tvNombre.text = item.materia1
        holder.tvFecha.text = item.horario1

        // Verificar si hay segunda materia
        if (item.materia2 != null && item.horario2 != null) {
            holder.tvNombre2.visibility = View.VISIBLE
            holder.tvFecha2.visibility = View.VISIBLE
            holder.tvNombre2.text = item.materia2
            holder.tvFecha2.text = item.horario2
        } else {
            holder.tvNombre2.visibility = View.GONE
            holder.tvFecha2.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = items.size
}

