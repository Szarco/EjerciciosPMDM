package com.example.listapaises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listapaises.databinding.ActivitySecondBinding
import com.example.listapaises.model.Pais

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pais = intent.getSerializableExtra("Pais") as? Pais

        binding.titulo.text = pais!!.nombre
        binding.informacion.text = pais!!.poblacion.toString()
    }
}