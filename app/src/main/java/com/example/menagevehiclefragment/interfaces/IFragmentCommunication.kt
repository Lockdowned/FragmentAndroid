package com.example.menagevehiclefragment.interfaces

import com.example.menagevehiclefragment.data.VehicleItem

interface IFragmentCommunication {
    fun createVehicle()
    fun updateVehicle(index: Int)
    fun listVehicle()
    fun onVehicleCreated(device: VehicleItem?)
}