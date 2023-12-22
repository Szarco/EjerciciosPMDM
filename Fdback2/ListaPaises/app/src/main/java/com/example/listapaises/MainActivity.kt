package com.example.listapaises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listapaises.databinding.ActivityMainBinding
import com.example.listapaises.model.Pais

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var listaPaises: ArrayList<Pais>
    private lateinit var adaptadorLista: ArrayAdapter<Pais>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rellenarLista()
        configurarLista()
        acciones()

        binding.lista.setOnItemClickListener { _, _, position, _ ->
            val paisElegido = listaPaises[position]
            informacionPais(paisElegido)
        }
    }

    private fun informacionPais(pais: Pais) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("Pais", pais)
        startActivity(intent)
    }

    private fun rellenarLista(){
        listaPaises =ArrayList()
        listaPaises.add(Pais("España",48059777))
        listaPaises.add(Pais("Portugal",10467366))
        listaPaises.add(Pais("Francia",68070697))
        listaPaises.add(Pais("Italia",58850717))
        listaPaises.add(Pais("Holanda",17811291))
        listaPaises.add(Pais("Suiza",9024687))
        listaPaises.add(Pais("Austria",9104772))
        listaPaises.add(Pais("Belgica",11754004))
        listaPaises.add(Pais("Polonia",36753736))
        listaPaises.add(Pais("Alemania",84358845))
    }
    private fun configurarLista() {
        adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listaPaises)
        binding.lista.adapter = adaptadorLista
    }
    private fun acciones() {
        binding.lista.setOnItemLongClickListener{ parent, view, position, id ->
            val paisElegido = listaPaises[position]
            binding.texto.text = paisElegido.toString()
            true
        }
    }
}
