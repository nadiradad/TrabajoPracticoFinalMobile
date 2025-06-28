package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ifts18.trabajopracticofinal.databinding.ItemCalificacionesrecientesBinding

class CalificacionesRecientesAdapter(
    private val lista: List<CalificacionesRecientes>
) : RecyclerView.Adapter<CalificacionesRecientesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCalificacionesrecientesBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCalificacionesrecientesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        holder.binding.tvEvaluacion.text = item.nombre
        holder.binding.tvNota.text = item.nota.toString()
        holder.binding.tvMateria.text = item.materia
        val context = holder.itemView.context

        fun getNotaColor(nota: Int): Int {
            return when (nota) {
                in 1..3 -> ContextCompat.getColor(context, R.color.rojo_nota)
                in 4..6 -> ContextCompat.getColor(context, R.color.amarillo_nota)
                in 7..10 -> ContextCompat.getColor(context, R.color.verde_nota)
                else -> ContextCompat.getColor(context, android.R.color.darker_gray)
            }
        }

        fun tintNotaBackground(textView: TextView, nota: Int) {
            val drawable = DrawableCompat.wrap(textView.background.mutate())
            DrawableCompat.setTint(drawable, getNotaColor(nota))
            textView.background = drawable
        }

        tintNotaBackground(holder.binding.tvNota, item.nota)
    }

    override fun getItemCount(): Int = lista.size
}
