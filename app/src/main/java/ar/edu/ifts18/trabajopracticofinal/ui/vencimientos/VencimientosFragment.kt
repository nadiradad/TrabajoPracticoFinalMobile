package ar.edu.ifts18.trabajopracticofinal.ui.vencimientos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentVencimientosBinding

class VencimientosFragment : Fragment() {

    private var _binding: FragmentVencimientosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVencimientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}