package com.example.menagevehiclefragment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.menagevehiclefragment.data.VehicleItem

class VehicleListViewModel: ViewModel() {
    val devicesListLiveData = MutableLiveData<MutableList<VehicleItem>>(mutableListOf()) // mutableListOf() - что даёт?
}