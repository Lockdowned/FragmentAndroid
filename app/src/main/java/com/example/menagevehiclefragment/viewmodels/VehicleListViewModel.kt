package com.example.menagevehiclefragment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.menagevehiclefragment.data.VehicleItem

class VehicleListViewModel: ViewModel() {
    val vehicleList = mutableListOf<VehicleItem>()

    val vehicleListLiveData = MutableLiveData<MutableList<VehicleItem>>(mutableListOf()) // mutableListOf() - что даёт?

    var selectedIndex = MutableLiveData<Int>(0)

    fun selectedItem(index: Int){
        selectedIndex.value = index
    }

    fun loadVehicle(vehicle: MutableList<VehicleItem>){
        vehicleListLiveData.value = vehicle
    }

    fun addVehicle(vehicle: VehicleItem){
        vehicleListLiveData.value!!.add(vehicle)
    }

    fun getVehicleAtPosition(position: Int): VehicleItem{
        return vehicleListLiveData.value!![position]
    }

    fun updateVehicleAtPosition(updatedItem: VehicleItem, position: Int){
        vehicleListLiveData.value!!.set(position, updatedItem)
    }


}