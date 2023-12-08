package com.example.calculadora_jorgejc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculadora_jorgejc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var signo: String = ""
    var num1=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Restaurar datos del Bundle
            signo = savedInstanceState?.getString("signo")?:("")
            num1 = savedInstanceState?.getInt("num1")?:0
            binding.calculadora.text = savedInstanceState?.getString("calculadora")?:("")

        binding.numero0.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "0")
        }
        binding.numero1.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "1")
        }
        binding.numero2.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "2")
        }
        binding.numero3.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "3")
        }
        binding.numero4.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "4")
        }
        binding.numero5.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "5")
        }
        binding.numero6.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "6")
        }
        binding.numero7.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "7")
        }
        binding.numero8.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "8")
        }
        binding.numero9.setOnClickListener {
            binding.calculadora.setText(binding.calculadora.text.toString() + "9")
        }
        binding.suma.setOnClickListener {
            num1 = (binding.calculadora.text.toString()).toInt()
            signo = "+"
            binding.calculadora.setText("")
        }
        binding.resta.setOnClickListener {
            num1 = (binding.calculadora.text.toString()).toInt()
            signo = "-"
            binding.calculadora.setText("")
        }
        binding.dividir.setOnClickListener {
            num1 = (binding.calculadora.text.toString()).toInt()
            signo = "/"
            binding.calculadora.setText("")
        }
        binding.multiplicar.setOnClickListener {
            num1 = (binding.calculadora.text.toString()).toInt()
            signo = "*"
            binding.calculadora.setText("")
        }
        binding.borrar.setOnClickListener {
            binding.calculadora.setText("")
        }
        binding.porcentaje.setOnClickListener {
            num1 = (binding.calculadora.text.toString()).toInt()
            signo="%"
            binding.calculadora.setText("")
        }
        binding.igual.setOnClickListener {
            var num2 = (binding.calculadora.text.toString()).toInt()
            if (signo == "+" || signo == "-" || signo == "/" || signo == "*"|| signo == "%") {
                when (signo) {
                    "+" -> {
                        binding.calculadora.setText((num1+num2).toString())
                    }
                    "-" -> {
                        binding.calculadora.setText((num1-num2).toString())
                    }
                    "*" -> {
                        binding.calculadora.setText((num1*num2).toString())
                    }
                    "%" -> {
                        binding.calculadora.setText(((num1*100)/num2).toString())
                    }
                    "/" -> {
                        if (num2 != 0) {
                            binding.calculadora.setText((num1/num2).toString())
                        }
                    }
                }
            }
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar datos en el Bundle
        outState.putString("signo", signo)
        outState.putInt("num1", num1)
        outState.putString("calculadora", binding.calculadora.text.toString())
    }

}
