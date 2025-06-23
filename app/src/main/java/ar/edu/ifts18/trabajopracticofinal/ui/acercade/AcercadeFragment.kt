package ar.edu.ifts18.trabajopracticofinal.ui.acercade

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentAcercadeBinding

class AcercadeFragment  : Fragment()  {

    private var _binding: FragmentAcercadeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("AcercadeFragment", "onCreateView: START")

        val acercadeViewModel =
            ViewModelProvider(this).get(AcercadeViewModel::class.java)

        _binding = FragmentAcercadeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.headerTextView.text = "Acerca De"
        binding.policyTitleTextView.text = "Política de Uso"
        binding.policyTextView.text =
            "Esta aplicación debe ser utilizada de manera responsable. No se permite el uso indebido o ilegal de sus funciones."
        binding.versionTextView.text = "Versión: 0.0.1"

        Log.d("AcercadeFragment", "onCreateView: END")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}