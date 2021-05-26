package unpsjb.ing.tnt.anotadortruconav.pantallas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import unpsjb.ing.tnt.anotadortruconav.GameViewModel
import unpsjb.ing.tnt.anotadortruconav.R
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentResultadoBinding

class ResultadoFragment : Fragment() {

    private var _binding: FragmentResultadoBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private val model: GameViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_resultado,
            container,
            false
        )
        binding.gameViewModel = model
        binding.setLifecycleOwner(this)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}