package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.videoview.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Elemento videoView
       val videoR = binding.video
        // Configurar la ruta del archivo de vídeo (URL web o ruta dentro de android studio)
        videoR.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.cartas))
        // Configurar el controlador de medios, para adjuntar al video los controles de pausa,reanudar,etc
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoR)
        videoR.setMediaController(mediaController)
        videoR.requestFocus()
        // Iniciar el video
        videoR.start()

    }
}



