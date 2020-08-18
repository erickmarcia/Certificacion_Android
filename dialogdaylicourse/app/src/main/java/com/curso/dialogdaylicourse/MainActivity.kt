package com.curso.dialogdaylicourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     /**
     * Variable para Emjemplo 2. ProgressBar
     */

     var progressBarStatus = 0
     var rate = 0

    /**
     * Variables de Ejemplo 3: SeekBar
     */

    lateinit var  slider:SeekBar
    lateinit var myValue: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slider = mySeekBar
        myValue = tvSeekBarResult

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progreso: Int, fromUser: Boolean) {
                myValue.text = progreso.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                myValue.text = "Tracking started...${slider.progress}"
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                myValue.text = "Thank you for Select..${slider.progress}"
            }

        })
    }

    /**
     * Ejemplo 1: AlertDialog
     */

    fun showAlertDialog(view:View){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Titulo")
        alertDialog.setMessage("Are You sure you want to save the changes?")
        alertDialog.setPositiveButton("Accept"){dialogInterface, i -> Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show() }


        alertDialog.setNegativeButton("Cancel"){dialogInterface, i -> Toast.makeText(applicationContext, "Not Saved", Toast.LENGTH_SHORT).show()
        }

        alertDialog.setNeutralButton("Recordar Luego") {dialogInterface, i ->
            Toast.makeText(
                applicationContext,
                "Recordar Luego",
                Toast.LENGTH_SHORT
            ).show() }

        alertDialog.show()

    }


    /**
     * Ejemplo 2: progressBar(Simular una descarga)
     */
    fun simulateDownload(view: View){
        Thread(Runnable {
            while (progressBarStatus < 100){
                progressBarStatus +=10
                try {
                    Thread.sleep(500)
                }
                catch (e:InterruptedException){
                    e.printStackTrace()
                }

                myProgressBar.progress = progressBarStatus
                tvProgress.text = "${progressBarStatus} %"
            }


                myProgressBar.visibility = View.INVISIBLE
                tvProgress.visibility = View.INVISIBLE
    }).start()


    }



}