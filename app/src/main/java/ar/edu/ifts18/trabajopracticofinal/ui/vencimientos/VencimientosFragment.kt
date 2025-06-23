package ar.edu.ifts18.trabajopracticofinal.ui.vencimientos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentVencimientosBinding

class VencimientosFragment  : Fragment()  {

    private var _binding: FragmentVencimientosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val vencimientosViewModel =
            ViewModelProvider(this).get(VencimientosViewModel::class.java)

        _binding = FragmentVencimientosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}