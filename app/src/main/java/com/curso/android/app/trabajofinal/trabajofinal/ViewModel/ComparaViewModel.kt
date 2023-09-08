package com.curso.android.app.trabajofinal.trabajofinal.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.trabajofinal.trabajofinal.Model.ComparaModel

class ComparaViewModel : ViewModel() {


    val comparaModel : LiveData<ComparaModel> get() = _comparaModel
    private var _comparaModel = MutableLiveData<ComparaModel>()

    val palabra1 : LiveData<String> get() = _palabra1
    private var _palabra1 = MutableLiveData<String>("")

    val palabra2 : LiveData<String> get() = _palabra2
    private var _palabra2 = MutableLiveData<String>("")

    val iguales : LiveData<Boolean> get() = _iguales
    private var _iguales = MutableLiveData<Boolean>(true)

    fun setPalabra1(string: String){
        _palabra1.value = string
    }

    fun setPalabra2(string: String){
        _palabra2.value = string
    }

    fun compararCadenas(){
        val sonIguales = palabra1.value == palabra2.value
        val resultado =  ComparaModel(_palabra1.value?: "",_palabra2.value?: "",sonIguales)
        _comparaModel.value=resultado
    }
}