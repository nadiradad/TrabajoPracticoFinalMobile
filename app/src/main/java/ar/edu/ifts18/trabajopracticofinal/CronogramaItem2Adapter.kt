package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CronogramaItem2Adapter(private val items: List<CronogramaItem2>) :
    RecyclerView.Adapter<CronogramaItem2Adapter.CronogramaViewHolder>() {

    inner class CronogramaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDia: TextView = itemView.findViewById(R.id.tvDia) // ojo que aquí hay que agregar este id
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CronogramaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cronograma2, parent, false)
        return CronogramaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CronogramaViewHolder, position: Int) {
        val item = items[position]
        holder.tvDia.text = item.dia
        holder.tvNombre.text = item.materia
        holder.tvFecha.text = item.horario
    }

    override fun getItemCount(): Int = items.size
}
