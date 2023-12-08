package com.example.cartas_jorgejc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartas_jorgejc.databinding.ActivityMainBinding
import com.example.cartas_jorgejc.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var name: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.empezar.setOnClickListener {
            name= binding.nombre.text.toString()
            if(name.isEmpty()) {
                Snackbar.make(binding.root,"Por favor introduce tu nombre",Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(binding.root,"Perfecto "+name.uppercase()+",quieres empezar",Snackbar.LENGTH_INDEFINITE).setAction("OK"){
                    val intent = Intent (applicationContext, SecondActivity::class.java)
                    intent.putExtra("Usuario",Usuario (name))
                    startActivity(intent)
                }.show()


            }
        }
    }
}