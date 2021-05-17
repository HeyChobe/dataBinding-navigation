package com.example.labo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {

    var firstName = MutableLiveData("")
    var lastName = MutableLiveData("")
    var age = MutableLiveData("")
    var email = MutableLiveData("")


    private var _current = MutableLiveData<Int>()
    val current: LiveData<Int>
        get() = _current

    private val pagesForm : List<Int> =
        listOf(R.id.formInitFragment, R.id.formPage1Fragment,
            R.id.formPage2Fragment, R.id.formResultsFragment)

    private var _progress = MutableLiveData<Int>()
    val progress : LiveData<Int>
        get() = _progress

    init {
        _current.value = 0
    }

    fun onNext(){
        _current.apply {
            value = value?.plus(1)?.coerceIn(0,pagesForm.lastIndex)
        }

        updateProgress()
    }

    fun onPrev(){
        _current.apply {
            value = value?.minus(1)?.coerceIn(0,pagesForm.lastIndex)
        }

        updateProgress()
    }

    fun updateProgress(){
        _progress.apply {
            value = ((current.value?.times(100F))?.div(pagesForm.size))?.toInt()
        }
    }

    fun getCurrentPage() = pagesForm[current.value?:0]

}