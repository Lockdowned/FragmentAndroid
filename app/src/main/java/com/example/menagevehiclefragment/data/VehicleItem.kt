package com.example.menagevehiclefragment.data

import android.graphics.drawable.Drawable
import java.io.Serializable

data class VehicleItem(
        var img: Drawable?,
        val brandAndModel: String,
        val specification: String,
        var serviceInfo: String
): Serializable