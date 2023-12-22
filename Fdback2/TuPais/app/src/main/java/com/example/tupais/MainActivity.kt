package com.example.tupais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.tupais.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Paises.setOnCheckedChangeListener { _, checkedId ->
            val radio =binding.Paises.findViewById<RadioButton>(checkedId)
            val nombrePais = radio.text.toString().toLowerCase()

            // Obtén el identificador de la imagen de la bandera
            val imageId = resources.getIdentifier(nombrePais,"drawable",packageName)

            // Establece la imagen en el ImageView
            binding.Bandera.setImageResource(imageId)
        }
    }
}
