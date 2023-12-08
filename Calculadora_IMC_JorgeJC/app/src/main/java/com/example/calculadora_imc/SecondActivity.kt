package com.example.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.calculadora_imc.databinding.ActivityMainBinding
import com.example.calculadora_imc.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    fun iconEstado(estadoFinal:String):Int {
        return when(estadoFinal) {
            "Bajo peso" -> R.drawable.estado1
            "Peso normal" -> R.drawable.estado2
            "Pre-obesidad o Sobrepeso" -> R.drawable.estado3
            "Obesidad clase I" -> R.drawable.estado4
            "Obesidad clase II" -> R.drawable.estado5
            "Obesidad clase III" -> R.drawable.estado6
            else -> {0}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editAltura.setText(intent.extras!!.getString("altura"))
        binding.editPeso.setText(intent.extras!!.getString("peso"))
        val imcCalculo = intent.extras!!.getDouble("IMC")
        val imcFinal = String.format("%.2f",imcCalculo)
        val estadoFinal = intent.extras!!.getString("Estado").toString()
        val iconoEstado = iconEstado(estadoFinal)
        binding.resultadoIMC.text = imcFinal
        binding.resultadoEstado.text = estadoFinal
        binding.icono.setImageResource(iconoEstado)
        val sexoElegido = intent.extras!!.getString("sexo")
        if(sexoElegido.equals("masculino")) {
            binding.masculino.isChecked = true
        }else{
            binding.femenino.isChecked=true
        }
    }
}
