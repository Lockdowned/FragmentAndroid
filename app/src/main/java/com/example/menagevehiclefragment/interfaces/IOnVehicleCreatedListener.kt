package com.example.menagevehiclefragment.interfaces

import com.example.menagevehiclefragment.data.VehicleItem

interface IOnVehicleCreatedListener {
    fun onVehicleCreated(vehicle: VehicleItem?)
}