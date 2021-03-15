package com.example.menagevehiclefragment

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.menagevehiclefragment.`object`.InitDefault
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.ActivityMainBinding
import com.example.menagevehiclefragment.fragment.CreateFragment
import com.example.menagevehiclefragment.fragment.EditFragment
import com.example.menagevehiclefragment.fragment.ListFragment
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication
import com.example.menagevehiclefragment.viewmodels.VehicleListViewModel

class MainActivity : AppCompatActivity(), IFragmentCommunication {

    private val vehicleListViewModel: VehicleListViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var listFragment: ListFragment
    private lateinit var createFragment: CreateFragment
    private lateinit var editFragment: EditFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)  // 1: почему так теперь не работает

        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView) // 1: а так ок

        vehicleListViewModel.loadVehicle(InitDefault.initVehicleList(this))

        listFragment = ListFragment(this)
        createFragment = CreateFragment(this)
        editFragment = EditFragment(this)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miList -> setCurrentFragment(listFragment)
                R.id.miCreate -> setCurrentFragment(createFragment)
                R.id.miEdit -> setCurrentFragment(editFragment)
            }
            true
        }




    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment, fragment)
            commit()
        }
    }

    override fun createVehicle() {
        binding.bottomNavigationView.selectedItemId = R.id.miCreate
        setCurrentFragment(createFragment)//hmm
    }

    override fun updateVehicle(index: Int) {
        vehicleListViewModel.selectedItem(index)
        binding.bottomNavigationView.selectedItemId = R.id.miEdit
        setCurrentFragment(editFragment)

    }

    override fun listVehicle() {
        binding.bottomNavigationView.selectedItemId = R.id.miEdit
        setCurrentFragment(editFragment)

    }

    override fun onVehicleCreated(device: VehicleItem?) {
        TODO("Not yet implemented")
    }
}