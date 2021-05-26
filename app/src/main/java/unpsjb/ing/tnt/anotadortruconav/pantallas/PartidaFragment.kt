package unpsjb.ing.tnt.anotadortruconav.pantallas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import unpsjb.ing.tnt.anotadortruconav.GameViewModel
import unpsjb.ing.tnt.anotadortruconav.R
import unpsjb.ing.tnt.anotadortruconav.databinding.FragmentPartidaBinding


class PartidaFragment : Fragment() {

    private var _binding: FragmentPartidaBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val args: PartidaFragmentArgs by navArgs()
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
                R.layout.fragment_partida,
                container,
                false
        )
        val view = binding.root

        binding.gameViewModel = model
        binding.setLifecycleOwner(this)

        model.score_a.observe(viewLifecycleOwner, Observer { score ->
            paintScoreA(score)
        })
        model.score_b.observe(viewLifecycleOwner, Observer { score ->
            paintScoreB(score)
        })

        binding.imageButtonShareResult.setOnClickListener {
            findNavController().navigate(R.id.show_result_action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun paintScoreA(score: Int) {
        var result = splitScore(score)
        drawScoreAImages(result)
        turnOnSubstractButtonForIndex(getIndexOfSubstractButton(score))
    }

    private fun paintScoreB(score: Int) {
        var result = splitScore(score)
        drawScoreBImages(result)
        turnOnSubstractButtonForIndex_B(getIndexOfSubstractButton(score))
    }
    private fun drawScoreAImages(result: java.util.ArrayList<Int>) {
        binding.scoreA1ImageView.setImageResource(getResourceForNumber(result[0]))
        binding.scoreA2ImageView.setImageResource(getResourceForNumber(result[1]))
        binding.scoreA3ImageView.setImageResource(getResourceForNumber(result[2]))

    }

    private fun drawScoreBImages(result: java.util.ArrayList<Int>) {
        binding.scoreB1ImageView.setImageResource(getResourceForNumber(result[0]))
        binding.scoreB2ImageView.setImageResource(getResourceForNumber(result[1]))
        binding.scoreB3ImageView.setImageResource(getResourceForNumber(result[2]))

    }

    private fun turnOnSubstractButtonForIndex(index: Int) {
        binding.decAButton1.isVisible = false
        binding.decAButton2.isVisible = false
        binding.decAButton3.isVisible = false
        if (index == 1 )
            binding.decAButton1.isVisible = true
        if (index == 2 )
            binding.decAButton2.isVisible = true
        if (index == 3 )
            binding.decAButton3.isVisible = true
    }

    private fun turnOnSubstractButtonForIndex_B(index: Int) {
        binding.decBButton1.isVisible = false
        binding.decBButton2.isVisible = false
        binding.decBButton3.isVisible = false
        if (index == 1 )
            binding.decBButton1.isVisible = true
        if (index == 2 )
            binding.decBButton2.isVisible = true
        if (index == 3 )
            binding.decBButton3.isVisible = true
    }

    private fun getResourceForNumber(number: Int): Int {
        var resursoImg = when (number){
            1 -> R.drawable.ic_tantos_1
            2 -> R.drawable.ic_tantos_2
            3 -> R.drawable.ic_tantos_3
            4 -> R.drawable.ic_tantos_4
            5 -> R.drawable.ic_tantos_5
            else -> R.drawable.ic_tantos_vacio
        }

        return resursoImg

    }

    private fun splitScore(score: Int): ArrayList<Int> {
        var scoreToDraw = score
        if (score > 15)
            scoreToDraw = score - 15

        if(scoreToDraw < 5 )
            return arrayListOf(scoreToDraw, 0, 0)
        if(scoreToDraw < 10 )
            return arrayListOf(5, scoreToDraw - 5, 0)
        if(scoreToDraw < 15 )
            return arrayListOf(5, 5, scoreToDraw - 10)

        return arrayListOf(5, 5, 5)
    }

    private fun getIndexOfSubstractButton(score: Int): Int {
        return when (score){
            in 1..5 -> 1
            in 6..10 -> 2
            in 11..15 -> 3
            in 16..20 -> 1
            in 21..25 -> 2
            in 26..30 -> 3
            else -> 0
        }
    }

}