package com.example.menagevehiclefragment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.`object`.InitDefault
import com.example.menagevehiclefragment.adaptor.VehicleListAdapter
import com.example.menagevehiclefragment.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private  var _binding: FragmentListBinding? = null
    private val binding get() =  _binding!!

    private lateinit var vehicleListAdapter: VehicleListAdapter
    private lateinit var locContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        locContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
//        return inflater.inflate(R.layout.fragment_list, container, false) //что тут куда?
        _binding = FragmentListBinding.inflate(inflater, container, false) //что тут куда?
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        vehicleListAdapter = VehicleListAdapter(InitDefault.initVehicleList(activity!!.applicationContext))
        vehicleListAdapter = VehicleListAdapter(InitDefault.initVehicleList(locContext))

        binding.recyclerViewMainFragment.adapter = vehicleListAdapter
        binding.recyclerViewMainFragment.layoutManager = LinearLayoutManager(locContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}