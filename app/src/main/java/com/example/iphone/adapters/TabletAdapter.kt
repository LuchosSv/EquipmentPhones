package com.example.iphone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iphone.R
import com.example.iphone.interfaces.OnClickListener
import com.example.iphone.models.EquipmentDetail

class TabletAdapter (private val tablet: ArrayList<EquipmentDetail>, private val listener: OnClickListener) :
    RecyclerView.Adapter<TabletAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View, private val listener: OnClickListener) : RecyclerView.ViewHolder(itemView){

        lateinit var image: ImageView
        lateinit var title: TextView

        fun bindData(tablet: EquipmentDetail) {

            image = itemView.findViewById(R.id.imageView)
            title = itemView.findViewById(R.id.textView)

            image.setOnClickListener {
                listener.clickImage(tablet)
            }

            title.text = tablet.model
            Glide.with(itemView).load(tablet.general_info.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.style_cardview, parent, false)

        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return tablet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(tablet[position])
    }

}