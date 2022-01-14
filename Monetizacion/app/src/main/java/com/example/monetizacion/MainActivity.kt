package com.example.monetizacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit  var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var N1=Number1.text
        var N2=Number2.text

        button_plus.setOnClickListener{
            var sum_result = N1.toString().toDouble() + N2.toString().toDouble()

            Result.text = "Su resultado es: " + sum_result.toString()
        }

        button_multiply.setOnClickListener{
            var sum_result = N1.toString().toDouble() * N2.toString().toDouble()

            Result.text = "Su resultado es: " + sum_result.toString()
        }

        button_minus.setOnClickListener{
            var sum_result = N1.toString().toDouble() - N2.toString().toDouble()

            Result.text = "Su resultado es: " + sum_result.toString()
        }

        button_divide.setOnClickListener{
            var sum_result = N1.toString().toDouble() / N2.toString().toDouble()

            Result.text = "Su resultado es: " + sum_result.toString()
        }

        //ads - Dentro de onCreate
        MobileAds.initialize(this){
            Toast.makeText(applicationContext,"Carga de anuncios inicializada", Toast.LENGTH_LONG).show()
        }
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.LoadAd(adRequest)

    }
}