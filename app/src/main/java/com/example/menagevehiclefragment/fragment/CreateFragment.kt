package com.example.menagevehiclefragment.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.activityViewModels
import com.example.menagevehiclefragment.R
import com.example.menagevehiclefragment.data.VehicleItem
import com.example.menagevehiclefragment.databinding.FragmentCreateBinding
import com.example.menagevehiclefragment.databinding.FragmentEditBinding
import com.example.menagevehiclefragment.interfaces.IFragmentCommunication
import com.example.menagevehiclefragment.interfaces.IOnVehicleCreatedListener
import com.example.menagevehiclefragment.viewmodels.VehicleListViewModel
import java.lang.RuntimeException

class CreateFragment(val navigation: IFragmentCommunication) : Fragment(R.layout.fragment_create) {

    private var imgUri: Uri? = null
    private val SELECT_IMAGE_CLICK = 2

    private  var _binding: FragmentCreateBinding? = null
    private val binding get() =  _binding!!

    private var newVehicle: VehicleItem? = null
    private lateinit var fContext: Context
    private lateinit var mListener: IOnVehicleCreatedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext = context
        if (context is IOnVehicleCreatedListener){
            mListener = context
        }
//        else {
//            throw RuntimeException(context.toString() + " must implement IOnVehicleCreatedListener")
//        }
    }

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
//        newVehicle = VehicleItem(null, "", "" , "")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
//            editTextBrand.addTextChangedListener(object : TextWatcher{
//                override fun beforeTextChanged(s: CharSequence?, start:
//                Int, count: Int, after: Int) {}
//
//                override fun onTextChanged(brandValue: CharSequence?, start:
//                Int, before: Int, count: Int) {
//                    newVehicle?.brandAndModel = brandValue.toString()
//                }
//
//                override fun afterTextChanged(s: Editable?) {}
//            })

            imageCreateNewVehicle.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, SELECT_IMAGE_CLICK)
            }

            btnSaveOnCreateAct.setOnClickListener {
                if ((editTextBrand.text.toString() == "")
                        || (editTextModel.text.toString() == "")
                        || (editTextYearRel.text.toString() == "")) {
                    Toast.makeText(fContext, "Please fill in the lines marked *",
                            Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                val checkedRadioButtonEngineId = radioGroupEngine.checkedRadioButtonId
                val engine: RadioButton?  = it.findViewById(checkedRadioButtonEngineId)
                val checkedRadioButtonGearId = radioGroupGear.checkedRadioButtonId
                val gear: RadioButton? = it.findViewById(checkedRadioButtonGearId)

                val textBrandAndModel = "${editTextBrand.text.toString()} " +
                        "${editTextModel.text.toString()} ${editTextYearRel.text.toString()}"




                newVehicle = VehicleItem(R.drawable.default_car.toDrawable(), textBrandAndModel, "", "")
                newVehicle?.let {
                    Log.d("VehicleAddFragment", it.toString())
                    mListener.onVehicleCreated(newVehicle)
                }
            }

        }


    }
}