package com.enesas.handlerrunnableprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.enesas.handlerrunnableprojesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var numara = -1
    var runnable: Runnable = Runnable {  } // bu da bir interface yani class değil. Aynı Abstract class gibi. Yani obje oluşturamayız.
    var handler: Handler = Handler()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
    }

    fun baslat(view:View){

        runnable = object: Runnable{
            override fun run() {
                binding.button.isEnabled = false // Bunu koymazsak Başlat'a her tıkladığımızda sayı katlanarak artıyor.
                numara += 1
                handler.postDelayed(runnable,1000)
                binding.textView.text = "Sayaç: $numara"
            }
        }
        handler.post(runnable)

    }
    fun durdur(view: View){

        handler.removeCallbacks(runnable)
        binding.button.isEnabled = true
    }

    fun sifirla(view: View){
        handler.removeCallbacks(runnable)
        binding.button.isEnabled = true
        numara = 0
        binding.textView.text = "Sayaç: 0"
    }
}