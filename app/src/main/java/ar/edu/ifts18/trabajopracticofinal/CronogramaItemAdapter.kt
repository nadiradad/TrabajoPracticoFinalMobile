package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CronogramaItemAdapter(private val items: List<CronogramaItem>) :
    RecyclerView.Adapter<CronogramaItemAdapter.CronogramaViewHolder>() {

    inner class CronogramaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreTp: TextView = itemView.findViewById(R.id.tvCronogramaNombreTp)
        val tvFechaTp: TextView = itemView.findViewById(R.id.tvCronogramaFechaTp)
        val ivIcono: ImageView = itemView.findViewById(R.id.ivCronograma)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CronogramaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cronograma, parent, false)
        return CronogramaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CronogramaViewHolder, position: Int) {
        val item = items[position]
        holder.tvNombreTp.text = item.nombreTp
        holder.tvFechaTp.text = item.fechaEntrega
        holder.ivIcono.setImageResource(item.iconoResId)
    }

    override fun getItemCount(): Int = items.size
}
