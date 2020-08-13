package com.curso.lesson_05_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClicked(view: View) {

        if(USAcheckBox.isChecked) textresult.text ="USA: Correct Answer"
        if(CanadacheckBox.isChecked) textresult.text ="Canada: Correct Answer"
        if(ChinacheckBox.isChecked) textresult.text ="China: Correct Answer"
    }

}

