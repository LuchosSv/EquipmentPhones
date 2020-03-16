package com.example.iphone.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EquipmentData(

    val phones: List<EquipmentDetail>,
    val tablets: List<EquipmentDetail>,
    val Phablets: List<EquipmentDetail>

):Parcelable