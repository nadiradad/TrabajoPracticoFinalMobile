package ar.edu.ifts18.trabajopracticofinal.ui.cronograma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ifts18.trabajopracticofinal.CronogramaItem2
import ar.edu.ifts18.trabajopracticofinal.CronogramaItem2Adapter
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

        val items = listOf(
            CronogramaItem2("Lunes", "PPII", "de 18:00 a 22:10 hs"),
            CronogramaItem2("Martes", "Mobile", "de 18:00 a 22:10 hs"),
            CronogramaItem2("Miércoles", "Mobile", "de 18:00 a 20:00 hs", "Testing", "de 20:10 a 22:00 hs"),
            CronogramaItem2("Jueves", "TIC", "de 18:00 a 20:00 hs", "T. de Comunic.", "de 20:10 a 22:00 hs"),
            CronogramaItem2("Viernes", "Testing", "de 18:00 a 20:00 hs")
        )

        val adapter = CronogramaItem2Adapter(items)
        binding.rvItemCronograma2.adapter = adapter
        binding.rvItemCronograma2.layoutManager = LinearLayoutManager(requireContext())



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}