package ar.edu.ifts18.trabajopracticofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class ConfiguracionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuracion, container, false)

        // Listeners
        view.findViewById<CardView>(R.id.cardNotificaciones).setOnClickListener {
            Toast.makeText(context, "Notificaciones", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<CardView>(R.id.cardPoliticas).setOnClickListener {
            Toast.makeText(context, "Políticas de Uso", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<CardView>(R.id.cardSalir).setOnClickListener {
            Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}