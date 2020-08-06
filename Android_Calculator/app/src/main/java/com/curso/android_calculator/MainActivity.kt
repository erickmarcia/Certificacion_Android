package com.curso.android_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var N1=Number1.text// (EditText) findViewByID(R.id.Number1) //antes se manejaba asi
        var N2=Number2.text

        button_plus.setOnClickListener { var sum_result = N1.toString().toDouble() + N2.toString().toDouble()

            result_view.text = "Su resultado es:"+ sum_result.toString()



        }
    }
}