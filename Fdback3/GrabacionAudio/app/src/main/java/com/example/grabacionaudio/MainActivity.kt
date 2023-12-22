package com.example.grabacionaudio

import androidx.appcompat.app.AppCompatActivity
import com.example.grabacionaudio.databinding.ActivityMainBinding
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException
import android.os.Environment.getExternalStorageDirectory
import android.media.MediaRecorder
import android.content.pm.PackageManager
import android.Manifest
import android.media.MediaPlayer
import com.google.android.material.snackbar.Snackbar
import android.os.Bundle



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var grabacion: MediaRecorder? =null
    var ruta:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO), 1000)
        }

        binding.botonIniciar.setOnClickListener{
            if(grabacion==null) {

                ruta = "/data/data/com.example.grabacionaudio/archivo.mp3"

                grabacion?.setAudioSource(MediaRecorder.AudioSource.MIC)
                grabacion?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                grabacion?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                grabacion?.setOutputFile(ruta)
                try {
                    grabacion?.prepare()
                    grabacion?.start()
                } catch (e: IOException) {
                }
                Snackbar.make(binding.root, "Grabando!", Snackbar.LENGTH_LONG).show()
            }
        }
        binding.botonParar.setOnClickListener{
            if (grabacion!=null) {
                try {
                    grabacion?.stop()
                    grabacion?.release()
                } catch (e: IOException) {
                }
            }
                Snackbar.make(binding.root, "Grabación parada", Snackbar.LENGTH_LONG).show()
        }
        binding.botonRepro.setOnClickListener{
            var mediaPlayer= MediaPlayer()
            try {
                mediaPlayer.setDataSource(ruta)
                mediaPlayer.prepare()
            }catch (e:IOException){
            }
            mediaPlayer.start()
            Snackbar.make(binding.root, "Reproduciendo grabación", Snackbar.LENGTH_LONG).show()
        }
    }
}