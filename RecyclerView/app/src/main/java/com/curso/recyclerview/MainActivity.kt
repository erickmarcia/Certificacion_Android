package com.curso.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curso.recyclerview.data.PlaceListAdapter
import com.curso.recyclerview.model.Place
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  var adapter: PlaceListAdapter ?= null
    private  var countryList: ArrayList<Place>?=null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList!!,this)

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = adapter

        var countryNameList:Array<String> = arrayOf("canada","USA","Mexico","Colombia","Malaysia",
            "Singapore","Turke","Nicaragua","India","Italy",
            "Tunisia","Chile","Argentina","Spain","Per")
        var cityNameList:Array<String> = arrayOf("ottawa","washintong, D.C",
            "Mexico City","Bogota","Kulua lumpur","Singapure","Ankara","Managua","New Delhi","Rome",
            "Tunis","Santiago","Buenos Aires","Madrid","Lima")


        for (i in 0..countryNameList.size-1)
        {
            var place = Place()
            place.CountryName = countryNameList[i]
            place.CityName = cityNameList[i]
            countryList?.add(place)
        }
            adapter!!.notifyDataSetChanged()

    }
}