package com.example.menagevehiclefragment.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.menagevehiclefragment.MainActivity
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.`object`.UriToDrawableConverter
import com.example.menagevehiclefragment.adaptor.VehicleListAdapter
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.FragmentEditBinding
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication
import com.example.menagevehiclefragment.viewmodels.VehicleListViewModel
import com.example.menagevehiclefragment.viewmodels.VehicleViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class EditFragment() : Fragment(R.layout.fragment_edit) {

    private var imgUri: Uri? = null
    private val SELECT_IMAGE_CLICK = 3

    private  var _binding: FragmentEditBinding? = null
    private val binding get() =  _binding!!

//    private val vehicleListViewModel: VehicleListViewModel by activityViewModels()
    private lateinit var selectedItem: VehicleItem

    private lateinit var vehicleViewModel: VehicleViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            vehicleViewModel = ViewModelProvider(it!!).get(VehicleViewModel::class.java)
            binding.run {
                tvBrandModelSpecInEditFrag.text = vehicleViewModel.selected.value?.brandAndModel.plus(vehicleViewModel.selected.value?.specification)
                etServiceInfoEditFragment.setText(vehicleViewModel.selected.value?.serviceInfo)
                ivEditFragment.setImageDrawable(vehicleViewModel.selected.value?.img)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
//        return inflater.inflate(R.layout.fragment_edit, container, false)
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var selItemId = vehicleListViewModel.selectedIndex.value!!
//        selectedItem = vehicleListViewModel.getVehicleAtPosition(selItemId)

        binding.run {
//            tvBrandModelSpecInEditFrag.text = selectedItem.brandAndModel.plus(selectedItem.specification)
//            etServiceInfoEditFragment.setText(selectedItem.serviceInfo)
//            ivEditFragment.setImageDrawable(selectedItem.img)

            btnEditOnEditFrag.setOnClickListener {
//                selectedItem.serviceInfo = etServiceInfoEditFragment.text.toString()
////                vehicleListViewModel.updateVehicleAtPosition(selectedItem,)
//                navigation.listVehicle()
                val mainActivity = activity as MainActivity
                val bottomMenu = mainActivity.
                findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                bottomMenu.selectedItemId = R.id.miList
                mainActivity.setCurrentFragment(mainActivity.listFragment)
            }

            ivEditFragment.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*" // это для чего
                startActivityForResult(intent, SELECT_IMAGE_CLICK)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_IMAGE_CLICK){
            imgUri = data?.data
            binding.ivEditFragment.setImageURI(imgUri)
            vehicleViewModel.selected.value?.img = UriToDrawableConverter.uriToDrawable(imgUri.toString(), requireContext())
        }
    }

}