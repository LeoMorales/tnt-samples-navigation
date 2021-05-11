package unpsjb.ing.tnt.anotadortruconav.pantallas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import unpsjb.ing.tnt.anotadortruconav.R
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
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
        // Inflate view and obtain an instance of the binding class
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_inicio,
            container,
            false
        )
        val view = binding.root

        binding.button.setOnClickListener {
            val action = InicioFragmentDirections.playAction("AAA", "BBB")
            it.findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}