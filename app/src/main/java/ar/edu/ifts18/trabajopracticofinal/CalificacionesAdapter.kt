package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.content.ContextCompat


class CalificacionesAdapter(private val lista: List<Calificaciones>) :
    RecyclerView.Adapter<CalificacionesAdapter.CalificacionesViewHolder>() {

    inner class CalificacionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMateria: TextView = itemView.findViewById(R.id.tvNombreMateria)
        val tvNotaUno: TextView = itemView.findViewById(R.id.tvNotaTrabajoPracticoUno)
        val tvNotaDos: TextView = itemView.findViewById(R.id.tvNotaTrabajoPracticoDos)
        val tvTpUno: TextView = itemView.findViewById(R.id.tvTrabajoPracticoUno)
        val tvTpDos: TextView = itemView.findViewById(R.id.tvTrabajoPracticoDos)
        val tvEstadoMateria: TextView = itemView.findViewById(R.id.tvEstadoMateria)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalificacionesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_calificaciones, parent, false)
        return CalificacionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalificacionesViewHolder, position: Int) {
        val calificaciones = lista[position]
        holder.tvMateria.text = calificaciones.nombre
        holder.tvNotaUno.text = calificaciones.calificacionUno.toString()
        holder.tvNotaDos.text = calificaciones.calificacionDos.toString()
        holder.tvTpUno.text = calificaciones.nombreTpUno
        holder.tvTpDos.text = calificaciones.nombreTpDos

        val context = holder.itemView.context

        fun getNotaColor(nota: Int): Int {
            return when (nota) {
                in 1..3 -> ContextCompat.getColor(context, R.color.rojo_nota)
                in 4..6 -> ContextCompat.getColor(context, R.color.amarillo_nota)
                in 7..10 -> ContextCompat.getColor(context, R.color.verde_nota)
                else -> ContextCompat.getColor(context, android.R.color.darker_gray)
            }
        }

        fun setNotaBackgroundColor(textView: TextView, color: Int) {
            val background = textView.background.mutate()
            if (background is android.graphics.drawable.GradientDrawable) {
                background.setColor(color)
                textView.background = background
            }
        }

        setNotaBackgroundColor(holder.tvNotaUno, getNotaColor(calificaciones.calificacionUno))
        setNotaBackgroundColor(holder.tvNotaDos, getNotaColor(calificaciones.calificacionDos))

        val promedio = (calificaciones.calificacionUno + calificaciones.calificacionDos) / 2.0
        val estado = when {
            promedio >= 7 -> "Promocionado"
            promedio >= 4 -> "Final"
            else -> "Recursa"
        }
        holder.tvEstadoMateria.text = estado
    }

    override fun getItemCount(): Int = lista.size
}
