package com.example.menagevehiclefragment.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menagevehiclefragment.MainActivity
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.ItemShowVehicleBinding
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication
import com.google.android.material.bottomnavigation.BottomNavigationView

class VehicleListAdapter(private var vehicleList: List<VehicleItem>,
                         private val context: MainActivity) :
    RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder>() {

    private var selectedItem: ItemShowVehicleBinding? = null

    inner class VehicleViewHolder(val itemVehicleBinding: ItemShowVehicleBinding)
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
        holder.itemView.setOnClickListener {
            selectedItem = holder.itemVehicleBinding
            var selectedItem = vehicleList[position]
            context.vehicleViewModel.select(selectedItem)
            val bottomMneu = context.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomMneu.selectedItemId = R.id.miEdit
            context.setCurrentFragment(context.listFragment)
            }
        }

}