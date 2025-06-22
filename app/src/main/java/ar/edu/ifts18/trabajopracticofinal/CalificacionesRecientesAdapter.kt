package ar.edu.ifts18.trabajopracticofinal

import android.view.LayoutInflater
import android.view.ViewGroup
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
        holder.binding.tvNota.text = item.nota
        holder.binding.tvMateria.text = item.materia
    }

    override fun getItemCount(): Int = lista.size
}
