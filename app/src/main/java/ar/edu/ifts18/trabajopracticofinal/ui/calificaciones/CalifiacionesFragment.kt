package ar.edu.ifts18.trabajopracticofinal.ui.calificaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentCalifiacionesBinding

class CalifiacionesFragment  : Fragment()  {

    private var _binding: FragmentCalifiacionesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val califiacionesViewModel =
            ViewModelProvider(this).get(CalifiacionesViewModel::class.java)

        _binding = FragmentCalifiacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCalifiaciones
        califiacionesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}