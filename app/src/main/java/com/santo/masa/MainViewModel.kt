package com.santo.masa

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel : ViewModel() {
    fun validateNunber(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty())
            Log.d()
        else {
            val peso = number1.toDouble()
            val altura = number2.toDouble()

            val imc = peso / altura.pow(2)
            recomendacion(imc)
        }
    }

    val recomendacio: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    fun recomendacion(imc: Double) {


        if (imc < 18.5) recomendacio.value = "bien"
        if (imc >= 18.5 && imc < 24.9) recomendacio.value = ("buen peso")
        if (imc >= 24.9 && imc < 29.9) recomendacio.value = ("sobrepeso")
        if (imc >= 29.9)  recomendacio.value=("obeso")
    } else{

        Toast.makeText(this,"di",Toast.LENGTH_SHORT).show()

    }



}