package com.curso.dialogdaylicourse

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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



        /*Uso de WebmywebView*/
        mywebView.setBackgroundColor(Color.TRANSPARENT)
        mywebView.settings.javaScriptEnabled = true

        mywebView.settings.loadsImagesAutomatically = true
        mywebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        mywebView.webViewClient = WebViewClient()
//        mywebView.loadUrl("https://androidatc.com")
        mywebView.loadUrl("https://google.com")

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


    /**
     * Ejemplo 4: Calendar
     */
    fun showDialogPicker(view: View){
        val calendar = Calendar.getInstance()

        val dayOfMoth = calendar.get(Calendar.DAY_OF_MONTH)
        val month   = calendar.get(Calendar.MONTH)// toma el mes 0 al mes 11
        val year    = calendar.get(Calendar.YEAR)


        /**
         *  contexto, thema, funcion, variables
         */
        val datePicker = DatePickerDialog(
            this,                                                           //contexto
//            android.R.style.ThemeOverlay,                                           //Tema
            android.R.style.Theme_DeviceDefault_Light_Dialog,
            DatePickerDialog.OnDateSetListener { DatePicker, Year, Month, Day ->
                dateTextView.text = "Fecha: $Day/${Month+1}/$Year"
                edfecha.setText("Fecha: $Day/${Month+1}/$Year")
            },                                                                      //Listener
            year,                                                                   //Año a mostrar por defecto
            month,                                                                  //Mes  a mostrar por defecto
            dayOfMoth                                                               //dia a mostrar por defecto
            )

        datePicker.show()

      //  Toast.makeText(this, "La fecha de hoy es: $dayOfMoth/$month/$year", Toast.LENGTH_LONG).show()

    }

     /**
     * Ejemplo 5: Time Picker Dialog
     */

     fun showtimePicker(view: View){
         val calendar = Calendar.getInstance()

         val myHour = calendar.get(Calendar.HOUR_OF_DAY)
         val myMinutes   = calendar.get(Calendar.MINUTE)// toma el mes 0 al mes 11

         val timePicker = TimePickerDialog(
             this,
             TimePickerDialog.OnTimeSetListener { timePicker, dtHourOdDay,dpMinutes->
                 edtime.setText("$dtHourOdDay : $dpMinutes")
             },
             myHour,
             myMinutes,
             true
         ).show()

     }

    fun showSnackBar(view: View)
    {
        var mySanckBar : Snackbar = Snackbar.make(main_container,"No Internet conection",Snackbar.LENGTH_LONG)

        mySanckBar.setAction("Retry"){
            Toast.makeText(this,
            "Retry Internet connection",Toast.LENGTH_LONG).show()
        }
        mySanckBar.setTextColor(Color.GREEN)
        mySanckBar.setActionTextColor(Color.YELLOW)
        mySanckBar.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.otromenu,menu)
        return true
//        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item1->Toast.makeText(this,"Item 1: ${item.title}",Toast.LENGTH_LONG).show()
            R.id.item2->Toast.makeText(this,"Item 2: ${item.title}",Toast.LENGTH_LONG).show()
            R.id.item3->Toast.makeText(this,"Item 3: ${item.title}",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)

    }

}