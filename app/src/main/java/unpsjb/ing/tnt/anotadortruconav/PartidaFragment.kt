package unpsjb.ing.tnt.anotadortruconav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentInicioBinding
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentPartidaBinding


class PartidaFragment : Fragment() {

    private var _binding: FragmentPartidaBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPartidaBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imageButtonShareResult.setOnClickListener {
            findNavController().navigate(R.id.action_partidaFragment_to_resultadoFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}