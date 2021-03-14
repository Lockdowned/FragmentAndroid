package com.example.menagevehiclefragment.`object`

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.data.VehicleItem

object InitDefault {
    fun initVehicleList(context: Context): MutableList<VehicleItem>{
        return mutableListOf(
            VehicleItem(
                ContextCompat.getDrawable(context, R.drawable.mini_cooper_angularfront),
                "Mini Cooper 2009",
                "1000 petrol, BS 2, 100 hp",
                "Run 500 km, blink led"
            ),
            VehicleItem(
                ContextCompat.getDrawable(context, R.drawable.honda_accord),
                "Honda Accord 2011",
                "1800 diesel, DG 4, 130 hp",
                "Run 1200 km, need change wheels"
            )
        )
    }
}