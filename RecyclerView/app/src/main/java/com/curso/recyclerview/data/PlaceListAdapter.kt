package com.curso.recyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.curso.recyclerview.R
import com.curso.recyclerview.model.Place

class PlaceListAdapter(private val list: ArrayList<Place>, private val context:Context):RecyclerView.Adapter<PlaceListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        position: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        return  ViewHolder(view)
        }

    override fun onBindViewHolder(holder: PlaceListAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(place: Place) {
            var country:TextView=itemView.findViewById(R.id.country_ID) as TextView
            var city:TextView=itemView.findViewById(R.id.city_ID) as TextView
            country.text = place.CountryName
            city.text = place.CityName
        }
    }
}