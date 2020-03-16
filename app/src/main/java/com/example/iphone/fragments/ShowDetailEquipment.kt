package com.example.iphone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.iphone.OBJECT_PHONE

import com.example.iphone.R
import com.example.iphone.models.EquipmentDetail

class ShowDetailEquipment : Fragment() {
    private var equipment: EquipmentDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            equipment = it.getParcelable(OBJECT_PHONE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_detail_equipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view.findViewById<TextView>(R.id.text_equipment_detail).text = equipment!!.name
        view.findViewById<TextView>(R.id.tv_detail_model).text = equipment!!.model
        view.findViewById<TextView>(R.id.tv_detail_releaseYear).text =
            "Año de Salida: ${equipment!!.release_year}"
        view.findViewById<TextView>(R.id.tv_detail_price).text = "Precio: ${equipment!!.price}"
        view.findViewById<TextView>(R.id.tv_detail_price).text = "Precio: ${equipment!!.price}"
        view.findViewById<TextView>(R.id.tv_detail_stock).text =
            "Cantidad en bodega: ${equipment!!.general_info.stock}"
        view.findViewById<TextView>(R.id.tv_detail_countryOrigin).text =
            "Pais de Origen: ${equipment!!.general_info.origin_country}"

        Glide.with(view).load(equipment!!.general_info.image)
            .into(view.findViewById(R.id.image_detail))
    }

    companion object {
        @JvmStatic
        fun newInstance(equipoDetail: EquipmentDetail) = ShowDetailEquipment().apply {
            arguments = Bundle().apply {
                putParcelable(OBJECT_PHONE, equipoDetail)
            }
        }
    }
}