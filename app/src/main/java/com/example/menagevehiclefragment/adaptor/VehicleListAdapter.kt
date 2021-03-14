package com.example.menagevehiclefragment.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.ItemShowVehicleBinding

class VehicleListAdapter(private var vehicleList: List<VehicleItem>):
    RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(private val itemVehicleBinding: ItemShowVehicleBinding)
        : RecyclerView.ViewHolder(itemVehicleBinding.root){

        fun bind(vehicleItem: VehicleItem){
            itemVehicleBinding.textBrandsandModelItem.text = vehicleItem.brandAndModel
            itemVehicleBinding.textSpecificationItem.text = vehicleItem.specification
            itemVehicleBinding.textServInfItem.text = vehicleItem.serviceInfo
            itemVehicleBinding.imageVehicleItem.setImageDrawable(vehicleItem.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemVehicleBinding = ItemShowVehicleBinding.inflate(layoutInflater, parent, false)
        return VehicleViewHolder(itemVehicleBinding)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(vehicleList[position])
    }

}