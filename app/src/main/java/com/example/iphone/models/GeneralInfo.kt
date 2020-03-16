package com.example.iphone.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeneralInfo(

    val image: String,
    val stock: Int,
    val origin_country: String

):Parcelable