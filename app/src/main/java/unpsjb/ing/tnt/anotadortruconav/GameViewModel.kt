package unpsjb.ing.tnt.anotadortruconav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // internal
    private val _score_a = MutableLiveData<Int>()
    //external
    val score_a: LiveData<Int>
        get() = _score_a

    private val _score_b = MutableLiveData<Int>()
    val score_b: LiveData<Int>
        get() = _score_b

    private val _name_a = MutableLiveData<String>()
    val name_a: LiveData<String>
        get() = _name_a

    private val _name_b = MutableLiveData<String>()
    val name_b: LiveData<String>
        get() = _name_b

    init {
        _name_a.value = "Equipo A"
        _name_b.value = "Equipo B"
        _score_a.value = 0
        _score_b.value = 0
    }
    fun setNameA(name: String){
        this._name_a.value = name
    }

    fun setNameB(name: String){
        this._name_b.value = name
    }

    fun incrementScoreA(){
        this._score_a.value = this._score_a.value?.plus(1)
    }

    fun incrementScoreB(){
        this._score_b.value = this._score_b.value?.plus(1)
    }

    fun decrementScoreA(){
        this._score_a.value = this._score_a.value?.minus(1)
    }

    fun decrementScoreB(){
        this._score_b.value = this._score_b.value?.minus(1)
    }

}