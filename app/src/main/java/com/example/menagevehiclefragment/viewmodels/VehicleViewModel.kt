package com.example.menagevehiclefragment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.menagevehiclefragment.data.VehicleItem

class VehicleViewModel: ViewModel() {
    val selected = MutableLiveData<VehicleItem>()

    fun select(vehicle: VehicleItem){
        selected.value = vehicle
    }
}