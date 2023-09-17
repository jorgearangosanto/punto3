package com.santo.masa

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.santo.masa.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow
import androidx.lifecycle.Observer

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

        /*val recomendacioObserver= Observer<String>{
            mainbinding.pesoInputEditex.text.toString().toDouble()

        }*/


    val imcobserver = Observer<Double>{imc->
        mainbinding.resultadoTextView2.setText(imc.toString())
    }

    mainviewModel.imc.observe(this,imcobserver)


    val mensaje1observer = Observer<String>{mensaje1->
        mainbinding.recomendacionTextView3.setText(mensaje1.toString())
    }
    mainviewModel.mensaje1.observe(this,mensaje1observer)


    val mensaje2observer = Observer<String>{mensaje2->
        mainbinding.recomendacionTextView3.setText(mensaje2.toString())

    }
    mainviewModel.mensaje2.observe(this,mensaje2observer)

    val mensaje3observer = Observer<String>{mensaje3->
        mainbinding.recomendacionTextView3.setText(mensaje3.toString())

    }
    mainviewModel.mensaje3.observe(this,mensaje3observer)

    val mensaje4observer = Observer<String>{mensaje4->
        mainbinding.recomendacionTextView3.setText(mensaje4.toString())

    }
    mainviewModel.mensaje4.observe(this,mensaje4observer)

    val mensaje5observer = Observer<String>{mensaje5->
        mainbinding.recomendacionTextView3.setText(mensaje5.toString())

    }
    mainviewModel.mensaje5.observe(this,mensaje5observer)


        val df = DecimalFormat("#.#")

        mainbinding.calcularButton.setOnClickListener {
            mainviewModel.validateNunber(mainbinding.alturaInputEditex.text.toString(),mainbinding.pesoInputEditex.text.toString())

            mainviewModel.recomendacion(imcobserver.toString())
            mainbinding.resultadoTextView2.text =imcobserver.toString() //buildString {
                //append(" su imc ")
                //append(df.format(imcobserver.toString()))
            //}

            /*if (!validateEmpty()){
                val peso = mainbinding.pesoInputEditex.text.toString().toDouble()
                val altura = mainbinding.alturaInputEditex.text.toString().toDouble()
                val imc = peso/ altura.pow(2)
                mainbinding.resultadoTextView2.text = buildString {
                    append(" su imc ")
                    append(df.format(imc))
                }
               // mainviewModel.recomendacion(imc )
                if (imc< 18.5) mainbinding.recomendacionTextView3.text = ("bien")
                if (imc>=18.5 && imc<24.9) mainbinding.recomendacionTextView3.text = ("buen peso")
                if (imc>=24.9 && imc<29.9) mainbinding.recomendacionTextView3.text = ("sobrepeso")
                if (imc>=29.9) mainbinding.recomendacionTextView3.text = ("obeso")
            } else {
                Toast.makeText(this, "digite bien", Toast.LENGTH_SHORT).show()





            }*/



        }
    //mainviewModel.validateNunber(mainbinding.alturaInputEditex.text.toString(),mainbinding.pesoInputEditex.text.toString())




    }

   /* private fun validateEmpty() =
        mainbinding.alturaInputEditex.text.toString().isEmpty() || mainbinding.pesoInputEditex.text.toString()
            .isEmpty()*/



}

