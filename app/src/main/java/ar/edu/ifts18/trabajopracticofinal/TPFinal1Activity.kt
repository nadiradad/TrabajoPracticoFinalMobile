package ar.edu.ifts18.trabajopracticofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.edu.ifts18.trabajopracticofinal.databinding.ActivityTpfinal1Binding

class TPFinal1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTpfinal1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //ViewBinding
        binding = ActivityTpfinal1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //¡Esto es para los insets!!
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.headerTextView.text = "Acerca De"
        binding.policyTitleTextView.text = "Política de Uso"
        binding.policyTextView.text =
            "Esta aplicación debe ser utilizada de manera responsable. No se permite el uso indebido o ilegal de sus funciones."
        binding.versionTextView.text = "Versión: 0.0.1"
    }
}
