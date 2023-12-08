package com.example.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.calculadora_imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var sexo=""
    fun estadoIMC(imc: Double, sexo: String): String {
        return when (sexo) {
            "masculino" -> when {
                imc < 18.5 -> "Bajo peso"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..29.9 -> "Pre-obesidad o Sobrepeso"
                imc in 30.0..34.9 -> "Obesidad clase I"
                imc in 35.0..39.9 -> "Obesidad clase II"
                imc >= 40.0 -> "Obesidad clase III"
                else -> "Estado no definido"
            }

            "femenino" -> when {
                imc < 16.5 -> "Bajo peso"
                imc in 16.5..22.9 -> "Peso normal"
                imc in 23.0..25.9 -> "Pre-obesidad o Sobrepeso"
                imc in 26.0..30.9 -> "Obesidad clase I"
                imc in 31.0..33.9 -> "Obesidad clase II"
                imc >= 34.0 -> "Obesidad clase III"
                else -> "Estado no definido"
            }

            else -> {
                "Incalculable"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.genero.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                binding.masculino.id -> {
                    sexo = "masculino"

                }

                binding.femenino.id -> {
                    sexo = "femenino"

                }
            }
        }
        binding.calcular.setOnClickListener {
            val altura = binding.editAltura.text.toString()
            val peso = binding.editPeso.text.toString()

            if (altura.isEmpty() || peso.isEmpty() || binding.genero.checkedRadioButtonId == -1) {
                Snackbar.make(
                    binding.root,
                    "Debes introducir todos los datos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val imc = (peso.toDouble() / (altura.toDouble() * altura.toDouble()))
                val estado = estadoIMC(imc, sexo)
                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("sexo",sexo)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)
                intent.putExtra("IMC", imc)
                intent.putExtra("Estado", estado)
                startActivity(intent)
            }
        }

    }
}