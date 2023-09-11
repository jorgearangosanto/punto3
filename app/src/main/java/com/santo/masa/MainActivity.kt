package com.santo.masa

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.santo.masa.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {


    private lateinit var mainbinding: ActivityMainBinding
    private lateinit var mainviewModel: MainViewModel
    private var fechaNacimiento: String = ""
    private var cal= Calendar.getInstance()
////guardando practica 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = ActivityMainBinding.inflate(layoutInflater)
        mainviewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = mainbinding.root
        setContentView(view)

        val dataSetListener =
            DatePickerDialog.OnDateSetListener { view, year: Int, month, DayOfMonth ->
                cal.set(Calendar.YEAR,year)
                cal.set(Calendar.MONTH,month)
                cal.set(Calendar.DAY_OF_MONTH,DayOfMonth)

                val  format = " MM/dd/yyyy"
                val sdf = SimpleDateFormat(format,Locale.US)
                fechaNacimiento = sdf.format(cal.time).toString()
                mainbinding.dateButton6.setText(fechaNacimiento)
            }
        mainbinding.dateButton6.setOnClickListener{
            DatePickerDialog(
                this,
                dataSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),


                ).show()

        }




        val df = DecimalFormat("#.#")

        mainbinding.calcularButton.setOnClickListener {
            if (!validateEmpty()){
                val peso = mainbinding.pesoInputEditex.text.toString().toDouble()
                val altura = mainbinding.alturaInputEditex.text.toString().toDouble()
                val imc = peso/ altura.pow(2)
                mainbinding.resultadoTextView2.text = buildString {
                    append(" su imc ")
                    append(df.format(imc))
                }
                mainviewModel.recomendacion(imc )
                if (imc< 18.5) mainbinding.recomendacionTextView3.text = ("bien")
                if (imc>=18.5 && imc<24.9) mainbinding.recomendacionTextView3.text = ("buen peso")
                if (imc>=24.9 && imc<29.9) mainbinding.recomendacionTextView3.text = ("sobrepeso")
                if (imc>=29.9) mainbinding.recomendacionTextView3.text = ("obeso")
            } else {
                Toast.makeText(this, "digite bien", Toast.LENGTH_SHORT).show()





            }



        }
    mainviewModel.validateNunber(mainbinding.alturaInputEditex.text.toString(),mainbinding.pesoInputEditex.text.toString())




    }

    private fun validateEmpty() =
        mainbinding.alturaInputEditex.text.toString().isEmpty() || mainbinding.pesoInputEditex.text.toString()
            .isEmpty()
}

