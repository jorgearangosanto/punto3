package com.santo.masa

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel : ViewModel() {


    val imc: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val mensaje1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val mensaje2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val mensaje3: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val mensaje4: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val mensaje5: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }



    fun validateNunber(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()){
            mensaje5.value = "debe digitar 2 numeros"

        }else {
            val peso = number2.toDouble()
            val altura = number1.toDouble()

             imc.value = peso / altura.pow(2)
        }


    }

    fun recomendacion(number1: String) {
        val imc = number1.toDouble()
        if (imc < 18.5) mensaje1.value = "bien"
        if (imc >= 18.5 && imc < 24.9) mensaje2.value = "buen peso"
        if (imc >= 24.9 && imc < 29.9) mensaje1.value = "sobrepeso"
        if (imc >= 29.9)  mensaje1.value="obeso"




    }
    /* fun validateNunber(number1: String, number2: String) {
         if (number1.isEmpty() || number2.isEmpty())
             //Log.d()
         else {
             val peso = number1.toDouble()
             val altura = number2.toDouble()
 
             val imc = peso / altura.pow(2)
             recomendacion(imc)
         }
     }*/

    /*val recomendacio: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }*/

    /*fun recomendacion(imc: Double) {


        if (imc < 18.5) recomendacio.value = "bien"
        if (imc >= 18.5 && imc < 24.9) recomendacio.value = ("buen peso")
        if (imc >= 24.9 && imc < 29.9) recomendacio.value = ("sobrepeso")
        if (imc >= 29.9)  recomendacio.value=("obeso")
    }*/



}