package com.example.menagevehiclefragment.data

import android.graphics.drawable.Drawable
import java.io.Serializable

data class VehicleItem(
        var img: Drawable?,
        var brandAndModel: String,
        val specification: String,
        var serviceInfo: String
): Serializable