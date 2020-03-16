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

class iPhoneAdapter(private val iphone: ArrayList<EquipmentDetail>, private val listener: OnClickListener) :
    RecyclerView.Adapter<iPhoneAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private val listener: OnClickListener) : RecyclerView.ViewHolder(itemView) {

        lateinit var image: ImageView
        lateinit var title: TextView

        fun bindData(iphone: EquipmentDetail) {
            image = itemView.findViewById(R.id.imageView)
            title = itemView.findViewById(R.id.textView)
            title.text = iphone.model

            image.setOnClickListener {
                listener.clickImage(iphone)
            }

            Glide.with(itemView).load(iphone.general_info.image).into(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.style_cardview, parent, false)

        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return iphone.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(iphone[position])
    }

}