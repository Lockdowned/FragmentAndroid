package com.example.menagevehiclefragment

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menagevehiclefragment.`object`.InitDefault
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.ActivityMainBinding
import com.example.menagevehiclefragment.fragment.CreateFragment
import com.example.menagevehiclefragment.fragment.EditFragment
import com.example.menagevehiclefragment.fragment.ListFragment
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication
import com.example.menagevehiclefragment.interfaces.IOnVehicleCreatedListener
import com.example.menagevehiclefragment.viewmodels.VehicleListViewModel
import com.example.menagevehiclefragment.viewmodels.VehicleViewModel

class MainActivity : AppCompatActivity(), IOnVehicleCreatedListener {

    private val vehicleListViewModel: VehicleListViewModel by viewModels()
    lateinit var vehicleViewModel: VehicleViewModel

    private lateinit var binding: ActivityMainBinding
    lateinit var listFragment: ListFragment
    lateinit var createFragment: CreateFragment
    lateinit var editFragment: EditFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)  // 1: почему так теперь не работает

        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView) // 1: а так ок

        vehicleViewModel = ViewModelProvider(this).get(VehicleViewModel::class.java)
//        vehicleListViewModel.loadVehicle(InitDefault.initVehicleList(this))
        vehicleListViewModel.vehicleList = InitDefault.initVehicleList(this)

        listFragment = ListFragment()
        createFragment = CreateFragment()
        editFragment = EditFragment()

        listFragment.adaptorItemSelectListener = this::onDeviceItemSelected

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miList -> setCurrentFragment(listFragment)
                R.id.miCreate -> setCurrentFragment(createFragment)
                R.id.miEdit -> setCurrentFragment(editFragment)
            }
            true
        }

        setCurrentFragment(listFragment)
    }

    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment, fragment)
            commit()
        }
    }

//    override fun createVehicle() {
//        binding.bottomNavigationView.selectedItemId = R.id.miCreate
//        setCurrentFragment(createFragment)//hmm
//    }
//
//    override fun updateVehicle(index: Int) {
//        vehicleListViewModel.selectedItem(index)
//        binding.bottomNavigationView.selectedItemId = R.id.miEdit
//        setCurrentFragment(editFragment)
//
//    }
//
//    override fun listVehicle() {
//        binding.bottomNavigationView.selectedItemId = R.id.miEdit
//        setCurrentFragment(editFragment)
//
//    }

    override fun onVehicleCreated(vehicle: VehicleItem?) {
        vehicle?.let {
            listFragment.onVehicleCreated(it)
        }
    }

    private fun onDeviceItemSelected(vehicleItem: VehicleItem) {
        vehicleViewModel.select(vehicleItem)
        setCurrentFragment(listFragment)
    }

}