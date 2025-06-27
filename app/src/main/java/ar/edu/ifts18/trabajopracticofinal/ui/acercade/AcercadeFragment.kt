package ar.edu.ifts18.trabajopracticofinal.ui.acercade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentAcercadeBinding

class AcercadeFragment : Fragment() {

    private var _binding: FragmentAcercadeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val acercadeViewModel =
            ViewModelProvider(this).get(AcercadeViewModel::class.java)

        _binding = FragmentAcercadeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
