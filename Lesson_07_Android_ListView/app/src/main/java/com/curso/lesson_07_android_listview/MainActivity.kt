package com.curso.lesson_07_android_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryname:Array<String> = arrayOf("Canada","USA","Mexico","Colombia","Malaysia",
            "Singapore","Turke","Nicaragua","India","Italy","Tunisia","Chile","Argentina",
            "Spain","Peru")
        var countryAdapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,countryname)
        listview7.adapter = countryAdapter

        listview7.setOnItemClickListener{adapterView,view, i,l -> var ItemName:String = listview7.getItemAtPosition(i).toString()
        Toast.makeText(this,"$ItemName",Toast.LENGTH_SHORT).show()}

    }
}