package unpsjb.ing.tnt.anotadortruconav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentPartidaBinding


class PartidaFragment : Fragment() {

    private var _binding: FragmentPartidaBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val args: PartidaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPartidaBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.team1Label.text = args.equipoANombre
        binding.team2Label.text = args.equipoBNombre
        binding.imageButtonShareResult.setOnClickListener {
            findNavController().navigate(R.id.show_result_action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}