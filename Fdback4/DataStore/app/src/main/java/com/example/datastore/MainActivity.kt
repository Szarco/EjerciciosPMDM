package com.example.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="Saved")

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guardar.setOnClickListener {
            //MAIN -> render y listener
            //IO -> entradas y salidas
            lifecycleScope.launch(Dispatchers.IO) {
                guardarDatos(binding.editNombre.text.toString(),binding.editTelf.text.toString().toInt(),binding.editNomArchivo.text.toString())
            }
        }
        binding.consultar.setOnClickListener {
            val info1: Flow<String> = dataStore.data.map {
                it[stringPreferencesKey("nombre")] ?: "nombre no encontrado"
            }
            val info2: Flow<Any> = dataStore.data.map{
                it[intPreferencesKey("telefono")]?: "telefono no encontrado"
            }
            val info3: Flow<String> = dataStore.data.map{
                it[stringPreferencesKey("archivo")]?: "archivo no encontrado"
            }

            lifecycleScope.launch(Dispatchers.IO) {
                binding.informacion.setText(("Nombre: "+info1.first())
                        +"\n"+("Teléfono: "+info2.first())+"\n "+
                        ("Nombre del archivo: "+info3.first()))
            }

        }

    }
    suspend fun guardarDatos(nombre:String, telefono:Int, archivo:String){
        dataStore.edit {
            it[stringPreferencesKey("nombre")]= nombre
            it[intPreferencesKey("telefono")]= telefono
            it[stringPreferencesKey("archivo")]= archivo
        }
    }


}