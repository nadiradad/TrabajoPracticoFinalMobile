package ar.edu.ifts18.trabajopracticofinal.ui.registro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ar.edu.ifts18.trabajopracticofinal.MainActivity
import ar.edu.ifts18.trabajopracticofinal.databinding.ActivityRegistroBinding 
import ar.edu.ifts18.trabajopracticofinal.ui.login.LoginActivity

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnRegistrar.setOnClickListener {
            performRegistration()
        }

        binding.btnYaTengoCuenta.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun performRegistration() {
        val nombre = binding.etNombreRegistro.text.toString().trim()
        val apellido = binding.etApellidoRegistro.text.toString().trim()
        val documento = binding.etDocumentoRegistro.text.toString().trim()
        val password = binding.etPasswordRegistro.text.toString().trim()
        val confirmPassword = binding.etConfirmPasswordRegistro.text.toString().trim()

        if (nombre.isEmpty() || apellido.isEmpty() || documento.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Registro exitoso para $nombre $apellido!", Toast.LENGTH_LONG).show()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
