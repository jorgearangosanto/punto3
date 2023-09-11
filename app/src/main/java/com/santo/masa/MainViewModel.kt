package com.santo.masa

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel: ViewModel() {
    fun validateNunber(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty())
            Log.d()

        else
        {val peso = number1.toDouble()
            val altura = number2.toDouble()

            val imc = peso/ altura.pow(2)
    }
}

    fun recomendacion(number3: Double) {

        val imc
        if (imc< 18.5) mainbinding.recomendacionTextView3.text = ("bien")
        if (imc>=18.5 && imc<24.9) mainbinding.recomendacionTextView3.text = ("buen peso")
        if (imc>=24.9 && imc<29.9) mainbinding.recomendacionTextView3.text = ("sobrepeso")
        if (imc>=29.9) mainbinding.recomendacionTextView3.text = ("obeso")
    } else {
        Toast.makeText(this, "digite bien", Toast.LENGTH_SHORT).show()

    }


}