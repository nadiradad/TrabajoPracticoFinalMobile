package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class PresentismoAdapter(private val lista: List<Presentismo>) :
    RecyclerView.Adapter<PresentismoAdapter.AsistenciaViewHolder>() {

    inner class AsistenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val totalClasesTextView: TextView = itemView.findViewById(R.id.totalClasesTextView)
        val asistenciasTextView: TextView = itemView.findViewById(R.id.asistenciasTextView)
        val faltasTextView: TextView = itemView.findViewById(R.id.faltasTextView)
        val porcentajeNumeroTextView: TextView = itemView.findViewById(R.id.porcentajeNumeroTextView)
        val progresoAsistencia: ProgressBar = itemView.findViewById(R.id.progresoAsistencia)
        val headerTextView: TextView = itemView.findViewById(R.id.headerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsistenciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_presentismo, parent, false)
        return AsistenciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AsistenciaViewHolder, position: Int) {
        val item = lista[position]
        val context = holder.itemView.context
        holder.headerTextView.text = item.nombreMateria
        holder.totalClasesTextView.text = "Clases:\n${item.totalClases}"
        holder.asistenciasTextView.text = "Asist:\n${item.asistencias}"
        holder.faltasTextView.text = "Faltas:\n${item.faltas}"
        holder.porcentajeNumeroTextView.text = "${item.porcentaje}%"
        holder.progresoAsistencia.progress = item.porcentaje

        val progressDrawable = DrawableCompat.wrap(holder.progresoAsistencia.progressDrawable)
        val color = when (item.porcentaje) {
            in 0..49 -> ContextCompat.getColor(context, R.color.rojo_nota)
            in 50..74 -> ContextCompat.getColor(context, R.color.amarillo_nota)
            else -> ContextCompat.getColor(context, R.color.verde_nota)
        }
        DrawableCompat.setTint(progressDrawable, color)
        holder.progresoAsistencia.progressDrawable = progressDrawable
    }

    override fun getItemCount(): Int = lista.size
}
