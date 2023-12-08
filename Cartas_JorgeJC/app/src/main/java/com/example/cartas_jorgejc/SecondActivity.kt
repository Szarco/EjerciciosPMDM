package com.example.cartas_jorgejc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartas_jorgejc.databinding.ActivitySecondBinding
import com.example.cartas_jorgejc.model.Usuario
import com.google.android.material.snackbar.Snackbar
import java.util.Random
import kotlin.system.exitProcess


class SecondActivity : AppCompatActivity() {
    private var puntos:Int=0
    private lateinit var binding:ActivitySecondBinding
    private  var nombre: String? = null
    private val cartas = arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13,

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nombre = (intent.extras!!.getSerializable("Usuario") as Usuario).nombre
        Snackbar.make(binding.root, "Bienvenido " + nombre!!.uppercase(), Snackbar.LENGTH_INDEFINITE).setAction("COMENZAR") {
            var actual = Random().nextInt(cartas.size)
            binding.imageView.setImageResource(cartas[actual])

            binding.subir.setOnClickListener {
                var futura = Random().nextInt(cartas.size)
                binding.imageView.setImageResource(cartas[futura])
                if (futura > actual) {
                    puntos = puntos + 1
                    binding.puntuacion?.text= puntos.toString()
                    actual = futura
                } else if(futura.equals(actual)){
                    Snackbar.make(binding.root, "La carta tiene el mismo valor", Snackbar.LENGTH_LONG).show()
                    actual = futura
                }else {
                    Snackbar.make(binding.root, "Tus puntos son: " + puntos, Snackbar.LENGTH_INDEFINITE).setAction("OK") {
                        finish()
                    }.show()
                }
            }
            binding.bajar.setOnClickListener {
                var futura = Random().nextInt(cartas.size)
                binding.imageView.setImageResource(cartas[futura])
                if (futura < actual) {
                    puntos = puntos + 1
                    binding.puntuacion?.text= puntos.toString()
                    actual = futura
                }
                 else if(futura.equals(actual)) {
                    Snackbar.make(binding.root, "La carta tiene el mismo valor", Snackbar.LENGTH_LONG).show()
                    actual = futura
                }else {
                    Snackbar.make(binding.root, "Tus puntos son: " + puntos, Snackbar.LENGTH_INDEFINITE).setAction("OK") {
                        finish()
                    }.show()
                }
            }
        }.show()
    }
}


