package com.example.iphone.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EquipmentDetail(

    val model: String,
    val release_year: Int,
    val price: Double,
    val general_info: GeneralInfo

):Parcelable