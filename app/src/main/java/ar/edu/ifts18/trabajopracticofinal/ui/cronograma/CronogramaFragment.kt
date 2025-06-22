package ar.edu.ifts18.trabajopracticofinal.ui.cronograma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentCronogramaBinding

class CronogramaFragment  : Fragment()  {

    private var _binding: FragmentCronogramaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cronogramaViewModel =
            ViewModelProvider(this).get(CronogramaViewModel::class.java)

        _binding = FragmentCronogramaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCronograma
        cronogramaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}