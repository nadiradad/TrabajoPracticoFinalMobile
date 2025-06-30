package ar.edu.ifts18.trabajopracticofinal.ui.presentismo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ifts18.trabajopracticofinal.Presentismo
import ar.edu.ifts18.trabajopracticofinal.PresentismoAdapter
import ar.edu.ifts18.trabajopracticofinal.databinding.FragmentPresentismoBinding

class PresentismoFragment  : Fragment()  {

    private var _binding: FragmentPresentismoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPresentismoBinding.inflate(inflater, container, false)
        val root = binding.root

        val listaAsistencia = listOf(
            Presentismo("PPII", 22,17),
            Presentismo("Mobile",28, 26),
            Presentismo("T. de Comunacion",25, 20),
            Presentismo("Testing",30, 29),
            Presentismo("TIC",10, 5)
        )

        val adapter = PresentismoAdapter(listaAsistencia)
        binding.rvItemPresentismo.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItemPresentismo.adapter = adapter

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}